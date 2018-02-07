package GUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import GUI.ApplicationWindow.ButtonListener;
import Server.Card;

public class CommunicationCenter {

	Client client;
	ApplicationWindow aW;

	Socket socket;
	DataInputStream in;
	DataOutputStream out;

	public CommunicationCenter(Client c, ApplicationWindow aW) throws UnknownHostException, IOException {

		System.out.println("Connecting...");
		socket = new Socket("localhost", Server.Port.port);
		System.out.println("Connected.");
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());

		this.client = c;
		this.aW = aW;

		initListeners();

		readFromServer();

	}

	private void readFromServer() {

		new Thread(() -> {

			while (true) {
				try {
					String protocol = in.readUTF();
					System.out.println(protocol);
					Scanner sc = new Scanner(protocol);
					sc.useDelimiter("#");
					String s = sc.next();
					System.out.println(s);
					if (s.equals("cards")) {
						client.cards.clear();
						int numberOfCards = sc.nextInt();
						for (int i = 0; i<numberOfCards; i++) {
							client.cards.add(new Card(sc.nextInt(), sc.next()));
						}
						aW.printCards();
						continue;
					} else if (s.equals("beginningDealerCards")) {
						client.dealer.cards.clear();
						int numberOfCards = sc.nextInt();
						for (int i = 0; i<numberOfCards; i++) {
							client.dealer.cards.add(new Card(sc.nextInt(), sc.next()));
						}
						aW.printBeinningDealerCards();
						continue;
					} else if (s.equals("turn")) {
						aW.tablePanel.hit.setEnabled(true);
						aW.tablePanel.stand.setEnabled(true);
						aW.tablePanel.dble.setEnabled(true);
						if (client.cards.get(0).value == client.cards.get(1).value) {
							aW.tablePanel.split.setEnabled(true);
						}
					} else if (s.equals("over21")) {
						client.bePatientflag = true;
						aW.tablePanel.over21();
						continue;
					} else if (s.equals("BlackJack")) {
						client.bePatientflag = true;
						aW.tablePanel.BlackJack();
						continue;
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}).start();

	}

	public void initListeners() {

		aW.setEnterListener(new ButtonListener() {

			@Override
			public void onClick() {
				new Thread(new Runnable() {

					@Override
					public void run() {

						try {
							if (client.name != null && client.money != 0) {
								out.writeUTF("newuser#" + client.name + "#" + client.money);
							}

						} catch (IOException e) {

							e.printStackTrace();
						}

					}
				}).start();

				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						aW.playingTable();
					}
				});

			}
		});

		aW.setBetListener(new ButtonListener() {

			@Override
			public void onClick() {
				new Thread(new Runnable() {

					@Override
					public void run() {

						try {
							if (client.bet != 0) {
								client.money -= client.bet;
								out.writeUTF("newbet#" + client.name + "#" + client.money + "#" + client.bet);
								
							}

						} catch (IOException e) {

							e.printStackTrace();
						}

					}
				}).start();

				aW.betPane.setVisible(false);

			}
		});

		aW.setSkipListener(new ButtonListener() {

			@Override
			public void onClick() {
				new Thread(new Runnable() {

					@Override
					public void run() {

						try {
							if (client.playing == false) {

								out.writeUTF("skip#" + client.name);
							}

						} catch (IOException e) {

							e.printStackTrace();
						}

					}
				}).start();

				aW.betPane.setVisible(false);

			}
		});
		
		aW.setHitListener(new ButtonListener() {

			@Override
			public void onClick() {
				
				try {
					out.writeUTF("hit#");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				aW.printCards();
				
				

			}
		});
		
		aW.setStandListener(new ButtonListener() {

			@Override
			public void onClick() {
				

			}
		});
		
		aW.setDbleListener(new ButtonListener() {

			@Override
			public void onClick() {
				try {
					out.writeUTF("dble#");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				aW.printCards();

			}
		});
		
		aW.setSplitListener(new ButtonListener() {

			@Override
			public void onClick() {
				

			}
		});

	}

}

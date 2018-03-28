package GUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
					if (s.equals("initialWaiting")) {
						client.haveToWait = true;
						continue;
					}
					if (s.equals("tooManyPlayers")) {
						client.notAccepted = true;
						continue;
					}
					if (s.equals("cards")) {
						client.cards.clear();
						int numberOfCards = sc.nextInt();
						for (int i = 0; i < numberOfCards; i++) {
							client.cards.add(new Card(sc.nextInt(), sc.next()));
						}
						aW.tablePanel.printCards();
						continue;
					} else if (s.equals("splitCards")) {
						client.splitCards.clear();
						int numberOfCards = sc.nextInt();
						for (int i = 0; i < numberOfCards; i++) {
							client.splitCards.add(new Card(sc.nextInt(), sc.next()));
						}
						aW.tablePanel.printSplitCards();
						continue;
					} else if (s.equals("players")) {
						client.players.clear();
						int numberOfPlayers = sc.nextInt();
						for (int i = 0; i < numberOfPlayers; i++) {
							client.players.add(new Client(sc.next(), sc.nextInt(), sc.nextInt()));
						}
						aW.tablePanel.printPlayers();
						continue;
					} else if (s.equals("turnInfo")) {
						aW.tablePanel.turnInfo(sc.nextInt());
						continue;
					} else if (s.equals("beginningDealerCards")) {
						client.dealer.cards.clear();
						int numberOfCards = sc.nextInt();
						for (int i = 0; i < numberOfCards; i++) {
							client.dealer.cards.add(new Card(sc.nextInt(), sc.next()));
						}
						aW.tablePanel.printBeginningDealerCards();
						continue;
					} else if (s.equals("dealerCards")) {
						client.dealer.cards.clear();
						client.dealer.points = sc.nextInt();
						int numberOfCards = sc.nextInt();
						for (int i = 0; i < numberOfCards; i++) {
							client.dealer.cards.add(new Card(sc.nextInt(), sc.next()));
						}
						System.out.println("in ccccccccccccccccccccccc");
						aW.tablePanel.printDealerCards();
						continue;
					} else if (s.equals("turn")) {
						aW.tablePanel.hit.setEnabled(true);
						aW.tablePanel.stand.setEnabled(true);
						aW.tablePanel.dble.setEnabled(true);
						if (client.cards.get(0).value == client.cards.get(1).value) {
							aW.tablePanel.split.setEnabled(true);
						}
					} else if (s.equals("over21")) {

						if ((client.splitCards.size() == 0) || (client.playingSplitCards)) {
							client.bePatientflag = true;
							aW.tablePanel.hit.setEnabled(false);
							aW.tablePanel.stand.setEnabled(false);
							aW.tablePanel.dble.setEnabled(false);
							aW.tablePanel.over21();
							client.playingSplitCards = false;
						} else {
							aW.tablePanel.over21BeforeSplitGame();
							aW.tablePanel.splitGame();
							splitGameHorn();
						}
						continue;

					} else if (s.equals("BlackJack")) {
						if ((client.splitCards.size() == 0) || (client.playingSplitCards)) {
							client.bePatientflag = true;
							aW.tablePanel.hit.setEnabled(false);
							aW.tablePanel.stand.setEnabled(false);
							aW.tablePanel.dble.setEnabled(false);
							aW.tablePanel.BlackJack();
							client.playingSplitCards = false;
						} else {
							aW.tablePanel.BlackJackBeforeSplitGame();
							aW.tablePanel.splitGame();
							splitGameHorn();
						}
						continue;
					} else if (s.equals("over21Loss")) {
						aW.newTable();
						client.money = sc.nextInt();
						client.bet = 0;
						aW.tablePanel.over21Loss();
						continue;
					} else if (s.equals("equal")) {
						aW.newTable();
						client.money = sc.nextInt();
						client.bet = 0;
						aW.tablePanel.equal();
						continue;
					} else if (s.equals("blackJackWin")) {
						aW.newTable();
						client.money = sc.nextInt();
						client.bet = 0;
						aW.tablePanel.blackJackWin();
						continue;
					} else if (s.equals("loss")) {
						aW.newTable();
						client.money = sc.nextInt();
						client.bet = 0;
						aW.tablePanel.loss();
						continue;
					} else if (s.equals("win")) {
						aW.newTable();
						client.money = sc.nextInt();
						client.bet = 0;
						aW.tablePanel.win();
						continue;
					} else if (s.equals("splitPotCalculation")) {
						aW.newTable();
						client.money = sc.nextInt();
						client.bet = 0;
						client.splitCards.clear();
						aW.tablePanel.splitPotCalculation();
						continue;
					} else if (s.equals("wasOutside")) {
						client.money = sc.nextInt();
						client.bet = 0;
						client.playingSplitCards = false;
						aW.newTable();
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
								if (client.haveToWait) {
									aW.tablePanel.initialWaiting();
									client.haveToWait = false;
								}
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
							// if (client.playing != false) {

							out.writeUTF("skip#" + client.name);
							System.out.println("dupa ce trimit skkkkkkkkkkkkip");
							// }

						} catch (IOException e) {

							e.printStackTrace();
						}

					}
				}).start();

				aW.betPane.setVisible(false);
				aW.tablePanel.printInfo();

			}
		});

		aW.setHitListener(new ButtonListener() {

			@Override
			public void onClick() {

				try {
					out.writeUTF("hit#");
				} catch (IOException e) {

					e.printStackTrace();
				}

				if (client.playingSplitCards) {
					
					aW.tablePanel.printSplitCards();
					
				} else {

					aW.tablePanel.printCards();
				}
			}
		});

		aW.setStandListener(new ButtonListener() {

			@Override
			public void onClick() {
				try {
					out.writeUTF("stand#");

				} catch (IOException e) {
					e.printStackTrace();
				}

				if (client.splitCards.size() == 0) {
					aW.tablePanel.hit.setEnabled(false);
					aW.tablePanel.stand.setEnabled(false);
					aW.tablePanel.dble.setEnabled(false);
				} else {
					if (client.playingSplitCards) {
						aW.tablePanel.hit.setEnabled(false);
						aW.tablePanel.stand.setEnabled(false);
						aW.tablePanel.dble.setEnabled(false);
						client.playingSplitCards = false;
					} else {
						client.playingSplitCards = true;
						aW.tablePanel.splitGame();
						splitGameHorn();
					}

				}

			}
		});

		aW.setDbleListener(new ButtonListener() {

			@Override
			public void onClick() {
				try {
					out.writeUTF("dble#");

				} catch (IOException e) {
					e.printStackTrace();
				}

				if (client.splitCards.size() == 0) {
					
					client.money -= client.bet;
					client.bet *= 2;
					aW.tablePanel.hit.setEnabled(false);
					aW.tablePanel.stand.setEnabled(false);
					aW.tablePanel.dble.setEnabled(false);
					aW.tablePanel.printCards();
					
				} else {
					
					client.money -= client.bet / 2;
					client.bet += client.bet / 2;
					
					if (client.playingSplitCards) {
						aW.tablePanel.hit.setEnabled(false);
						aW.tablePanel.stand.setEnabled(false);
						aW.tablePanel.dble.setEnabled(false);
						aW.tablePanel.printSplitCards();
						client.playingSplitCards = false;
					} else {
						client.playingSplitCards = true;
						aW.tablePanel.splitGame();
						splitGameHorn();
					}

				}

			}
		});

		aW.setSplitListener(new ButtonListener() {

			@Override
			public void onClick() {
				try {
					out.writeUTF("split#");
				} catch (IOException e) {

					e.printStackTrace();
				}
				
				aW.tablePanel.split.setEnabled(false);
				aW.tablePanel.printSplitCards();

			}
		});

		aW.setCashOutListener(new ButtonListener() {

			@Override
			public void onClick() {

				try {
					out.writeUTF("cashedOut#");

				} catch (IOException e) {
					e.printStackTrace();
				}

				client.playing = false;
				client.bet = 0;
				aW.frmBlackjackMultiplayer.dispose();
				JOptionPane.showMessageDialog(new JPanel(),
						"Your cash went to your bank account. On the next time! Bye Bye!");

			}
		});

	}

	protected void splitGameHorn() {

		try {
			out.writeUTF("splitGameHorn#");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

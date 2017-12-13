package GUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.SwingUtilities;

import GUI.ApplicationWindow.ButtonListener;

public class ComunicationCenter {

	Client client;
	ApplicationWindow aW;

	Socket socket;
	DataInputStream in;
	DataOutputStream out;

	public ComunicationCenter(Client c, ApplicationWindow aW) throws UnknownHostException, IOException {

		System.out.println("Connecting...");
		socket = new Socket("localhost", Server.Port.port);
		System.out.println("Connected.");
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());

		this.client = c;
		this.aW = aW;

		initListeners();

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

	}

}

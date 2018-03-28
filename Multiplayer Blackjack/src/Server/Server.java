package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Server.BlackJackTheBrain.UserListener;

public class Server {

	static ServerSocket serverSocket;
	static Socket socket;
	static DataOutputStream out;
	static ArrayList<User> users = new ArrayList<User>();
	static DataInputStream in;
	static ArrayList<User> newUsers = new ArrayList<User>();

	interface ClientListener {

		public void onDeconnection();

	}

	public static void main(String[] args) throws Exception {

		System.out.println("Starting server...");
		serverSocket = new ServerSocket(Port.port);
		System.out.println("Server started...");

		users.add(new User("Dealer", 10000000));

		Thread logging = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {

					try {
						socket = serverSocket.accept();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
					System.out.println("Connection from:" + socket.getInetAddress());
					try {
						out = new DataOutputStream(socket.getOutputStream());
					} catch (IOException e1) {

						e1.printStackTrace();
					}
					try {
						in = new DataInputStream(socket.getInputStream());
					} catch (IOException e1) {

						e1.printStackTrace();
					}
					User user = new User(out, in);

					initListeners(user);

					if (users.size() == 1) {
						users.add(user);
					} else {
						if ((users.size() >= 2) && ((users.size() + newUsers.size()) < 6)) {
							newUsers.add(user);
							user.initialWaiting();
						} else {
							user.tooManyPlayers();
							System.out.println("Ne pare rau, masa este deja ocupata. Va rugam sa mai asteptati.");
							continue;
						}
					}

					Thread thread = new Thread(user);
					thread.start();

					System.out.println(users);

				}
			}

		});

		logging.start();
		
		BlackJackTheBrain blackJack = new BlackJackTheBrain();

		while (true) {

			if ((users.size() > 1) && blackJack.ended) {
				blackJack = new BlackJackTheBrain(users);
				users.addAll(newUsers);
				newUsers.clear();
				Thread.sleep(1000);
			}

		}

	}

	private static void initListeners(User user) {

		user.userRemover = new ClientListener() {

			@Override
			public void onDeconnection() {

				users.remove(user);

			}

		};

	}

}

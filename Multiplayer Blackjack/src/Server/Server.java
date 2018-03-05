package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	interface ServerListener {
		void onMessage(String name, String m);

	}

	static ServerSocket serverSocket;
	static Socket socket;
	static DataOutputStream out;
	static ArrayList<User> users = new ArrayList<User>();
	static DataInputStream in;
	static ArrayList<User> newUsers = new ArrayList<User>();

	public static void main(String[] args) throws Exception {

		System.out.println("Starting server...");
		serverSocket = new ServerSocket(Port.port);
		System.out.println("Server started...");

		users.add(new User("Dealer", 1000000));

		Thread logging = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {

					try {
						socket = serverSocket.accept();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("Connection from:" + socket.getInetAddress());
					try {
						out = new DataOutputStream(socket.getOutputStream());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						in = new DataInputStream(socket.getInputStream());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					User user = new User(out, in, new ServerListener() {

						@Override
						public void onMessage(String name, String m) {
							System.out.println("in listener");

							for (User u : users) {
								System.out.println("in listener in for in if");
								try {
									System.out.println("in listener in for in if in try");
									u.out.writeUTF(name + ": " + m);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println("in listener in for in if after try");
							}
						}

					});

					if (users.size() == 1) {
						users.add(user);
					} else { 
						if ((users.size() >= 2) && ((users.size() + newUsers.size()) < 6)) {
							newUsers.add(user);
						} else {
							if ((users.size() + newUsers.size()) > 5) {
								System.out.println("Ne pare rau, masa este deja ocupata. Va rugam sa mai asteptati.");
								continue;
							}
						}
					}

					Thread thread = new Thread(user);
					thread.start();

					System.out.println(users);

				}
			}

		});

		logging.start();

		BlackJackTheBrain blackJack;

		while (true) {
			if ((users.size() > 1) && (users.get(1).name != null)) {
				System.out.println("am incepuuuuuuuuuuuuuuuuut joc nou");
				blackJack = new BlackJackTheBrain(users);
				users.addAll(newUsers);
				newUsers.clear();
				break;
			}
		}

		blackJack = new BlackJackTheBrain();

		while (true) {

			if ((users.size() > 1) && blackJack.ended) {
				blackJack = new BlackJackTheBrain(users);
				users.addAll(newUsers);
				newUsers.clear();
			}

		}

	}

}

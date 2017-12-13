package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

class User implements Runnable {

	DataOutputStream out;
	DataInputStream in;
	// Users[] user = new Users[10];
	Server.ServerListener listener;
	String name;
	int money;
	int bet;

	public User(DataOutputStream out, DataInputStream in, Server.ServerListener listener) {
		this.out = out;
		this.in = in;
		this.listener = listener;
	}

	@Override
	public void run() {

		while (true) {
			try {
				String protocol = in.readUTF();
				System.out.println(protocol);
				Scanner sc = new Scanner(protocol);
				sc.useDelimiter("#");
				String s = sc.next();
				System.out.println(s);
				if (s.equals("newuser")) {
					this.name = sc.next();
					System.out.println(this.name);
					try {
						this.money = sc.nextInt();
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
					System.out.println(this.money);
					break;
				}/*else if () {
					
				}*/

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		while (bet == 0) {
			try {
				String protocol = in.readUTF();
				System.out.println(protocol);
				Scanner sc = new Scanner(protocol);
				sc.useDelimiter("#");
				String s = sc.next();
				System.out.println("in bet");
				if (s.equals("newbet")) {
					if (this.name.equals(sc.next())) {
					System.out.println(this.name);
					try {
						this.money = sc.nextInt();
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
					System.out.println(this.money);
					try {
						this.bet = sc.nextInt();
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
					System.out.println(this.bet);
					break;
					}
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public String toString() {
		return "Name: " + name + "; money: " + money + "; bet: " + bet;
	}

}
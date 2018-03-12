package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;

import Server.BlackJackTheBrain.UserListener;
import Server.Server.ClientListener;

class User implements Runnable {

	DataOutputStream out;
	DataInputStream in;
	Server.ServerListener listener;

	String name;
	int money;
	int bet;
	boolean playing;
	ArrayList<Card> cards;
	int points;

	UserListener cardGiver;
	ClientListener userRemover;

	public User(DataOutputStream out, DataInputStream in, Server.ServerListener listener) {
		this.out = out;
		this.in = in;
		this.listener = listener;
		this.playing = true;
		cards = new ArrayList<>();
	}

	public User(String name, int money) {
		this.name = name;
		this.money = money;
		this.playing = true;
		cards = new ArrayList<>();
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
					continue;
				} else if (s.equals("newbet")) {
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
						continue;
					}
				} else if (s.equals("skip")) {
					if (this.name.equals(sc.next())) {
						System.out.println(this.playing);
						try {
							this.playing = false;
							this.bet = -1;
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
						System.out.println(this.bet);
						continue;
					}
				} else if (s.equals("hit")) {

					cardGiver.onCommand();
					sendCards();

					if (this.points > 21) {
						try {
							out.writeUTF("over21#");
							System.out.println("in 21");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.playing = false;
						continue;
					}
					;
					if (this.points == 21) {
						try {
							out.writeUTF("BlackJack#");
							System.out.println("in 21---2");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.playing = false;
						continue;
					} else
						continue;

				} else if (s.equals("stand")) {
					this.playing = false;
					continue;

				} else if (s.equals("dble")) {

					this.money -= bet;
					this.bet *= 2;

					cardGiver.onCommand();
					sendCards();
					this.playing = false;

					if (this.points > 21) {
						try {
							out.writeUTF("over21#");
							System.out.println("in 21");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						continue;
					}
					;
					if (this.points == 21) {
						try {
							out.writeUTF("BlackJack#");
							System.out.println("in 21---2");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						continue;
					} else
						continue;

				} else if (s.equals("split")) {
					if (this.name.equals(sc.next())) {

						continue;
					}
				}
				
			} catch (SocketException s1) {
				userRemover.onDeconnection();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public void sendCards() {

		String toSend = "cards#" + cards.size() + "#";
		for (Card c : cards) {
			toSend = toSend + c.toString();
		}
		try {
			out.writeUTF(toSend);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void turn() {

		try {
			out.writeUTF("turn#");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendBeginningDealerCards(User dealer) {

		String toSend = "beginningDealerCards#" + dealer.cards.size() + "#";

		for (Card c : dealer.cards) {
			toSend = toSend + c.toString();
		}
		try {
			out.writeUTF(toSend);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int pointsCalculator() {

		int points = 0;
		int aces = 0;

		for (Card c : cards) {
			if (c.value >= 10) {
				points += 10;
			} else {
				points += c.value;
			}

			if (c.value == 1) {
				points += 10;
				aces++;
			}
		}
		;

		if ((points > 21) && (aces > 0)) {
			for (int i = 0; i < aces; i++) {
				points -= 10;
				if (points <= 21) {
					break;
				}
			}
			;
			return points;
		} else
			return points;

	}

	public String toString() {
		return name + "#" + money + "#" + bet + "#";
	}

	public void setCardGiver(UserListener cardGiver) {

		this.cardGiver = cardGiver;

	}

}
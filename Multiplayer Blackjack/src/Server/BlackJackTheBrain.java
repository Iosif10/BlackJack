package Server;

import java.io.IOException;
import java.util.ArrayList;

public class BlackJackTheBrain {

	ArrayList<User> users;
	CardDeck cardDeck;
	boolean ended;

	UserListener cardGiver;

	interface UserListener {

		public void onCommandForCards();

		public void onCommandForSplitCards();

	}

	public BlackJackTheBrain() {
		this.ended = true;
	}

	public BlackJackTheBrain(ArrayList<User> users) {
		this.users = users;
		theGame();

	}
	
	// THE LOGIC OF THE GAME IS HERE

	public void theGame() {

		sendPlayersInfos();
		distributeCards();
		
		for (int i = 1; i < users.size(); i++) {
			if (users.get(i) != null) {
				sentTurnInfo(i);
				sendPlayersInfos();

				if (users.get(i).bet > 0) {
					if (users.get(i).cardGiver == null) {
						initListeners(users.get(i));
					}

					users.get(i).turn();
					while ((users.get(i) != null) && (users.get(i).playing == true))
						;
				}
			}
		}

		dealersTurn();
		finalCalculation();
		this.ended = true;

	}

	private void sentTurnInfo(int i) {

		String toSend = "turnInfo#" + i;
		for (int j = 1; j < users.size(); j++) {
			try {
				users.get(j).out.writeUTF(toSend);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void sendPlayersInfos() {

		String toSend;
		for (int i = 1; i < users.size(); i++) {
			toSend = "players#" + (users.size() - 1) + "#";
			for (int j = 1; j < users.size(); j++) {
				toSend = toSend + users.get(j).toString();
			}
			try {

				users.get(i).out.writeUTF(toSend);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void finalCalculation() {

		users.get(0).points = users.get(0).pointsCalculator(users.get(0).cards);

		for (int i = 1; i < users.size(); i++) {

			if (users.get(i).splitCards.size() == 0) {

				users.get(i).points = users.get(i).pointsCalculator(users.get(i).cards);

				if (users.get(i).bet > 0) {
					if (users.get(i).points > 21) {
						
						try {
							users.get(i).out.writeUTF("over21Loss#" + users.get(i).money + "#");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					if (users.get(i).points == 21) {
						if (users.get(0).points == 21) {
							users.get(i).money += users.get(i).bet;
							
							try {
								users.get(i).out.writeUTF("equal#" + users.get(i).money + "#");
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else {
							users.get(i).money += 2 * users.get(i).bet;
							
							try {
								users.get(i).out.writeUTF("blackJackWin#" + users.get(i).money + "#");
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}

					if (users.get(i).points < 21) {
						if ((users.get(0).points >= users.get(i).points) && (users.get(0).points <= 21)) {
							
							try {
								users.get(i).out.writeUTF("loss#" + users.get(i).money + "#");
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else {
							users.get(i).money += 2 * users.get(i).bet;
							
							try {
								users.get(i).out.writeUTF("win#" + users.get(i).money + "#");
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}

				}
			} else {
				
				users.get(i).points = users.get(i).pointsCalculator(users.get(i).cards);
				users.get(i).splitPoints = users.get(i).pointsCalculator(users.get(i).splitCards);
				
				if (users.get(i).points == 21) {
					if (users.get(0).points == 21) {
						users.get(i).money += users.get(i).bet; 
					} else {
						users.get(i).money += users.get(i).bet * 2;
					}
				}
				
				if (users.get(i).points < 21) {
					if (users.get(i).points > users.get(0).points) {
						users.get(i).money += users.get(i).bet * 2;
					}
				}
				
				if (users.get(i).splitPoints == 21) {
					if (users.get(0).points == 21) {
						users.get(i).money += users.get(i).splitBet; 
					} else {
						users.get(i).money += users.get(i).splitBet * 2;
					}
				}
				
				if (users.get(i).splitPoints < 21) {
					if (users.get(i).splitPoints > users.get(0).points) {
						users.get(i).money += users.get(i).splitBet * 2;
					}
				}
				
				try {
					users.get(i).out.writeUTF("splitPotCalculation#" + users.get(i).money + "#");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}

			if (users.get(i).bet < 0) {
				try {
					users.get(i).out.writeUTF("wasOutside#" + users.get(i).money + "#");

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			users.get(i).cards.clear();
			users.get(i).splitCards.clear();
			users.get(i).points = 0;
			users.get(i).splitPoints = 0;
			users.get(i).playing = true;
			users.get(i).playingSplitCards = false;
			users.get(i).bet = 0;
			users.get(i).splitBet = 0;

		}

		users.get(0).cards.clear();
		users.get(0).points = 0;
		users.get(0).playing = true;

	}

	private void dealersTurn() {

		while (true) {

			for (int i = 1; i < users.size(); i++) {

				String toSend = "dealerCards#" + users.get(0).pointsCalculator(users.get(0).cards) + "#"
						+ users.get(0).cards.size() + "#";

				for (Card c : users.get(0).cards) {
					toSend = toSend + c.toString();
				}
				try {
					users.get(i).out.writeUTF(toSend);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			if (users.get(0).pointsCalculator(users.get(0).cards) < 17) {
				users.get(0).cards.add(cardDeck.giveCard());
			} else
				break;
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}

	private void initListeners(User user) {

		user.cardGiver = new UserListener() {

			@Override
			public void onCommandForCards() {
				user.cards.add(cardDeck.giveCard());
				user.points = user.pointsCalculator(user.cards);
			}

			@Override
			public void onCommandForSplitCards() {
				user.splitCards.add(cardDeck.giveCard());
				user.splitPoints = user.pointsCalculator(user.splitCards);
			}

		};

	}

	public void distributeCards() {

		System.out.println("||||||||size user : " + users.size());

		cardDeck = new CardDeck();

		for (int i = 1; i < users.size(); i++) {
			while (true) {
				if (i < users.size()) {
					if (users.get(i).bet != 0) {
						if (users.get(i).bet > 0) {

							users.get(i).cards.add(cardDeck.giveCard());
						}
						break;
					}
				} else
					break;
			}
		}
		users.get(0).cards.add(cardDeck.giveCard());

		for (int i = 1; i < users.size(); i++) {
			if (users.get(i).bet > 0) {

				users.get(i).cards.add(cardDeck.giveCard());
				users.get(i).sendCards();

			}
		}
		users.get(0).cards.add(cardDeck.giveCard());

		for (int i = 1; i < users.size(); i++) {
			users.get(i).sendBeginningDealerCards(users.get(0));
		}

	}

}

package GUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import GUI.ApplicationWindow.ButtonListener;
import GUI.ApplicationWindow.ServerListener;
import Server.Card;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

public class TablePanel extends JPanel {

	public Client client;
	public ButtonListener listener;
	public JButton hit;
	public JButton stand;
	public JButton dble;
	public JButton split;
	public ButtonListener hitListener;
	public ButtonListener standListener;
	public ButtonListener dbleListener;
	public ButtonListener splitListener;
	public ButtonListener cashOutListener;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel player1;
	private JLabel player1money;
	private JLabel player2money;
	private JLabel player2;
	private JLabel player3;
	private JLabel player3money;
	private JLabel player4;
	private JLabel player4money;
	private JLabel player5;
	private JLabel player5money;
	private JLabel player1bet;
	private JLabel player2bet;
	private JLabel player3bet;
	private JLabel player4bet;
	private JLabel player5bet;
	private JLabel on1;
	private JLabel turn1;
	private JLabel on2;
	private JLabel turn2;
	private JLabel on3;
	private JLabel turn3;
	private JLabel on4;
	private JLabel turn4;
	private JLabel on5;
	private JLabel turn5;
	private JLabel card1;
	private JLabel dealerCard1;
	private JLabel dealerCard2;
	private JLabel dealerCard3;
	private JLabel dealerCard4;
	private JLabel dealerCard5;
	private JLabel dealerCard6;
	private JLabel dealerCard7;
	private JLabel dealerCard8;
	private JLabel dealerCard9;
	private JLabel dealerCard10;
	private JLabel dealerCard11;
	private JLabel splitCard1;
	private JLabel splitCard2;
	private JLabel splitCard3;
	private JLabel splitCard4;
	private JLabel splitCard5;
	private JLabel splitCard6;
	private JLabel splitCard7;
	private JLabel splitCard8;
	private JLabel splitCard9;
	private JLabel splitCard10;
	private JLabel splitCard11;
	private JLabel card2;
	private JLabel card3;
	private JLabel card4;
	private JLabel card5;
	private JLabel card6;
	private JLabel card7;
	private JLabel card8;
	private JLabel card9;
	private JLabel card10;
	private JLabel card11;
	private JLabel nameLabel;
	private JButton cashOut;
	private JLabel NowPlay;
	private JLabel TheseCards;
	private JLabel AndNow;
	private JLabel TheseCards2;

	/**
	 * Create the panel.
	 * 
	 * @param client
	 */
	public TablePanel(Client client) {

		this.client = client;

		setLayout(null);

		JPanel panel = new TableDrawingComponent();
		panel.setBounds(0, 0, 915, 461);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Dealer cards :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(218, 56, 146, 30);
		panel.add(lblNewLabel_2);

		player1 = new JLabel("");
		player1.setForeground(Color.WHITE);
		player1.setBounds(170, 254, 87, 14);
		panel.add(player1);

		player1money = new JLabel("");
		player1money.setForeground(Color.WHITE);
		player1money.setBounds(170, 271, 87, 14);
		panel.add(player1money);

		player2 = new JLabel("");
		player2.setForeground(Color.WHITE);
		player2.setBounds(322, 318, 87, 14);
		panel.add(player2);

		player2money = new JLabel("");
		player2money.setForeground(Color.WHITE);
		player2money.setBounds(322, 335, 87, 14);
		panel.add(player2money);

		player3 = new JLabel("");
		player3.setForeground(Color.WHITE);
		player3.setBounds(491, 335, 87, 14);
		panel.add(player3);

		player3money = new JLabel("");
		player3money.setForeground(Color.WHITE);
		player3money.setBounds(491, 352, 87, 14);
		panel.add(player3money);

		player4 = new JLabel("");
		player4.setForeground(Color.WHITE);
		player4.setBounds(662, 271, 87, 14);
		panel.add(player4);

		player4money = new JLabel("");
		player4money.setForeground(Color.WHITE);
		player4money.setBounds(662, 286, 87, 14);
		panel.add(player4money);

		player5 = new JLabel("");
		player5.setForeground(Color.WHITE);
		player5.setBounds(752, 131, 87, 14);
		panel.add(player5);

		player5money = new JLabel("");
		player5money.setForeground(Color.WHITE);
		player5money.setBounds(752, 156, 87, 14);
		panel.add(player5money);

		on1 = new JLabel("");
		on1.setForeground(new Color(255, 255, 0));
		on1.setFont(new Font("Tahoma", Font.BOLD, 14));
		on1.setBounds(144, 210, 26, 14);
		panel.add(on1);

		turn1 = new JLabel("");
		turn1.setForeground(Color.YELLOW);
		turn1.setFont(new Font("Tahoma", Font.BOLD, 14));
		turn1.setBounds(132, 224, 50, 14);
		panel.add(turn1);

		player1bet = new JLabel("");
		player1bet.setFont(new Font("Tahoma", Font.BOLD, 11));
		player1bet.setForeground(Color.WHITE);
		player1bet.setBounds(170, 286, 87, 14);
		panel.add(player1bet);

		player2bet = new JLabel("");
		player2bet.setForeground(Color.WHITE);
		player2bet.setFont(new Font("Tahoma", Font.BOLD, 11));
		player2bet.setBounds(322, 352, 87, 14);
		panel.add(player2bet);

		player3bet = new JLabel("");
		player3bet.setForeground(Color.WHITE);
		player3bet.setFont(new Font("Tahoma", Font.BOLD, 11));
		player3bet.setBounds(491, 369, 87, 14);
		panel.add(player3bet);

		player4bet = new JLabel("");
		player4bet.setForeground(Color.WHITE);
		player4bet.setFont(new Font("Tahoma", Font.BOLD, 11));
		player4bet.setBounds(662, 306, 87, 14);
		panel.add(player4bet);

		player5bet = new JLabel("");
		player5bet.setForeground(Color.WHITE);
		player5bet.setFont(new Font("Tahoma", Font.BOLD, 11));
		player5bet.setBounds(752, 181, 87, 14);
		panel.add(player5bet);

		on2 = new JLabel("");
		on2.setForeground(Color.YELLOW);
		on2.setFont(new Font("Tahoma", Font.BOLD, 14));
		on2.setBounds(274, 304, 26, 14);
		panel.add(on2);

		turn2 = new JLabel("");
		turn2.setForeground(Color.YELLOW);
		turn2.setFont(new Font("Tahoma", Font.BOLD, 14));
		turn2.setBounds(262, 318, 50, 14);
		panel.add(turn2);

		on3 = new JLabel("");
		on3.setForeground(Color.YELLOW);
		on3.setFont(new Font("Tahoma", Font.BOLD, 14));
		on3.setBounds(448, 338, 26, 14);
		panel.add(on3);

		turn3 = new JLabel("");
		turn3.setForeground(Color.YELLOW);
		turn3.setFont(new Font("Tahoma", Font.BOLD, 14));
		turn3.setBounds(436, 352, 50, 14);
		panel.add(turn3);

		on4 = new JLabel("");
		on4.setForeground(Color.YELLOW);
		on4.setFont(new Font("Tahoma", Font.BOLD, 14));
		on4.setBounds(619, 304, 26, 14);
		panel.add(on4);

		turn4 = new JLabel("");
		turn4.setForeground(Color.YELLOW);
		turn4.setFont(new Font("Tahoma", Font.BOLD, 14));
		turn4.setBounds(607, 318, 50, 14);
		panel.add(turn4);

		on5 = new JLabel("");
		on5.setForeground(Color.YELLOW);
		on5.setFont(new Font("Tahoma", Font.BOLD, 14));
		on5.setBounds(750, 210, 26, 14);
		panel.add(on5);

		turn5 = new JLabel("");
		turn5.setForeground(Color.YELLOW);
		turn5.setFont(new Font("Tahoma", Font.BOLD, 14));
		turn5.setBounds(738, 224, 50, 14);
		panel.add(turn5);

		dealerCard1 = new JLabel("");
		dealerCard1.setBounds(364, 26, 55, 80);
		panel.add(dealerCard1);

		dealerCard2 = new JLabel("");
		dealerCard2.setBounds(393, 26, 55, 80);
		panel.add(dealerCard2);

		dealerCard3 = new JLabel("");
		dealerCard3.setBounds(422, 26, 55, 80);
		panel.add(dealerCard3);

		dealerCard4 = new JLabel("");
		dealerCard4.setBounds(451, 26, 55, 80);
		panel.add(dealerCard4);

		dealerCard5 = new JLabel("");
		dealerCard5.setBounds(480, 26, 55, 80);
		panel.add(dealerCard5);

		dealerCard6 = new JLabel("");
		dealerCard6.setBounds(509, 26, 55, 80);
		panel.add(dealerCard6);

		dealerCard7 = new JLabel("");
		dealerCard7.setBounds(538, 26, 55, 80);
		panel.add(dealerCard7);

		dealerCard8 = new JLabel("");
		dealerCard8.setBounds(567, 26, 55, 80);
		panel.add(dealerCard8);

		dealerCard9 = new JLabel("");
		dealerCard9.setBounds(596, 26, 55, 80);
		panel.add(dealerCard9);

		dealerCard10 = new JLabel("");
		dealerCard10.setBounds(625, 26, 55, 80);
		panel.add(dealerCard10);

		dealerCard11 = new JLabel("");
		dealerCard11.setBounds(654, 26, 55, 80);
		panel.add(dealerCard11);

		nameLabel = new JLabel("");
		nameLabel.setForeground(Color.BLUE);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		nameLabel.setBounds(715, 409, 190, 41);
		panel.add(nameLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(183, 0, 0));
		panel_1.setBounds(0, 460, 915, 189);
		add(panel_1);
		panel_1.setLayout(null);

		hit = new JButton("HIT");
		hit.setBounds(608, 11, 105, 28);
		hit.setEnabled(false);
		panel_1.add(hit);

		hit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (hitListener != null) {

					hitListener.onClick();
				}

			}

		});

		stand = new JButton("STAND");
		stand.setBounds(608, 57, 105, 28);
		stand.setEnabled(false);
		panel_1.add(stand);

		stand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (standListener != null) {

					standListener.onClick();
				}
				

			}

		});

		dble = new JButton("DOUBLE");
		dble.setBounds(608, 103, 105, 28);
		dble.setEnabled(false);
		panel_1.add(dble);

		dble.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (dbleListener != null) {

					dbleListener.onClick();
				}
				
				printInfo();
				
				
			}

		});

		split = new JButton("SPLIT");
		split.setBounds(608, 149, 105, 28);
		split.setEnabled(false);
		panel_1.add(split);

		split.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (splitListener != null) {

					splitListener.onClick();
					split.setEnabled(false);
					client.splitCards.add(client.cards.get(1));
					card2.setIcon(null);
					splitCard1.setIcon(new ImageIcon(
							"C:\\Users\\user\\Desktop\\BlackJack\\BlackJack\\Multiplayer Blackjack\\src\\Resources\\CardsImages\\"
									+ client.splitCards.get(0).toString() + ".png"));
					NowPlay.setText("Now, play");
					TheseCards.setText("these cards.");
				}

			}

		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(183, 0, 0));
		panel_2.setBounds(0, 0, 553, 94);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		card1 = new JLabel("");
		card1.setBounds(198, 11, 55, 80);
		// card1.setIcon(new ImageIcon(
		// "C:\\Users\\user\\Desktop\\BlackJack\\BlackJack\\Multiplayer
		// Blackjack\\src\\Resources\\CardsImages\\1#club#.png"));
		panel_2.add(card1);

		card2 = new JLabel("");
		card2.setBounds(227, 11, 55, 80);
		panel_2.add(card2);

		card3 = new JLabel("");
		card3.setBounds(256, 11, 55, 80);
		panel_2.add(card3);

		card4 = new JLabel("");
		card4.setBounds(285, 11, 55, 80);
		panel_2.add(card4);

		card5 = new JLabel("");
		card5.setBounds(314, 11, 55, 80);
		panel_2.add(card5);

		card6 = new JLabel("");
		card6.setBounds(343, 11, 55, 80);
		panel_2.add(card6);

		card7 = new JLabel("");
		card7.setBounds(372, 11, 55, 80);
		panel_2.add(card7);

		card8 = new JLabel("");
		card8.setBounds(401, 11, 55, 80);
		panel_2.add(card8);

		card9 = new JLabel("");
		card9.setBounds(430, 11, 55, 80);
		panel_2.add(card9);

		card10 = new JLabel("");
		card10.setBounds(459, 11, 55, 80);
		panel_2.add(card10);

		card11 = new JLabel("");
		card11.setBounds(488, 11, 55, 80);
		panel_2.add(card11);

		NowPlay = new JLabel("");
		NowPlay.setForeground(Color.YELLOW);
		NowPlay.setFont(new Font("Tahoma", Font.BOLD, 14));
		NowPlay.setBounds(10, 22, 89, 28);
		panel_2.add(NowPlay);

		TheseCards = new JLabel("");
		TheseCards.setForeground(Color.YELLOW);
		TheseCards.setFont(new Font("Tahoma", Font.BOLD, 14));
		TheseCards.setBounds(10, 42, 89, 28);
		panel_2.add(TheseCards);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(183, 0, 0));
		panel_3.setBounds(0, 95, 553, 94);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		splitCard1 = new JLabel("");
		splitCard1.setBounds(198, 11, 55, 80);
		panel_3.add(splitCard1);

		splitCard2 = new JLabel("");
		splitCard2.setBounds(227, 11, 55, 80);
		panel_3.add(splitCard2);

		splitCard3 = new JLabel("");
		splitCard3.setBounds(256, 11, 55, 80);
		panel_3.add(splitCard3);

		splitCard4 = new JLabel("");
		splitCard4.setBounds(285, 11, 55, 80);
		panel_3.add(splitCard4);

		splitCard5 = new JLabel("");
		splitCard5.setBounds(314, 11, 55, 80);
		panel_3.add(splitCard5);

		splitCard6 = new JLabel("");
		splitCard6.setBounds(343, 11, 55, 80);
		panel_3.add(splitCard6);

		splitCard7 = new JLabel("");
		splitCard7.setBounds(372, 11, 55, 80);
		panel_3.add(splitCard7);

		splitCard8 = new JLabel("");
		splitCard8.setBounds(401, 11, 55, 80);
		panel_3.add(splitCard8);

		splitCard9 = new JLabel("");
		splitCard9.setBounds(430, 11, 55, 80);
		panel_3.add(splitCard9);

		splitCard10 = new JLabel("");
		splitCard10.setBounds(459, 11, 55, 80);
		panel_3.add(splitCard10);

		splitCard11 = new JLabel("");
		splitCard11.setBounds(488, 11, 55, 80);
		panel_3.add(splitCard11);

		AndNow = new JLabel("");
		AndNow.setForeground(Color.YELLOW);
		AndNow.setFont(new Font("Tahoma", Font.BOLD, 14));
		AndNow.setBounds(10, 11, 89, 28);
		panel_3.add(AndNow);

		TheseCards2 = new JLabel("");
		TheseCards2.setForeground(Color.YELLOW);
		TheseCards2.setFont(new Font("Tahoma", Font.BOLD, 14));
		TheseCards2.setBounds(10, 31, 89, 28);
		panel_3.add(TheseCards2);

		JLabel lblBet = new JLabel("BET (USD) :");
		lblBet.setForeground(Color.WHITE);
		lblBet.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblBet.setBounds(777, 9, 89, 28);
		panel_1.add(lblBet);

		JLabel lblCashusd = new JLabel("CASH (USD) :");
		lblCashusd.setForeground(Color.WHITE);
		lblCashusd.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblCashusd.setBounds(777, 66, 110, 28);
		panel_1.add(lblCashusd);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(750, 39, 127, 22);
		panel_1.add(lblNewLabel_1);

		label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(760, 95, 133, 22);
		panel_1.add(label);

		cashOut = new JButton("$ Cash Out $");
		cashOut.setForeground(new Color(0, 204, 51));
		cashOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		cashOut.setBounds(766, 138, 105, 23);
		panel_1.add(cashOut);

		cashOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (cashOutListener != null) {

					cashOutListener.onClick();
				}

			}

		});

	}

	public void setListener(ButtonListener listener) {
		this.listener = listener;
	}

	public void printCards() {
		String adress;
		for (int i = 0; i < client.cards.size(); i++) {
			adress = "C:\\Users\\user\\Desktop\\BlackJack\\BlackJack\\Multiplayer Blackjack\\src\\Resources\\CardsImages\\"
					+ client.cards.get(i).toString() + ".png";
			switch (i) {
			case 0:
				card1.setIcon(new ImageIcon(adress));
				break;
			case 1:
				card2.setIcon(new ImageIcon(adress));
				break;
			case 2:
				card3.setIcon(new ImageIcon(adress));
				break;
			case 3:
				card4.setIcon(new ImageIcon(adress));
				break;
			case 4:
				card5.setIcon(new ImageIcon(adress));
				break;
			case 5:
				card6.setIcon(new ImageIcon(adress));
				break;
			case 6:
				card7.setIcon(new ImageIcon(adress));
				break;
			case 7:
				card8.setIcon(new ImageIcon(adress));
				break;
			case 8:
				card9.setIcon(new ImageIcon(adress));
				break;
			case 9:
				card10.setIcon(new ImageIcon(adress));
				break;
			case 10:
				card11.setIcon(new ImageIcon(adress));
				break;
			default:
				break;
			}
		}

		printInfo();
	}

	public void printSplitCards() {
		String adress;
		for (int i = 0; i < client.splitCards.size(); i++) {
			adress = "C:\\Users\\user\\Desktop\\BlackJack\\BlackJack\\Multiplayer Blackjack\\src\\Resources\\CardsImages\\"
					+ client.splitCards.get(i).toString() + ".png";
			switch (i) {
			case 0:
				splitCard1.setIcon(new ImageIcon(adress));
				break;
			case 1:
				splitCard2.setIcon(new ImageIcon(adress));
				break;
			case 2:
				splitCard3.setIcon(new ImageIcon(adress));
				break;
			case 3:
				splitCard4.setIcon(new ImageIcon(adress));
				break;
			case 4:
				splitCard5.setIcon(new ImageIcon(adress));
				break;
			case 5:
				splitCard6.setIcon(new ImageIcon(adress));
				break;
			case 6:
				splitCard7.setIcon(new ImageIcon(adress));
				break;
			case 7:
				splitCard8.setIcon(new ImageIcon(adress));
				break;
			case 8:
				splitCard9.setIcon(new ImageIcon(adress));
				break;
			case 9:
				splitCard10.setIcon(new ImageIcon(adress));
				break;
			case 10:
				splitCard11.setIcon(new ImageIcon(adress));
				break;
			default:
				break;
			}
		}

		printInfo();
	}

	public void printInfo() {

		nameLabel.setText(client.name);
		lblNewLabel_1.setText("" + client.bet);
		label.setText("" + client.money);

	}

	public void setHitListener(ButtonListener listener) {

		this.hitListener = listener;

	}

	public void setStandListener(ButtonListener listener) {

		this.standListener = listener;

	}

	public void setDbleListener(ButtonListener listener) {

		this.dbleListener = listener;

	}

	public void setSplitListener(ButtonListener listener) {

		this.splitListener = listener;

	}

	public void setCashOutListener(ButtonListener listener) {

		this.cashOutListener = listener;

	}

	public void over21() {

		JOptionPane.showMessageDialog(this,
				"Sorry, you have over 21 points. Please, be patient till the end of the round calculation.");

	}

	public void BlackJack() {

		JOptionPane.showMessageDialog(this, "Congratulations!! BLACKJACK!! Wait for the final calculation.");

	}


	public void printBeginningDealerCards() {

		dealerCard1.setIcon(new ImageIcon(
				"C:\\Users\\user\\Desktop\\BlackJack\\BlackJack\\Multiplayer Blackjack\\src\\Resources\\CardsImages\\"
						+ client.dealer.cards.get(0).toString() + ".png"));
		dealerCard2.setIcon(new ImageIcon(
				"C:\\Users\\user\\Desktop\\BlackJack\\BlackJack\\Multiplayer Blackjack\\src\\Resources\\cardBack.png"));

		
	}

	public void printDealerCards() {

		String adress;
		for (int i = 0; i < client.dealer.cards.size(); i++) {
			adress = "C:\\Users\\user\\Desktop\\BlackJack\\BlackJack\\Multiplayer Blackjack\\src\\Resources\\CardsImages\\"
					+ client.dealer.cards.get(i).toString() + ".png";
			switch (i) {
			case 0:
				dealerCard1.setIcon(new ImageIcon(adress));
				break;
			case 1:
				dealerCard2.setIcon(new ImageIcon(adress));
				break;
			case 2:
				dealerCard3.setIcon(new ImageIcon(adress));
				break;
			case 3:
				dealerCard4.setIcon(new ImageIcon(adress));
				break;
			case 4:
				dealerCard5.setIcon(new ImageIcon(adress));
				break;
			case 5:
				dealerCard6.setIcon(new ImageIcon(adress));
				break;
			case 6:
				dealerCard7.setIcon(new ImageIcon(adress));
				break;
			case 7:
				dealerCard8.setIcon(new ImageIcon(adress));
				break;
			case 8:
				dealerCard9.setIcon(new ImageIcon(adress));
				break;
			case 9:
				dealerCard10.setIcon(new ImageIcon(adress));
				break;
			case 10:
				dealerCard11.setIcon(new ImageIcon(adress));
				break;
			default:
				break;
			}
		}

	}

	public void resetTable() {

		lblNewLabel_1.setText("");
		label.setText("" + client.money);

		card1.setIcon(null);
		card2.setIcon(null);
		card3.setIcon(null);
		card4.setIcon(null);
		card5.setIcon(null);
		card6.setIcon(null);
		card7.setIcon(null);
		card8.setIcon(null);
		card9.setIcon(null);
		card10.setIcon(null);
		card11.setIcon(null);
		dealerCard1.setIcon(null);
		dealerCard2.setIcon(null);
		dealerCard3.setIcon(null);
		dealerCard4.setIcon(null);
		dealerCard5.setIcon(null);
		dealerCard6.setIcon(null);
		dealerCard7.setIcon(null);
		dealerCard8.setIcon(null);
		dealerCard9.setIcon(null);
		dealerCard10.setIcon(null);
		dealerCard11.setIcon(null);
		splitCard1.setIcon(null);
		splitCard1.setIcon(null);
		splitCard2.setIcon(null);
		splitCard3.setIcon(null);
		splitCard4.setIcon(null);
		splitCard5.setIcon(null);
		splitCard6.setIcon(null);
		splitCard7.setIcon(null);
		splitCard8.setIcon(null);
		splitCard9.setIcon(null);
		splitCard10.setIcon(null);
		splitCard11.setIcon(null);

		player1.setText("");
		player1money.setText("");
		player1bet.setText("");
		player2.setText("");
		player2money.setText("");
		player2bet.setText("");
		player3.setText("");
		player3money.setText("");
		player3bet.setText("");
		player4.setText("");
		player4money.setText("");
		player4bet.setText("");
		player5.setText("");
		player5money.setText("");
		player5bet.setText("");

		NowPlay.setText("");
		TheseCards.setText("");
		AndNow.setText("");
		TheseCards2.setText("");

		client.playingSplitCards = false;

	}

	public void over21Loss() {

		JOptionPane.showMessageDialog(this,
				"The round is finished. Good luck at the next one! Your have " + client.money + "(USD).");
		printInfo();

	}

	public void equal() {

		JOptionPane.showMessageDialog(this,
				"The round is finished. The dealer made also BlackJack. It's a draw. Your have " + client.money
						+ "(USD).");
		printInfo();

	}

	public void blackJackWin() {

		JOptionPane.showMessageDialog(this,
				"The round is finished. You WON with that BlackJack! Your have " + client.money + "(USD).");
		printInfo();

	}

	public void loss() {

		JOptionPane.showMessageDialog(this, "The round is finished. The dealer is better than you, with "
				+ client.dealer.points + ". Good luck at the next round! Your have " + client.money + "(USD) more.");
		printInfo();

	}

	public void win() {

		JOptionPane.showMessageDialog(this,
				"Congratulations, you WON this round! Your have " + client.money + "(USD).");
		printInfo();

	}

	public void printPlayers() {

		for (int i = 0; i < client.players.size(); i++) {
			switch (i) {
			case 0:
				player1.setText("" + client.players.get(i).name);
				player1money.setText(client.players.get(i).money + " USD");
				player1bet.setText("BET: " + client.players.get(i).bet + " USD");
				break;
			case 1:
				player2.setText("" + client.players.get(i).name);
				player2money.setText(client.players.get(i).money + " USD");
				player2bet.setText("BET: " + client.players.get(i).bet + " USD");
				break;
			case 2:
				player3.setText("" + client.players.get(i).name);
				player3money.setText(client.players.get(i).money + " USD");
				player3bet.setText("BET: " + client.players.get(i).bet + " USD");
				break;
			case 3:
				player4.setText("" + client.players.get(i).name);
				player4money.setText(client.players.get(i).money + " USD");
				player4bet.setText("BET: " + client.players.get(i).bet + " USD");
				break;
			case 4:
				player5.setText("" + client.players.get(i).name);
				player5money.setText(client.players.get(i).money + " USD");
				player5bet.setText("BET: " + client.players.get(i).bet + " USD");
				break;
			default:
				break;
			}
		}

	}

	public void turnInfo(int playerNumber) {

		switch (playerNumber) {

		case 1:
			on1.setText("ON");
			turn1.setText("TURN!");
			on2.setText("");
			turn2.setText("");
			on3.setText("");
			turn3.setText("");
			on4.setText("");
			turn4.setText("");
			on5.setText("");
			turn5.setText("");
			break;
		case 2:
			on1.setText("");
			turn1.setText("");
			on2.setText("ON");
			turn2.setText("TURN!");
			on3.setText("");
			turn3.setText("");
			on4.setText("");
			turn4.setText("");
			on5.setText("");
			turn5.setText("");
			break;
		case 3:
			on1.setText("");
			turn1.setText("");
			on2.setText("");
			turn2.setText("");
			on3.setText("ON");
			turn3.setText("TURN!");
			on4.setText("");
			turn4.setText("");
			on5.setText("");
			turn5.setText("");
			break;
		case 4:
			on1.setText("");
			turn1.setText("");
			on2.setText("");
			turn2.setText("");
			on3.setText("");
			turn3.setText("");
			on4.setText("ON");
			turn4.setText("TURN!");
			on5.setText("");
			turn5.setText("");
			break;
		case 5:
			on1.setText("");
			turn1.setText("");
			on2.setText("");
			turn2.setText("");
			on3.setText("");
			turn3.setText("");
			on4.setText("");
			turn4.setText("");
			on5.setText("ON");
			turn5.setText("TURN!");
			break;
		default:
			break;
		}

	}

	public void initialWaiting() {

		JOptionPane.showMessageDialog(this,
				"Please, be patient, you will enter at the table as soon as the current round is finished.");

	}

	public void splitGame() {

		NowPlay.setText("");
		TheseCards.setText("");
		AndNow.setText("And now,");
		TheseCards2.setText("these cards.");

	}

	public void over21BeforeSplitGame() {
		JOptionPane.showMessageDialog(this,
				"Sorry, you have over 21 points. Now, you will play the other set of cards.");

	}

	public void BlackJackBeforeSplitGame() {
		JOptionPane.showMessageDialog(this, "Congratulations!! BLACKJACK!! Now, you will play the other set of cards.");

	}

	public void splitPotCalculation() {

		JOptionPane.showMessageDialog(this,
				"The round is finished. After split pot calculation, you have " + client.money + "(USD).");
		printInfo();

	}

}

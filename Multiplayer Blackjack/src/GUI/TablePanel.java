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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

public class TablePanel extends JPanel {

	public Client client;
	public ButtonListener listener;
	public JLabel lblNewLabel;
	public JButton hit;
	public JButton stand;
	public JButton dble;
	public JButton split;
	public ButtonListener hitListener;
	public ButtonListener standListener;
	public ButtonListener dbleListener;
	public ButtonListener splitListener;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel label_1;
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

		label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(354, 56, 472, 30);
		panel.add(label_1);

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
				hit.setEnabled(false);
				stand.setEnabled(false);
				dble.setEnabled(false);
				split.setEnabled(false);

				//bePatient();

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

				client.money -= client.bet;
				client.bet *= 2;

				printInfo();

				hit.setEnabled(false);
				stand.setEnabled(false);
				dble.setEnabled(false);
				split.setEnabled(false);

				if (client.bePatientflag == false) {
					//bePatient();
				}

			}

		});

		split = new JButton("SPLIT");
		split.setBounds(608, 149, 105, 28);
		split.setEnabled(false);
		panel_1.add(split);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(183, 0, 0));
		panel_2.setBounds(0, 0, 553, 94);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(63, 5, 394, 59);
		panel_2.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(183, 0, 0));
		panel_3.setBounds(0, 95, 553, 94);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblBet = new JLabel("BET (USD) :");
		lblBet.setForeground(Color.WHITE);
		lblBet.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblBet.setBounds(772, 11, 111, 28);
		panel_1.add(lblBet);

		JLabel lblCashusd = new JLabel("CASH (USD) :");
		lblCashusd.setForeground(Color.WHITE);
		lblCashusd.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblCashusd.setBounds(761, 100, 127, 28);
		panel_1.add(lblCashusd);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(750, 39, 133, 30);
		panel_1.add(lblNewLabel_1);

		label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(750, 128, 133, 30);
		panel_1.add(label);

		split.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (splitListener != null) {

					splitListener.onClick();
				}

			}

		});

	}

	public void setListener(ButtonListener listener) {
		this.listener = listener;
	}

	public void printCards() {
		String toPrint = "";
		for (Card c : client.cards) {
			toPrint = toPrint + c.toString();
		}
		lblNewLabel.setText(toPrint);
		printInfo();
	}

	public void printInfo() {

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

	public void over21() {

		JOptionPane.showMessageDialog(this,
				"Sorry, you have over 21 points. Please, be patient till the end of the round calculation.");

	}

	public void BlackJack() {

		JOptionPane.showMessageDialog(this, "Congratulations!! BLACKJACK!! Wait for the final calculation.");

	}

//	public void bePatient() {
//
//		JOptionPane.showMessageDialog(this,
//				"Your turn is finished. Please, be patient till the end of the round calculation.");
//
//	}

	public void printBeginningDealerCards() {

		label_1.setText(client.dealer.cards.get(0).toString() + "secondDealerCard#");

	}

	public void printDealerCards() {

		System.out.println("in print dealer cards");
		String toPrint = "";
		for (Card c : client.dealer.cards) {
			toPrint = toPrint + c.toString();
		}

		label_1.setText(toPrint);
		System.out.println("dupa print dealer cards");

	}

	public void resetTable() {

		lblNewLabel_1.setText("");
		label.setText("" + client.money);
		lblNewLabel.setText("");
		label_1.setText("");

	}

	public void over21Loss() {

		JOptionPane.showMessageDialog(this,
				"The round is finished. Good luck at the next one! Your have " + client.money + "(USD).");

	}

	public void equal() {

		JOptionPane.showMessageDialog(this,
				"The round is finished. The dealer made also BlackJack. It's a draw. Your have " + client.money
						+ "(USD).");

	}

	public void blackJackWin() {

		JOptionPane.showMessageDialog(this,
				"The round is finished. You WON with that wonderful BlackJack! Your have " + client.money + "(USD).");

	}

	public void loss() {

		JOptionPane.showMessageDialog(this,
				"The round is finished. The dealer is better than you, with " + client.dealer.points + ". Good luck at the next round! Your have "
						+ client.money + "(USD).");

	}

	public void win() {

		JOptionPane.showMessageDialog(this,
				"Congratulations, you WON this round! Your have " + client.money + "(USD).");

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
			default: break;
			}
		}

	}

	public void turnInfo(int playerNumber) {
		
		switch (playerNumber) {
		
		case 1 : 
			on1.setText("ON"); turn1.setText("TURN!");
			on2.setText(""); turn2.setText("");
			on3.setText(""); turn3.setText("");
			on4.setText(""); turn4.setText("");
			on5.setText(""); turn5.setText("");
			break;
		case 2 : 
			on1.setText(""); turn1.setText("");
			on2.setText("ON"); turn2.setText("TURN!");
			on3.setText(""); turn3.setText("");
			on4.setText(""); turn4.setText("");
			on5.setText(""); turn5.setText("");
			break;
		case 3 : 
			on1.setText(""); turn1.setText("");
			on2.setText(""); turn2.setText("");
			on3.setText("ON"); turn3.setText("TURN!");
			on4.setText(""); turn4.setText("");
			on5.setText(""); turn5.setText("");
			break;
		case 4 : 
			on1.setText(""); turn1.setText("");
			on2.setText(""); turn2.setText("");
			on3.setText(""); turn3.setText("");
			on4.setText("ON"); turn4.setText("TURN!");
			on5.setText(""); turn5.setText("");
			break;
		case 5 : 
			on1.setText(""); turn1.setText("");
			on2.setText(""); turn2.setText("");
			on3.setText(""); turn3.setText("");
			on4.setText(""); turn4.setText("");
			on5.setText("ON"); turn5.setText("TURN!");
			break;
		default : break;
		}
		
	}
}

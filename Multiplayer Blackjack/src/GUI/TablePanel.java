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
		lblNewLabel_2.setBounds(268, 56, 146, 30);
		panel.add(lblNewLabel_2);
		
		label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(424, 56, 308, 30);
		panel.add(label_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
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
				
				bePatient();

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
					bePatient();
				}
							
			}

		});

		split = new JButton("SPLIT");
		split.setBounds(608, 149, 105, 28);
		split.setEnabled(false);
		panel_1.add(split);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 0, 553, 94);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(63, 5, 394, 59);
		panel_2.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
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

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(750, 39, 133, 30);
		panel_1.add(lblNewLabel_1);

		label = new JLabel("New label");
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

	private void printInfo() {
		
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
	
	public void bePatient() {

		JOptionPane.showMessageDialog(this, "Your turn is finished. Please, be patient till the end of the round calculation.");

	}

	public void printBeginningDealerCards() {
		
		String toPrint = "";
		for (Card c : client.dealer.cards) {
			toPrint = toPrint + c.toString();
		}
		
		label_1.setText(client.dealer.cards.get(0).toString() + "secondDealerCard#");
		
	}
}

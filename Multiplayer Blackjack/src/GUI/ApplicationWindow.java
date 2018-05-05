package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.NumberFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ApplicationWindow {

	Client client;

	public JFrame frmBlackjackMultiplayer;
	BetPane betPane;

	BufferedImage sky;
	private JTextField Nickname;

	private WelcomePanel welcomePanel;
	private JButton Enter;

	public TablePanel tablePanel;

	public ApplicationWindow(Client c) {

		this.client = c;
		initialize();
	}

	private void initialize() {
		
		// INITIALIZING THE FRAME AND THE GAME WINDOWS
		
		frmBlackjackMultiplayer = new JFrame();
		frmBlackjackMultiplayer.setForeground(new Color(255, 255, 255));
		frmBlackjackMultiplayer.setFont(null);
		frmBlackjackMultiplayer.setTitle("BlackJack Multiplayer");
		frmBlackjackMultiplayer.setBounds(30, 30, 930, 685);
		frmBlackjackMultiplayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmBlackjackMultiplayer.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {}

			@Override
			public void windowClosed(WindowEvent arg0) {}

			@Override
			public void windowClosing(WindowEvent arg0) {
				cashOutListener.onClick();
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {}

			@Override
			public void windowDeiconified(WindowEvent arg0) {}

			@Override
			public void windowIconified(WindowEvent arg0) {}

			@Override
			public void windowOpened(WindowEvent arg0) {}
			
		});

		welcomePanel = new WelcomePanel(client, enterListener);
		frmBlackjackMultiplayer.add(welcomePanel);
		
		tablePanel = new TablePanel(client);

	}

	public void playingTable() {

		welcomePanel.setVisible(false);
		
		frmBlackjackMultiplayer.add(tablePanel);

		betPane = new BetPane(client);
		betPane.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		betPane.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {}

			@Override
			public void windowClosed(WindowEvent arg0) {
				client.playing = false;
				client.bet = 0;
				skipListener.onClick();
			}

			@Override
			public void windowClosing(WindowEvent arg0) {}

			@Override
			public void windowDeactivated(WindowEvent arg0) {}

			@Override
			public void windowDeiconified(WindowEvent arg0) {}

			@Override
			public void windowIconified(WindowEvent arg0) {}

			@Override
			public void windowOpened(WindowEvent arg0) {}
			
		});
		
		betPane.setVisible(true);

		betPane.setListener(betListener);
		betPane.setSkipListener(skipListener);

		tablePanel.setBackground(Color.BLUE);
		GroupLayout groupLayout = new GroupLayout(frmBlackjackMultiplayer.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(tablePanel,
				GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(tablePanel,
				GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE));
		
		tablePanel.setHitListener(hitListener);
		tablePanel.setStandListener(standListener);
		tablePanel.setDbleListener(dbleListener);
		tablePanel.setSplitListener(splitListener);
		tablePanel.setCashOutListener(cashOutListener);
		
		
	}
	
	public void newTable() {
		
		client.cards.clear();
		client.dealer.cards.clear();
		tablePanel.resetTable();
		tablePanel.printPlayers();
		betPane.setVisible(true);
		
	}

	ButtonListener enterListener;
	ButtonListener betListener;
	ButtonListener skipListener;
	ButtonListener hitListener;
	ButtonListener standListener;
	ButtonListener dbleListener;
	ButtonListener splitListener;
	ButtonListener cashOutListener;

		
	public void setEnterListener(ButtonListener listener) {

		enterListener = listener;
		welcomePanel.setListener(listener);

	}

	public void setBetListener(ButtonListener listener) {

		betListener = listener;

	}

	public void setSkipListener(ButtonListener listener) {

		skipListener = listener;

	}
	
	
	public void setHitListener(ButtonListener listener) {

		hitListener = listener;
		

	}
	
	public void setStandListener(ButtonListener listener) {

		standListener = listener;

	}
	
	public void setDbleListener(ButtonListener listener) {

		dbleListener = listener;

	}
	
	public void setSplitListener(ButtonListener listener) {

		splitListener = listener;

	}
	
	public void setCashOutListener(ButtonListener listener) {

		cashOutListener = listener;

	}
	
	

	interface ButtonListener {

		public void onClick();

	}

	interface ServerListener {
		
		public void onMessage();
		
	}
	

}

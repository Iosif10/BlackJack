package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.NumberFormatter;

import GUI.GraphicWindow.EnterListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

//	ButtonListener listener;
	private WelcomePanel welcomePanel;
	private JButton Enter;

	private JPanel tablePanel;

	/**
	 * Create the application.
	 */
	public ApplicationWindow(Client c) {
		this.client = c;
//		setListener(listener);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBlackjackMultiplayer = new JFrame();
		frmBlackjackMultiplayer.setForeground(new Color(255, 255, 255));
		frmBlackjackMultiplayer.setFont(null);
		frmBlackjackMultiplayer.setTitle("BlackJack Multiplayer");
		frmBlackjackMultiplayer.setBounds(100, 100, 930, 659);
		frmBlackjackMultiplayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		welcomePanel = new WelcomePanel(client, enterListener);
		frmBlackjackMultiplayer.add(welcomePanel);

	}

	public void playingTable() {

		welcomePanel.setVisible(false);
		tablePanel = new TablePanel(client);
		frmBlackjackMultiplayer.add(tablePanel);

		betPane = new BetPane(client);
		betPane.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		betPane.setVisible(true);

		betPane.setListener(betListener);

		tablePanel.setBackground(Color.BLUE);
		GroupLayout groupLayout = new GroupLayout(frmBlackjackMultiplayer.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(tablePanel,
				GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(tablePanel,
				GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE));

	}

	// public void setListener(ButtonListener listener) {
	//
	// this.listener = listener;
	//
	//
	//
	// }

	ButtonListener enterListener;
	ButtonListener betListener;

	public void setEnterListener(ButtonListener listener) {
		enterListener = listener;

		 welcomePanel.setListener(listener);
		// this.listener = listener;

	}

	public void setBetListener(ButtonListener listener) {
		betListener = listener;
		// this.listener = listener;

	}

	interface ButtonListener {

		public void onClick();

		// public void onEnter();
		// public void onBet();
		// public void onHit();
		// public void onStand();
		// public void onDouble();
		// public void onSplit();

	}

}

/*
 * public interface BetListener {
 * 
 * public void onClick(); }
 * 
 * public interface HitListener {
 * 
 * public void onClick(); }
 * 
 * public interface StandListener {
 * 
 * public void onClick(); }
 * 
 * public interface DoubleListener {
 * 
 * public void onClick(); }
 * 
 * public interface SplitListener {
 * 
 * public void onClick(); }
 * 
 */

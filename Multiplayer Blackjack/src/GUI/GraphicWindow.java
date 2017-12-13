package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.text.NumberFormat;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class GraphicWindow extends JFrame {

	public String Name;
	public double money;

	public JPanel Welcome;
	public JPanel PlayingTable;

	public JTextField Nickname;
	public JTextField Cash;
	public JButton Enter;

	EnterListener listener;

	public GraphicWindow(Client c) {

		setSize(900, 600);
		setTitle("BlackJack Multiplayer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		Welcome = new JPanel();
		Welcome.setBounds(0, 0, 1000, 1000);
		Welcome.setLayout(null);
		add(Welcome);
		Welcome.setBackground(new Color(150, 0, 255));

		Nickname = new JTextField("Nickname");
		Nickname.setFont(new Font("Dialog", 0, 50));
		Nickname.setScrollOffset(400);
		Nickname.setColumns(15);
		Dimension size1 = Nickname.getPreferredSize();
		Nickname.setBounds(150, 75, size1.width, size1.height);
		System.out.println(size1.width + ", " + size1.height);
		Welcome.add(Nickname);

		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		// If you want the value to be committed on each keystroke instead of
		// focus lost
		formatter.setCommitsOnValidEdit(true);
		JFormattedTextField Cash = new JFormattedTextField(formatter);

		// JOptionPane.showMessageDialog(null, Cash);

		// Cash = new JTextField("Cash$");
		Cash.setToolTipText("Cash$");
		Cash.setFont(new Font("Dialog", 0, 50));
		setLayout(null);
		// Dimension size2 = Cash.getPreferredSize();
		Cash.setBounds(345, 175, 170, 68);
		Welcome.add(Cash);

		Enter = new JButton(new ImageIcon("res/Enter2.jpg"));
		Enter.setBounds(335, 300, 213, 208);
		Welcome.add(Enter);
		Enter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// documentListener; filter

				if ((Nickname != null) && (Cash != null) && (listener != null)) {

					listener.onclick();
					
				}

			}

		});

		// Welcome.setVisible(false);

		// add(new DrawingComponent());

	}

	public void playingTable() {

		Welcome.setVisible(false);
		PlayingTable = new JPanel();
		PlayingTable.setBounds(0, 0, 1000, 1000);
		//PlayingTable.setLayout(null);
		

		add(PlayingTable);
		
		PlayingTable.setVisible(true);
		
		PlayingTable.add(new JLabel("Hello"));

		

	}

	public void setListener(EnterListener listener) {

		this.listener = listener;

	}

	interface EnterListener {

		public void onclick();

	}

}

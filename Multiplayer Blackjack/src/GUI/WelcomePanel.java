package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.NumberFormatter;

import GUI.ApplicationWindow.ButtonListener;
import java.awt.Rectangle;

public class WelcomePanel extends JPanel {
	
	Client client;
	
	BufferedImage sky;
	private JTextField Nickname;
	
	ButtonListener listener;
	private JPanel welcomePanel;
	private JButton Enter;
	
	public WelcomePanel(Client c, ButtonListener listener) {
		this.client = c;
		setListener(listener);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(0, 0, 915, 659);

		welcomePanel = new WelcomeDrawingComponent();
		welcomePanel.setBounds(new Rectangle(0, 0, 915, 659));
		welcomePanel.setBackground(Color.BLUE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(welcomePanel, GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(welcomePanel, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
		);
		
		JLabel lblWelcome = new JLabel("WELCOME!");
		lblWelcome.setForeground(Color.YELLOW);
		lblWelcome.setFont(new Font("Vrinda", Font.PLAIN, 58));
		
		Nickname = new JTextField();
		Nickname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Nickname.setColumns(10);
		
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(true);
		
		JFormattedTextField Cash = new JFormattedTextField(formatter);
		Cash.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNickname = new JLabel("Nickname :");
		lblNickname.setForeground(Color.YELLOW);
		lblNickname.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblCashusd = new JLabel("Cash (USD) :");
		lblCashusd.setForeground(Color.YELLOW);
		lblCashusd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		
		Enter = new JButton(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\Multiplayer Blackjack\\src\\Resources\\Enter.png"));
		Enter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// documentListener; filter

				if ((Nickname.getText() != null) && (Cash.getText() != null) && (listener != null)) {
					
					client.name = Nickname.getText();
					client.money = Integer.valueOf(Cash.getText());
					
					System.out.println("in iffffff");

					listener.onClick();
					
				}

			}

		});
		
		JLabel lblWelcomeToOur = new JLabel("Welcome to our BlackJack Online Casino! Fill the two fields and than press the red button below. Enjoy the game!");
		lblWelcomeToOur.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWelcomeToOur.setForeground(Color.YELLOW);
		GroupLayout gl_panel = new GroupLayout(welcomePanel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWelcomeToOur)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCashusd, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNickname, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(Nickname, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
								.addComponent(Cash, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(252, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(268)
					.addComponent(lblWelcome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(231))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(359, Short.MAX_VALUE)
					.addComponent(Enter, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(333))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(50)
					.addComponent(lblWelcome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(35)
					.addComponent(lblWelcomeToOur)
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNickname)
							.addGap(17))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(Nickname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCashusd, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(Cash, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(Enter)
					.addGap(54))
		);
		welcomePanel.setLayout(gl_panel);
		setLayout(groupLayout);
		
		
	}
	
	public void setListener(ButtonListener listener) {
		this.listener = listener;
	}

}

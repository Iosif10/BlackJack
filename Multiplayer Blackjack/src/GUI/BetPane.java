package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import GUI.ApplicationWindow.ButtonListener;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class BetPane extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton bet;
	private JButton cancelButton;
	private JComboBox<Integer> comboBox;
	public Client client;

	ButtonListener listener;

	/**
	 * Launch the application.
	 *//*
		 * public static void main(String[] args) { try { BetPane dialog = new
		 * BetPane(); dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
		 */

	/**
	 * Create the dialog.
	 * 
	 * @param client
	 */
	public BetPane(Client client) {

		this.client = client;

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Now, you have to chose you bet for this round. ");
			lblNewLabel.setBounds(79, 11, 259, 47);
			contentPanel.add(lblNewLabel);
		}

		comboBox = new JComboBox<Integer>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "5", "15", "50", "100", "200", "400", "1000" }));
		comboBox.setBounds(59, 89, 142, 20);
		contentPanel.add(comboBox);

		JLabel lblUsd = new JLabel("USD");
		lblUsd.setBounds(202, 92, 46, 14);
		contentPanel.add(lblUsd);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				bet = new JButton("BET");
				bet.setActionCommand("OK");
				buttonPane.add(bet);
				getRootPane().setDefaultButton(bet);
			}

			bet.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (listener != null) {
						client.bet = Integer.valueOf((String) comboBox.getSelectedItem());
						System.out.println(client.bet);
						listener.onClick();
					}
				}

			});

			{
				cancelButton = new JButton("Skip this round");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}

			cancelButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					// listener.onclick();

				}

			});
		}
	}

	public void setListener(ButtonListener listener) {
		
		this.listener = listener;
	}

}

package GUI;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Application {

	public Client client = new Client();

	CommunicationCenter comunications;

	ApplicationWindow aW;

	public void run() throws Exception {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				aW = new ApplicationWindow(client);
				
				try {
					comunications = new CommunicationCenter(client, aW);
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if (client.notAccepted) {
					JOptionPane.showMessageDialog(new JPanel() , "Sorry, the table is full. Please try again later.");
					
				} else {
					aW.frmBlackjackMultiplayer.setVisible(true);
				}

			}

		});

		
	}

}

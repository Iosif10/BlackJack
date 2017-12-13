package GUI;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.SwingUtilities;

public class Application {

	public Client client = new Client();

	ComunicationCenter comunications;

	ApplicationWindow aW;

	public void run() throws Exception {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				aW = new ApplicationWindow(client);
				aW.frmBlackjackMultiplayer.setVisible(true);
				try {
					comunications = new ComunicationCenter(client, aW);
				} catch (UnknownHostException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		
	}

}

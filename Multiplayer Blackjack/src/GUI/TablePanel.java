package GUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import GUI.ApplicationWindow.ButtonListener;

import javax.swing.JButton;

public class TablePanel extends JPanel {
	
	

	public Client client;
	public ButtonListener listener;

	/**
	 * Create the panel.
	 * @param client 
	 */
	public TablePanel(Client client) {
		
		this.client = client;
//		setListener(listener);
		
		setLayout(null);
		
		JPanel panel = new TableDrawingComponent();
		panel.setBounds(0, 0, 915, 461);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 460, 915, 199);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 275, 188);
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(273, 0, 267, 188);
		panel_1.add(panel_3);
		
		JButton hit = new JButton("HIT");
		hit.setBounds(682, 11, 105, 35);
		panel_1.add(hit);
		
		JButton stand = new JButton("STAND");
		stand.setBounds(682, 57, 105, 35);
		panel_1.add(stand);
		
		JButton dble = new JButton("DOUBLE");
		dble.setBounds(682, 103, 105, 35);
		panel_1.add(dble);
		
		JButton split = new JButton("SPLIT");
		split.setBounds(682, 149, 105, 35);
		panel_1.add(split);

	}
	
	public void setListener(ButtonListener listener) {
		this.listener = listener;
	}
}

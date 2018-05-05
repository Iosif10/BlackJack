package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class WelcomeDrawingComponent extends JPanel{

	@Override
	public void paintComponent (Graphics g) {
		
		super.paintComponent(g);
		
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(this.getClass().getResource("/Resources/sky.jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		g.drawImage(image, 0, 0, this);
	}
}

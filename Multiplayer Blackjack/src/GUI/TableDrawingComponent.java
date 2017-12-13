package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TableDrawingComponent extends JPanel{

	@Override
	public void paintComponent (Graphics g) {
		
		super.paintComponent(g);
		
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(this.getClass().getResource("/Resources/table.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g.drawImage(image, 0, 0, this);
		
				

	}
}
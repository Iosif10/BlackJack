package Server;

import javax.swing.ImageIcon;

public class Card {
	
	public int value;
	public String color;
		
	public Card (int value, String color) {
		
		this.value = value;
		this.color = color;
		
	}

	@Override
	public String toString() {
		return value + "#" + color + "#";
	}
	
	

}

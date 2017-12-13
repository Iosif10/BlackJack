package Server;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class CardDeck {
	
	ArrayList <Card> cardDeck;
	
	public CardDeck () {
		
		cardDeck = new ArrayList<>();
		
		cardDeck.add(new Card(1, "club", new ImageIcon("C://Users//ay12147//workspaceJava//Multiplayer%20Blackjack//res//cards//1club.png")));
	}

}

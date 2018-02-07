package Server;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

public class CardDeck {
	
	ArrayList <Card> cardDeck;
	
	public CardDeck () {
		
		cardDeck = new ArrayList<>();
		
		cardDeck.add(new Card(1, "club"));
		cardDeck.add(new Card(1, "diamond"));
		cardDeck.add(new Card(1, "heart"));
		cardDeck.add(new Card(1, "spade"));
		cardDeck.add(new Card(2, "club"));
		cardDeck.add(new Card(2, "diamond"));
		cardDeck.add(new Card(2, "heart"));
		cardDeck.add(new Card(2, "spade"));
		cardDeck.add(new Card(3, "club"));
		cardDeck.add(new Card(3, "diamond"));
		cardDeck.add(new Card(3, "heart"));
		cardDeck.add(new Card(3, "spade"));
		cardDeck.add(new Card(4, "club"));
		cardDeck.add(new Card(4, "diamond"));
		cardDeck.add(new Card(4, "heart"));
		cardDeck.add(new Card(4, "spade"));
		cardDeck.add(new Card(5, "club"));
		cardDeck.add(new Card(5, "diamond"));
		cardDeck.add(new Card(5, "heart"));
		cardDeck.add(new Card(5, "spade"));
		cardDeck.add(new Card(6, "club"));
		cardDeck.add(new Card(6, "diamond"));
		cardDeck.add(new Card(6, "heart"));
		cardDeck.add(new Card(6, "spade"));
		cardDeck.add(new Card(7, "club"));
		cardDeck.add(new Card(7, "diamond"));
		cardDeck.add(new Card(7, "heart"));
		cardDeck.add(new Card(7, "spade"));
		cardDeck.add(new Card(8, "club"));
		cardDeck.add(new Card(8, "diamond"));
		cardDeck.add(new Card(8, "heart"));
		cardDeck.add(new Card(8, "spade"));
		cardDeck.add(new Card(9, "club"));
		cardDeck.add(new Card(9, "diamond"));
		cardDeck.add(new Card(9, "heart"));
		cardDeck.add(new Card(9, "spade"));
		cardDeck.add(new Card(10, "club"));
		cardDeck.add(new Card(10, "diamond"));
		cardDeck.add(new Card(10, "heart"));
		cardDeck.add(new Card(10, "spade"));
		cardDeck.add(new Card(12, "club"));
		cardDeck.add(new Card(12, "diamond"));
		cardDeck.add(new Card(12, "heart"));
		cardDeck.add(new Card(12, "spade"));
		cardDeck.add(new Card(13, "club"));
		cardDeck.add(new Card(13, "diamond"));
		cardDeck.add(new Card(13, "heart"));
		cardDeck.add(new Card(13, "spade"));
		cardDeck.add(new Card(14, "club"));
		cardDeck.add(new Card(14, "diamond"));
		cardDeck.add(new Card(14, "heart"));
		cardDeck.add(new Card(14, "spade"));
		
		shuffleCards();
	}
	
	public void shuffleCards() {
		Collections.shuffle(this.cardDeck);
	}
	
	public Card giveCard() {
		Card card = cardDeck.get(cardDeck.size()-1);
		cardDeck.remove(cardDeck.size()-1);
		return card;
	}

}

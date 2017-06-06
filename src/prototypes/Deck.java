package prototypes;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private int showCount = 0;
	
	private ArrayList<Card> cards;
	
	public Deck() {
		this.cards = new ArrayList<Card>();
//		
//		this.cards.add(new Card("Test1", "First test card"));
//		this.cards.add(new Card("Test2", "Second test card"));
//		this.cards.add(new Card("Test3", "Third test card"));
//		this.cards.add(new Card("Test4", "Fourth test card"));
//		this.cards.add(new Card("Test5", "Fifth test card"));
//		
//		//Put correct cards in deck
	}
	
	public Deck(int size) {
		this.cards = new ArrayList<Card>();
		for (int i = 1; i <= size; i++) {
			this.cards.add(new Card("" + i, "This is a test card"));
		}
	}
	
	public ArrayList<Card> getCards() {
		return this.cards;
	}
	
	public int getDeckSize() {
		return getCards().size();
	}

	public void shuffle() {
		ArrayList<Card> shuffledDeck = new ArrayList<Card>();
		Random rand = new Random();
		
		while(getDeckSize() > 0) {
			int index = rand.nextInt(getDeckSize());
			Card card = getCards().remove(index);
			shuffledDeck.add(card);
		}
		
		this.cards = shuffledDeck;
		
	}
	
	//TODO: Add end of deck exception
	public Card deal() {
		return getCards().remove(0);
	}
	
	//TODO: Convenience function for testing, maybe remove for prod
	public Card show() {
		Card card = getCards().get(this.showCount);
		showCount++;
		showCount %= getDeckSize();
		
		return card;
	}
	
	public void insert(Card card) {
		Random rand = new Random();
		int index = rand.nextInt(getDeckSize());
		getCards().add(index, card);
	}
	
	public void insertBottom(Card card) {
		getCards().add(card);
	}
	
	public void insertTop(Card card) {
		getCards().add(0, card);
	}
	
}

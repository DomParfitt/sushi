package prototypes;

public class Hand {
	
	private Deck cards;
	
	public Hand() {
		this.cards = new Deck();
		this.cards.getCards().clear();
	}
	
	public int getHandSize() {
		return this.cards.getDeckSize();
	}
	
	public void addCard(Card card) {
		this.cards.insertBottom(card);
	}
	
	public Card playCard(Card card) {
		this.cards.getCards().remove(card);
		
		return card;
	}
	
	public Card playCard(int index) {
		return this.cards.getCards().remove(index);
	}
	
	@Override
	public String toString() {
		String output = "";
		for (int i = 1; i <= getHandSize(); i++) {
			output += i + ": " + this.cards.show() + "\n";
		}
		
		return output;
	}
}

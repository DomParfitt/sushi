package cards;

/**
 * Abstract base class for the cards used in the game
 * @author Dom Parfitt
 *
 */
public abstract class Card {

	/**
	 * Enum of the different types of cards
	 */
	public static enum CARDTYPE {
		NIGIRI, WASABI, SASHIMI, TEMPURA, MAKI, CHOPSTICKS, PUDDING
	};
	
	protected String name = "";
	protected String text = "";
	protected int value;
	protected CARDTYPE type;
	
	/**
	 * Gets the card's name
	 * @return the card's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get the card text
	 * @return the card text
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Get the card value 
	 * @return the card value
	 */
	public int getValue() {
		return this.value;
	}
	
	/**
	 * Get the card type
	 * @return the type of the card
	 */
	public CARDTYPE getType() {
		return this.type;
	}

	@Override
	public String toString() {
		if(this.getValue() != 0) {
			return getName() + " (" + getValue() + ") - " + getText();
		} else {
			return getName() + " - " + getText();
		}
	}
	
	/**
	 * Compares two cards for equality
	 * @param other the other card
	 * @return whether the two cards are the same
	 */
	public boolean equals(Card other) {
		return getType().equals(other.getType()) &&
				getValue() == other.getValue();
	}
	
}

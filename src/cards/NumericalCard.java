package cards;

public abstract class NumericalCard extends Card {
	
	public NumericalCard(int value) {
		if (value >= 1 && value <= 3) {
			this.value = value;
		} else {
			throw new IllegalArgumentException("Value provided was " + value + ". Value of card must be 1, 2 or 3");
		}
	}

}

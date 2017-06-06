package cards;
public abstract class Card {

	public static enum CARDTYPE {
		NIGIRI, WASABI, SASHIMI, TEMPURA, MAKI, CHOPSTICKS, PUDDING
	};
	
	protected String name = "";
	protected String text = "";
	protected int value;
	protected CARDTYPE type;
	
	public String getName() {
		return this.name;
	}

	public String getText() {
		return this.text;
	}

	public int getValue() {
		return this.value;
	}
	
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
	
}

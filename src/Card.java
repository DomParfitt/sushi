
public class Card {

	public static enum CARDTYPE {
		NIGIRI, WASABI, SASHIMI, TEMPURA, MAKI, CHOPSTICKS, PUDDING
	};

	private String name;
	private String text;
	private int value;
	private CARDTYPE type;

	public Card(CARDTYPE type, int value) {

		switch (type) {
			case NIGIRI:
				if (value >= 1 && value <= 3) {
					this.value = value;
					switch (value) {
					case 1:
						this.name = "Egg Nigiri";
						break;
					case 2:
						this.name = "Squid Nigiri";
						break;
					case 3:
						this.name = "Salmon Nigiri";
						break;
					}
				} else {
					throw new IllegalArgumentException("Nigiri must have a value of 1, 2 or 3.");
				}
				break;
			case MAKI:
				if (value >= 1 && value <= 3) {
					this.value = value;
					this.name = "Maki Roll";
				} else {
					throw new IllegalArgumentException("Maki Rolls must have a value of 1, 2 or 3.");
				}
				break;
		case CHOPSTICKS:
			this.name = "Chopsticks";
			this.text = "Play this and pick up two";
			break;
		case PUDDING:
			this.name = "Pudding";
			this.text = "Most at end = +6. Least at end = -6";
			break;
		case SASHIMI:
			this.name = "Sashimi";
			this.text = "10 points for 3";
			break;
		case TEMPURA:
			this.name = "Tempura";
			this.text = "5 points for 2";
			break;
		case WASABI:
			this.name = "Wasabi";
			this.text = "Next Nigiri gets a 3x multiplier";
			break;
		default:
			break;

		}
		this.type = type;
	}

	public Card(String name, String text) {
		this.name = name;
		this.text = text;
		this.value = 0;
	}

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

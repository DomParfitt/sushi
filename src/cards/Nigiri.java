package cards;

public class Nigiri extends NumericalCard {

	public Nigiri(int value) {
		super(value);
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
//		default:
//			throw new IllegalArgumentException("Nigiri must have a value of 1, 2 or 3");
		}
		
		this.type = CardType.NIGIRI;
	}

}

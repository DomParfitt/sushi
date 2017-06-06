package cardPools;

import java.util.TreeMap;

import cards.Card;

public class StandardCardPool extends CardPool {
	
	public StandardCardPool() {
		this.pool = new TreeMap<Card.CARDTYPE, Integer>();
		for (Card.CARDTYPE type : Card.CARDTYPE.values()) {
			this.pool.put(type, 10);
		}
	}

}

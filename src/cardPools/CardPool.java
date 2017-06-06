package cardPools;

import java.util.Map;

import cards.Card;

public abstract class CardPool {
	
	protected Map<Card.CARDTYPE, Integer> pool;
	
//	public CardPool() {
//		this.pool = new TreeMap<Card.CARDTYPE, Integer>();
//	}

	public Map<Card.CARDTYPE, Integer> getPool() {
		return this.pool;
	}
	
}

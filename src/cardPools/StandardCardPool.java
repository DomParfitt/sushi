package cardPools;

import java.util.TreeMap;

import cards.Card;

/**
 * Concrete implementation of the abstract CardPool class
 * containing the standard card set. 
 * @author Dom Parfitt
 *
 */
public class StandardCardPool extends CardPool {
	
	/**
	 * Initialises the standard card pool
	 */
	public StandardCardPool() {
		this.pool = new TreeMap<Card.CARDTYPE, Integer>();
		
		//TODO: Check the actual numbers
		for (Card.CARDTYPE type : Card.CARDTYPE.values()) {
			this.pool.put(type, 10);
		}
	}

}

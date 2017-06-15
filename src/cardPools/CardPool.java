package cardPools;

import java.util.Map;

import cards.Card;

/**
 * Abstract base class for a pool of cards that can
 * be used to build a deck. Holds a map listing 
 * the cards in the pool and the number of each
 * @author Dom Parfitt
 *
 */
public abstract class CardPool {
	
	protected Map<Card.CardType, Integer> pool;
	
	/**
	 * Gets the map containing the pool of cards
	 * @return the pool of cards
	 */
	public Map<Card.CardType, Integer> getPool() {
		return this.pool;
	}
	
}

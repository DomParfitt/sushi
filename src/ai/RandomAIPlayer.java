package ai;

import java.util.Random;

import cards.Card;

/**
 * Simple AI implementation which plays cards randomly
 * @author Dom Parfitt
 *
 */
public class RandomAIPlayer extends AIPlayer {

	/**
	 * Initialises the AI with a name
	 * @param name the name of the AI
	 */
	public RandomAIPlayer(String name) {
		super(name);
	}
	
	@Override
	public Card requestCard() {
		Random rand = new Random();
		int index = rand.nextInt(this.getHand().size());
		return this.getHand().get(index);
		
	}

}

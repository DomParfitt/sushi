package ai;

import cards.Card;
import core.Player;

/**
 * Abstract base class for an AI controlled Player
 * @author Dom Parfitt
 *
 */
public abstract class AIPlayer extends Player {

	/**
	 * Initialises the AI 
	 * @param name the name for the AI
	 */
	public AIPlayer(String name) {
		super(name);
	}
	
	@Override
	public abstract Card requestCard();

}

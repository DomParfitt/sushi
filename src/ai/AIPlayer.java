package ai;

import cards.Card;
import core.Player;

public abstract class AIPlayer extends Player {

	public AIPlayer(String name) {
		super(name);
	}
	
	@Override
	public abstract Card requestCard();

}

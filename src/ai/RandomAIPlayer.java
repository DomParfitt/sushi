package ai;

import java.util.Random;

import cards.Card;
import core.Player;

public class RandomAIPlayer extends Player {

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

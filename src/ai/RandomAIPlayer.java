package ai;

import java.util.Random;

import cards.Card;

public class RandomAIPlayer extends AIPlayer {

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

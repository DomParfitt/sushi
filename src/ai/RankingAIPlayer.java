package ai;

import java.util.Collections;
import java.util.Comparator;

import cards.Card;

/**
 * Provides a base class for any AI player which ranks cards and then plays
 * the highest value card. Allows specific ranking methods to be implemented
 * by simply defining differently comparators in the base classes
 * @author Dom Parfitt
 *
 */
public abstract class RankingAIPlayer extends AIPlayer {
	
	protected Comparator<Card> comparator;

	public RankingAIPlayer(String name, Comparator<Card> comparator) {
		this(name);
		this.comparator = comparator;
	}
	
	public RankingAIPlayer(String name) {
		super(name);
	}
	
	public void setComparator(Comparator<Card> comparator) {
		this.comparator = comparator;
	}

	@Override
	public Card requestCard() {
		getHand().sort(comparator);
		Collections.reverse(getHand());
		return getHand().get(0);
	}

}

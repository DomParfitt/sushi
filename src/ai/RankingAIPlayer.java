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
//TODO: Does it make more sense to have a default comparator and just pass the CARDTYPE?
public abstract class RankingAIPlayer extends AIPlayer {
	
	protected Comparator<Card> comparator;

	/**
	 * Initialises the AI player with a comparator
	 * @param name the name of the AI 
	 * @param comparator
	 */
	public RankingAIPlayer(String name, Comparator<Card> comparator) {
		this(name);
		this.comparator = comparator;
	}
	
	/**
	 * Initialises the AI with a name
	 * @param name the name of the AI
	 */
	public RankingAIPlayer(String name) {
		super(name);
	}
	
	/**
	 * Sets the comparator 
	 * @param comparator the comparator to use
	 */
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

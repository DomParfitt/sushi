package core;

import java.util.ArrayList;
import java.util.Random;

import cardPools.CardPool;
import cards.Card;
import cards.Chopsticks;
import cards.Dumpling;
import cards.MakiRoll;
import cards.Nigiri;
import cards.Pudding;
import cards.Sashimi;
import cards.Tempura;
import cards.Wasabi;

/**
 * Class to represent a deck of cards
 * @author Dom Parfitt
 *
 */
public class Deck {

	private int showCount = 0;
	private ArrayList<Card> cards;

	/**
	 * Initialises an empty deck
	 */
	public Deck() {
		this.cards = new ArrayList<Card>();
	}

	/**
	 * Initialises a deck with the cards in the provided card pool
	 * @param pool
	 */
	public Deck(CardPool pool) {
		this();
		for (Card.CardType cardType : pool.getPool().keySet()) {
			for (int i = 0; i < pool.getPool().get(cardType); i++) {
				switch (cardType) {
				case MAKI:
					for (int j = 1; j <= 3; j++) {
						this.cards.add(new MakiRoll(j));
					}
					break;
				case NIGIRI:
					for (int k = 1; k <= 3; k++) {
						this.cards.add(new Nigiri(k));
					}
					break;
				case CHOPSTICKS:
					this.cards.add(new Chopsticks());
					break;
				case PUDDING:
					this.cards.add(new Pudding());
					break;
				case SASHIMI:
					this.cards.add(new Sashimi());
					break;
				case TEMPURA:
					this.cards.add(new Tempura());
					break;
				case WASABI:
					this.cards.add(new Wasabi());
					break;
				case DUMPLING:
					this.cards.add(new Dumpling());
				default:
					break;

				}
			}
		}

	}

	/**
	 * Gets the cards in the deck
	 * @return a List of Card objects
	 */
	public ArrayList<Card> getCards() {
		return this.cards;
	}

	/**
	 * Gets the size of the deck
	 * @return the size of the deck
	 */
	public int getDeckSize() {
		return getCards().size();
	}

	/**
	 * Shuffle the deck so that the cards are now in a random
	 * order
	 */
	public void shuffle() {
		ArrayList<Card> shuffledDeck = new ArrayList<Card>();
		Random rand = new Random();

		while (getDeckSize() > 0) {
			int index = rand.nextInt(getDeckSize());
			Card card = getCards().remove(index);
			shuffledDeck.add(card);
		}

		this.cards = shuffledDeck;

	}

	// TODO: Add end of deck exception
	/**
	 * Deals the top card from the deck
	 * @return the top card of the deck
	 */
	public Card deal() {
		return getCards().remove(0);
	}

	// TODO: Convenience function for testing, maybe remove for prod
	public Card show() {
		Card card = getCards().get(this.showCount);
		showCount++;
		showCount %= getDeckSize();

		return card;
	}

	/**
	 * Inserts a card randomly into the deck
	 * @param card the card to insert
	 */
	public void insert(Card card) {
		if (getDeckSize() == 0) {
			insertTop(card);
		} else {
			Random rand = new Random();
			int index = rand.nextInt(getDeckSize());
			getCards().add(index, card);
		}
	}

	/**
	 * Puts the card at the bottom of the deck
	 * @param card the card to add to the deck
	 */
	public void insertBottom(Card card) {
		getCards().add(card);
	}

	/**
	 * Puts the card on the top of the deck
	 * @param card the card to add to the deck
	 */
	public void insertTop(Card card) {
		getCards().add(0, card);
	}

}

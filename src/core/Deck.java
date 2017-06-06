package core;

import java.util.ArrayList;
import java.util.Random;

import cardPools.CardPool;
import cards.Card;
import cards.Chopsticks;
import cards.MakiRoll;
import cards.Nigiri;
import cards.Pudding;
import cards.Sashimi;
import cards.Tempura;
import cards.Wasabi;

public class Deck {

	private int showCount = 0;

	private ArrayList<Card> cards;

	public Deck() {
		this.cards = new ArrayList<Card>();
	}

	public Deck(CardPool pool) {
		this();
		for (Card.CARDTYPE cardType : pool.getPool().keySet()) {
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
				default:
					break;

				}
			}
		}

	}

	public ArrayList<Card> getCards() {
		return this.cards;
	}

	public int getDeckSize() {
		return getCards().size();
	}

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

	public void insert(Card card) {
		if (getDeckSize() == 0) {
			insertTop(card);
		} else {
			Random rand = new Random();
			int index = rand.nextInt(getDeckSize());
			getCards().add(index, card);
		}
	}

	public void insertBottom(Card card) {
		getCards().add(card);
	}

	public void insertTop(Card card) {
		getCards().add(0, card);
	}

}

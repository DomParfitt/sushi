package ai;

import java.util.Comparator;

import cards.Card;
import cards.Card.CARDTYPE;

/**
 * Implementation of the RankingAIPlayer which can work for any card
 * type provided (rather than have a new class for each card)
 * @author Dom Parfitt
 *
 */
public class SingleCardRankingAIPlayer extends RankingAIPlayer {

	private CARDTYPE cardType;
	
	/**
	 * Initialise with a name and a card type to favour
	 * @param name the name of the AI
	 * @param cardType the card type that the AI favours
	 */
	public SingleCardRankingAIPlayer(String name, CARDTYPE cardType) {
		super(name);
		this.cardType = cardType;
		setComparator(new Comparator<Card>() {
			
			@Override
			public int compare(Card card1, Card card2) {
				if (card1.getType() == getCardType() && card2.getType() == getCardType()) {
					Integer val1 = card1.getValue();
					Integer val2 = card2.getValue();
					return val1.compareTo(val2);
				} else if (card1.getType() == getCardType()) {
					return 1;
				} else if (card2.getType() == getCardType()) {
					return -1;
				} else {
					Integer val1 = card1.getValue();
					Integer val2 = card2.getValue();
					return val1.compareTo(val2);
				}
			}
		});
	}
	
	/**
	 * Gets the card type that the AI favours
	 * @return the card type
	 */
	public CARDTYPE getCardType() {
		return this.cardType;
	}

}

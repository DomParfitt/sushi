package ai;

import java.util.Comparator;

import cards.Card;
import cards.Card.CardType;

/**
 * Concrete implementation of a ranking AI which places the most
 * value of Maki Rolls
 * @author Dom Parfitt
 *
 */
@Deprecated
public class MakiAI extends RankingAIPlayer {

	public MakiAI(String name) {
		super(name);
		super.setComparator(new Comparator<Card>() {

			@Override
			public int compare(Card card1, Card card2) {
				if (card1.getType() == CardType.MAKI && card2.getType() == CardType.MAKI) {
					Integer val1 = card1.getValue();
					Integer val2 = card2.getValue();
					return val1.compareTo(val2);
				} else if (card1.getType() == CardType.MAKI) {
					return 1;
				} else if (card2.getType() == CardType.MAKI) {
					return -1;
				} else {
					//What to do if neither are Makis?
					Integer val1 = card1.getValue();
					Integer val2 = card2.getValue();
					return val1.compareTo(val2);
				}
			}
			
		});
	}

}

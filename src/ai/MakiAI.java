package ai;

import java.util.Comparator;

import cards.Card;
import cards.Card.CARDTYPE;

/**
 * Concrete implementation of a ranking AI which places the most
 * value of Maki Rolls
 * @author Dom Parfitt
 *
 */
public class MakiAI extends RankingAIPlayer {

	public MakiAI(String name) {
		super(name);
		super.setComparator(new Comparator<Card>() {

			@Override
			public int compare(Card card1, Card card2) {
				if (card1.getType() == CARDTYPE.MAKI && card2.getType() == CARDTYPE.MAKI) {
					Integer val1 = card1.getValue();
					Integer val2 = card2.getValue();
					return val1.compareTo(val2);
				} else if (card1.getType() == CARDTYPE.MAKI) {
					return 1;
				} else if (card2.getType() == CARDTYPE.MAKI) {
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

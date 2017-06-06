import java.util.ArrayList;
import java.util.Random;

import cards.Card;
import cards.Chopsticks;
import cards.MakiRoll;
import cards.Nigiri;
import cards.Pudding;
import cards.Sashimi;
import cards.Tempura;
import cards.Wasabi;

public class Runner {

	public static void main(String[] args) {

		// Game game = new Game();
		// Player dom = new Player("Dom");
		// Player chris = new Player("Chris");
		// Player lucy = new Player("Lucy");
		//
		// game.addPlayer(dom);
		// game.addPlayer(chris);
		// game.addPlayer(lucy);
		// System.out.println(game.showPlayers());
		// game.deal();
		// System.out.println(dom.viewHand());
		// System.out.println();
		//
		// game.play();
		// System.out.println(game.showScores());
		// game.play();
		// System.out.println(game.showScores());
		// game.play();
		// System.out.println(game.showScores());
		// game.play();
		// System.out.println(game.showScores());

		ArrayList<Class<? extends Card>> cardPool = new ArrayList<Class<? extends Card>>();
		cardPool.add(Nigiri.class);
		cardPool.add(Wasabi.class);
		cardPool.add(Tempura.class);
		cardPool.add(Chopsticks.class);
		cardPool.add(MakiRoll.class);
		cardPool.add(Pudding.class);
		cardPool.add(Sashimi.class);

		Card[][] hands = new Card[5][5];

		Card[] cards = new Card[5];

		for (int j = 0; j < 5; j++) {

			for (int i = 0; i < 5; i++) {
				Random rand = new Random();
				Random randVal = new Random();
				int value = randVal.nextInt(3) + 1;

				int index = rand.nextInt(Card.CARDTYPE.values().length);
				Card.CARDTYPE type = Card.CARDTYPE.values()[index];
				Card card = null;
				switch (type) {
				case MAKI:
					card = new MakiRoll(value);
					break;
				case NIGIRI:
					card = new Nigiri(value);
					break;
				case CHOPSTICKS:
					card = new Chopsticks();
					break;
				case PUDDING:
					card = new Pudding();
					break;
				case SASHIMI:
					card = new Sashimi();
					break;
				case TEMPURA:
					card = new Tempura();
					break;
				case WASABI:
					card = new Wasabi();
					break;
				default:
					break;

				}
				// cards[i] = card;
				hands[j][i] = card;
			}
		}
		
		Score[] scores = new Score[5];

		for (int j = 0; j < 5; j++) {

			for (int i = 0; i < 5; i++) {
				System.out.println(hands[j][i]);
			}
			System.out.println();
			scores[j] = Score.getScore(hands[j]);
			System.out.println("Player " + (j+1) + " scored " + scores[j].getNumScore());
			System.out.println();
			
		}


		Score[] scoreWithMaki = Score.addMakis(scores);
		
		for (int k = 0; k < 5; k++) {
			
			System.out.println("Player " + (k+1) + " scored " + scores[k].getNumScore() + " after Makis");
		}

	}

}

import core.Game;
import core.Player;

public class Runner {

	public static void main(String[] args) {

		Game game = new Game();
		game.addPlayer(new Player("Dom"));
		game.addPlayer(new Player("Chris"));
		game.play();
		
//		ArrayList<Class<? extends Card>> cardPool = new ArrayList<Class<? extends Card>>();
//		cardPool.add(Nigiri.class);
//		cardPool.add(Wasabi.class);
//		cardPool.add(Tempura.class);
//		cardPool.add(Chopsticks.class);
//		cardPool.add(MakiRoll.class);
//		cardPool.add(Pudding.class);
//		cardPool.add(Sashimi.class);
//
//		Card[][] hands = new Card[5][5];
//
//		Card[] cards = new Card[5];
//
//		for (int j = 0; j < 5; j++) {
//
//			for (int i = 0; i < 5; i++) {
//				Random rand = new Random();
//				Random randVal = new Random();
//				int value = randVal.nextInt(3) + 1;
//
//				int index = rand.nextInt(Card.CARDTYPE.values().length);
//				Card.CARDTYPE type = Card.CARDTYPE.values()[index];
//				Card card = null;
//				switch (type) {
//				case MAKI:
//					card = new MakiRoll(value);
//					break;
//				case NIGIRI:
//					card = new Nigiri(value);
//					break;
//				case CHOPSTICKS:
//					card = new Chopsticks();
//					break;
//				case PUDDING:
//					card = new Pudding();
//					break;
//				case SASHIMI:
//					card = new Sashimi();
//					break;
//				case TEMPURA:
//					card = new Tempura();
//					break;
//				case WASABI:
//					card = new Wasabi();
//					break;
//				default:
//					break;
//
//				}
//				// cards[i] = card;
//				hands[j][i] = card;
//			}
//		}
//
//		Score[] scores = new Score[5];
//
//		for (int j = 0; j < 5; j++) {
//
//			for (int i = 0; i < 5; i++) {
//				System.out.println(hands[j][i]);
//			}
//			System.out.println();
//			scores[j] = Score.getScore(hands[j]);
//			System.out.println("Player " + (j + 1) + " scored " + scores[j].getNumScore());
//			System.out.println();
//
//		}
//
//		Score[] scoreWithMaki = Score.addMakis(scores);
//
//		for (int k = 0; k < 5; k++) {
//
//			System.out.println("Player " + (k + 1) + " scored " + scoreWithMaki[k].getNumScore() + " after Makis");
//		}
//
//		System.out.println();
//		
//		Score[] scoreWithPuddings = Score.addPuddings(scoreWithMaki);
//
//		for (int k = 0; k < 5; k++) {
//
//			System.out.println("Player " + (k + 1) + " scored " + scoreWithPuddings[k].getNumScore() + " after Puddings");
//		}

	}

}

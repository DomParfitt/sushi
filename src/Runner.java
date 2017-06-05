
public class Runner {
	
	public static void main(String[] args) {
//		Deck deck = new Deck();
//		deck.shuffle();
//		
//		Hand hand = new Hand();
//		
//		for (int i = 0; i < 3; i++) {
//			hand.addCard(deck.deal());
//		}
//		
//		System.out.println(hand.viewHand());
		
//		for (int i = 0; i < deck.getDeckSize(); i++) {
//			System.out.println(deck.show());
//		}
//		
//		System.out.println();
//		
////		Deck deck2 = new Deck();
////		deck2.shuffle();
////		
//		
//		deck.shuffle();
//		
//		while (deck.getDeckSize() > 0) {
//			System.out.println(deck.deal());
//		}
		
		Game game = new Game();
		Player dom = new Player("Dom");
		Player chris = new Player("Chris");
		Player lucy = new Player("Lucy");
		
		game.addPlayer(dom);
		game.addPlayer(chris);
		game.addPlayer(lucy);
		System.out.println(game.showPlayers());
		game.deal();
		System.out.println(dom.viewHand());
		System.out.println();

		game.play();
		System.out.println(game.showScores());
		game.play();
		System.out.println(game.showScores());
		game.play();
		System.out.println(game.showScores());
		game.play();
		System.out.println(game.showScores());
		
		
	}
	
}

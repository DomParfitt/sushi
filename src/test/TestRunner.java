package test;

import java.util.ArrayList;
import java.util.List;

import ai.CardTree;
import cards.Card;
import cards.Chopsticks;
import cards.MakiRoll;
import cards.Sashimi;
import cards.Tempura;
import cards.Wasabi;
import core.Game;
import core.Player;
import server.GameState;

public class TestRunner {

	public static void main(String[] args) {
		
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Game game = new Game(2);
		game.addPlayer(p1);
		
		GameState state = new GameState(p1, game);
		System.out.println("Single player");
		for (Player player : state.getPlayerDetails()) {
			System.out.println(player);
		}
		
		System.out.println("Two players");
		game.addPlayer(p2);
		state.update(new GameState(p1, game));
		for (Player player : state.getPlayerDetails()) {
			System.out.println(player);
		}
		
//		ArrayList<Card> cards = new ArrayList<>();
//		cards.add(new Wasabi());
//		cards.add(new MakiRoll(1));
//		cards.add(new MakiRoll(2));
//		cards.add(new MakiRoll(3));
//		
////		CardTree tree = new CardTree(cards);
////		tree.print();
////		
////		List<Card> newCards = new ArrayList<>();
////		newCards.add(new Sashimi());
////		newCards.add(new Tempura());
////		newCards.add(new Chopsticks());
////		
////		
////		
////		CardTree tree2 = new CardTree(newCards);
////		
////		System.out.println("Added branches");
////		tree.addBranch(tree2);
////		tree.print();
//		
//		List<CardTree> trees = CardTree.getTreeList(cards);
//		for(CardTree tree: trees) {
//			tree.print();
//			System.out.println();
//		}
		
	}
	
}

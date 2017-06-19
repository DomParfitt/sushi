package test;

import java.util.ArrayList;
import java.util.List;

import ai.CardForest;
import ai.CardTree;
import ai.CardTreePath;
import cards.Card;
import cards.Dumpling;
import cards.MakiRoll;
import cards.Nigiri;
import cards.Pudding;
import cards.Sashimi;
import cards.Tempura;
import cards.Wasabi;

public class TestRunner {

	public static void main(String[] args) {
		
		List<Card> cards = new ArrayList<>();
//		cards.add(new MakiRoll(1));
//		cards.add(new MakiRoll(2));
//		cards.add(new MakiRoll(3));
		cards.add(new Nigiri(1));
		cards.add(new Nigiri(2));
		cards.add(new Nigiri(3));
		
		List<Card> cards2 = new ArrayList<>();
		cards2.add(new Nigiri(1));
		cards2.add(new Nigiri(1));
		cards2.add(new Nigiri(1));

		List<Card> cards3 = new ArrayList<>();
		cards3.add(new MakiRoll(2));
		cards3.add(new Pudding());
		cards3.add(new Tempura());
		
		
		CardTree tree = new CardTree(new Pudding());
		tree.print();
		
//		tree.print();
		tree.addLevel(cards);
		tree.addLevel(cards2);
		tree.addLevel(cards3);
		tree.print();
		
		CardTree tree2 = new CardTree(new Sashimi());
		tree2.addLevel(cards);
		tree2.addLevel(cards2);
		tree2.addLevel(cards3);

		CardTree tree3 = new CardTree(new Nigiri(3));
		tree3.addLevel(cards);
		tree3.addLevel(cards2);
		tree3.addLevel(cards3);
		
		CardForest forest = new CardForest();
		forest.addTree(tree);
		forest.addTree(tree2);
		forest.addTree(tree3);
		
		CardTreePath path = forest.getOptimalPath();
		System.out.println("Estimated best score is: " + path.getEstimatedScore());
		System.out.println("Best path is: " + path.getBestPath());
		
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
////		newCards.add(new Chops)ticks());
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

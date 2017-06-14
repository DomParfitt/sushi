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

public class TestRunner {

	public static void main(String[] args) {
		ArrayList<Card> cards = new ArrayList<>();
		cards.add(new Wasabi());
		cards.add(new MakiRoll(1));
		cards.add(new MakiRoll(2));
		cards.add(new MakiRoll(3));
		
//		CardTree tree = new CardTree(cards);
//		tree.print();
//		
//		List<Card> newCards = new ArrayList<>();
//		newCards.add(new Sashimi());
//		newCards.add(new Tempura());
//		newCards.add(new Chopsticks());
//		
//		
//		
//		CardTree tree2 = new CardTree(newCards);
//		
//		System.out.println("Added branches");
//		tree.addBranch(tree2);
//		tree.print();
		
		List<CardTree> trees = CardTree.getTreeList(cards);
		for(CardTree tree: trees) {
			tree.print();
			System.out.println();
		}
		
	}
	
}

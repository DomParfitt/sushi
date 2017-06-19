package ai;

import java.util.ArrayList;
import java.util.List;

import cards.Card;

public class CardForest {
	
	private List<CardTree> trees;
	
	public CardForest() {
		this.trees = new ArrayList<>();
	}
	
	public void addTree(CardTree tree) {
		this.trees.add(tree);
	}
	
	public void addLevel(List<Card> cards) {
		for(CardTree tree : trees) {
			tree.addLevel(cards);
		}
	}
	
	public int getDepth() {
		//TODO: Implement
		return 0;
	}
	
	public CardTreePath getOptimalPath() {
		CardTreePath bestPath = new CardTreePath();
		for(CardTree tree: trees) {
			CardTreePath path = tree.getOptimalPath();
			if(path.isBetterThan(bestPath)) {
				bestPath = path;
			}
		}
		
		return bestPath;
	}

}

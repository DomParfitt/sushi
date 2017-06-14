package ai;

import java.util.ArrayList;
import java.util.List;

import cards.Card;

/**
 * Class to create a tree from a list of cards. To be used for AI determining
 * best course of action
 * 
 * @author Dom Parfitt
 *
 */
// TODO: Maybe refactor so that the root is a list of cards rather than a single
// card
// (would mean search methods could act on this object rather than a list of
// this object)
public class CardTree {

	private Card root;
	private List<CardTree> branches;

	/**
	 * Creates a tree with a root card and a list of cards. The root card acts
	 * as the first card played and the list of cards forms branches with all
	 * possible card combinations following that
	 * 
	 * @param rootCard
	 *            the root card
	 * @param cards
	 *            the other cards
	 */
	public CardTree(Card rootCard, List<Card> cards) {
		this(rootCard, cards, cards.size());
		// this.card = rootCard;
		// this.branches = new ArrayList<CardTree>();
		//
		// //Create a branch for each card in the list
		// for(Card card : cards) {
		//
		// //Create a copy of the list of cards without the current card
		// List<Card> newList = new ArrayList<Card>();
		// for (Card innerCard : cards) {
		// if(!innerCard.equals(card)) {
		// newList.add(innerCard);
		// }
		// }
		// newList.remove(card);
		//
		// //Construct a new CardTree to represent the branch - recursive
		// CardTree branch = new CardTree(card, newList);
		//
		// //Add the new branch
		// branches.add(branch);
		// }
	}

	/**
	 * Constructs a CardTree to a specified depth. Depth of 0 represents a tree
	 * with no branches, 1 has 1 level of branches, etc.
	 * 
	 * @param rootCard
	 *            the root card
	 * @param cards
	 *            the list of cards to form branches with
	 * @param depth
	 *            the depth to form a tree to
	 */
	public CardTree(Card rootCard, List<Card> cards, int depth) {
		// If depth provided is too large, change it
		if (depth > cards.size() || depth < 0) {
			depth = cards.size();
		}

		// Initialise fields
		this.root = rootCard;
		this.branches = new ArrayList<CardTree>();

		// Create a branch for each card in the list
		for (Card card : cards) {

			// Create a copy of the list of cards without the current card
			List<Card> newList = new ArrayList<Card>();
			for (Card innerCard : cards) {
				if (!innerCard.equals(card)) {
					newList.add(innerCard);
				}
			}

			// Construct a new CardTree to represent the branch - recursive
			CardTree branch;
			if (depth > 1) {
				branch = new CardTree(card, newList, depth - 1);
				branches.add(branch);
			} else if (depth == 1) {
				branch = new CardTree(card);
				branches.add(branch);
			}

			// Add the new branch
			// branches.add(branch);
		}

	}

	/**
	 * Create a CardTree from a list where the first card in 
	 * the list represents the root
	 * @param cards a list of cards
	 * @param depth the depth to build to
	 */
	public CardTree(List<Card> cards, int depth) {
		this(cards.remove(0), cards, depth);
	}

	/**
	 * Create a CardTree from a list where the first card in 
	 * the list represents the root
	 * @param cards a list of cards
	 */
	public CardTree(List<Card> cards) {
		this(cards, cards.size());
	}

	/**
	 * Create a leaf node
	 * 
	 * @param rootCard
	 *            the card in the leaf
	 */
	public CardTree(Card rootCard) {
		this.root = rootCard;
		this.branches = new ArrayList<CardTree>();
	}

	/**
	 * Private constructor for returning copies of branches. Final argument can
	 * be ignored as it is only to differentiate method signatures
	 * 
	 * @param rootCard
	 *            the root of the CardTree
	 * @param branches
	 *            the branches
	 * @param nil
	 *            not required, differentiates method signature
	 */
	private CardTree(Card rootCard, List<CardTree> branches, boolean nil) {
		this.root = rootCard;
		this.branches = branches;
	}

	/**
	 * Checks whether the node is a leaf (no children/branches)
	 * @return whether the node is a leaf or not
	 */
	public boolean isLeaf() {
		return branches.size() == 0;
	}
	
//	public int getNumOutcomes() {
//		for(CardTree branch : branches) {
//			if(branch.isLeaf()) {
//				return 1;
//			} else {
//				return branch.getNumOutcomes();
//			}
//		}
//	}

	/**
	 * Adds a new branch to the tree. The branch is only added to the ends of
	 * existing branches and is added to the end of all existing branches
	 * 
	 * @param newBranch
	 *            the new CardTree to add
	 */
	public void addBranch(CardTree newBranch) {
		for (CardTree branch : branches) {
			if (branch.isLeaf()) {
				branch.branches.add(newBranch);
			} else {
				branch.addBranch(newBranch);
			}
		}
	}

	public CardTree getBranch(int index) {
		if (index >= branches.size()) {
			// throw exception
			throw new IllegalArgumentException("Tree does not have " + index + " branches.");
		} else if (index == branches.size() - 1) {
			return new CardTree(root);
		} else {
			return new CardTree(root, branches, true);
		}
	}

	/**
	 * Prints out the tree in an easily readible format
	 */
	public void print() {
		print(1);
	}

	/**
	 * Helper for the public print function.
	 * 
	 * @param level
	 *            the level of the current part of the tree
	 */
	private void print(int level) {
		for (int i = 1; i < level; i++) {
			System.out.print("\t");
		}
		System.out.println("Level " + level + ": " + root);
		if (!isLeaf()) {
			for (CardTree branch : branches) {
				branch.print(level + 1);
			}
		}
	}

	/**
	 * Static method for creating a list of CardTrees. Creates one
	 * tree for each card in the list with that card acting as the
	 * root and the remaining cards forming the branches
	 * @param cards a list of cards
	 * @return a list of CardTrees
	 */
	public static List<CardTree> getTreeList(List<Card> cards) {
		List<CardTree> trees = new ArrayList<>();
		
		//Get each root
		for (Card root : cards) {
			
			//Create a list to hold the remaining cards
			List<Card> others = new ArrayList<>();
			for (Card card : cards) {
				if(!card.equals(root)) {
					others.add(card);
				}
			}
			
			// Create the tree
			CardTree tree = new CardTree(root, others);
			trees.add(tree);
		}

		return trees;
	}

}

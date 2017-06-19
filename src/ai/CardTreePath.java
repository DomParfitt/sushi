package ai;

import java.util.ArrayList;
import java.util.List;

import cards.Card;

/**
 * Helper class for getting the optimal path from a CardTree
 * @author Dom Parfitt
 *
 */
public class CardTreePath{
	
	private int estimatedScore;
	private List<Card> bestPath;
	private List<Card> currentPath;
	
	public CardTreePath() {
		this.bestPath = new ArrayList<>();
		this.currentPath = new ArrayList<>();
		this.estimatedScore = 0;
	}

	public int getEstimatedScore() {
		return estimatedScore;
	}

	public void setEstimatedScore(int estimatedScore) {
		this.estimatedScore = estimatedScore;
	}

	public List<Card> getBestPath() {
		return bestPath;
	}

	public void setBestPath(List<Card> bestPath) {
		this.bestPath = new ArrayList<>();
		for(Card card : bestPath) {
			this.bestPath.add(card);
		}
	}
	
	public void addCard(Card card) {
		this.bestPath.add(card);
	}
	
	public void removeLastCard() {
		this.bestPath.remove(bestPath.size() - 1);
	}
	
	public List<Card> getCurrentPath() {
		return currentPath;
	}

	public void setCurrentPath(List<Card> currentPath) {
		this.currentPath = currentPath;
	}
	
	public void addToCurrentPath(Card card) {
		this.currentPath.add(card);
	}
	
	public void removeFromCurrentPath() {
		this.currentPath.remove(currentPath.size() - 1);
	}
	
	public boolean isBetterThan(CardTreePath o) {
		if(this.getEstimatedScore() == o.getEstimatedScore()) {
			return this.getCurrentPath().size() <= o.getCurrentPath().size();
		} else {
			return this.getEstimatedScore() > o.getEstimatedScore();
		}
	}

}

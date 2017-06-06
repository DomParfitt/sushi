package core;

import java.util.ArrayList;

import cards.Card;

public class Player implements Comparable<Player> {

	private static int NUMBEROFPLAYERS = 1;
	
	private int number;
	private String name;
	private Score score;
	private ArrayList<Card> hand;
	private ArrayList<Card> playedCards; //Easier this way but needs to be dynamic
	
	public Player(String name) {
		//Give the player a unique ID
		this.number = Player.NUMBEROFPLAYERS;
		Player.NUMBEROFPLAYERS++;
		
		this.name = name;
		this.score = new Score();
		this.hand = new ArrayList<Card>();
		this.playedCards = new ArrayList<Card>();
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void receiveCard(Card card) {
		this.hand.add(card);
	}
	
	public void receiveHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	public Score getScore() {
		return this.score;
	}
	
	public void updateScore(Score newScore) {
		Score current = getScore();
		Score updated = current.addScore(newScore);
		this.score = updated;
	}
	
	public ArrayList<Card> getHand() {
		return this.hand;
	}
	
	public ArrayList<Card> getPlayedCards() {
		return this.playedCards;
	}
	
	public void clearPlayedCards() {
		this.playedCards = new ArrayList<Card>();
	}
	
	public void showHand() {
		for (int i = 0; i < this.hand.size(); i++) {
			System.out.println(i + " - " +this.hand.get(i));
		}
	}
	
	public void showPlayed() {
		for (int i = 0; i < this.playedCards.size(); i++) {
			System.out.println(i + " - " +this.playedCards.get(i));
		}
	}
	
	public void playCard(int index) {
		Card card = this.hand.remove(index);
		this.playedCards.add(card);
	}
	
	@Override
	public String toString() {
		return "Player " + getNumber() + " - " + getName();
	}

	@Override
	public int compareTo(Player o) {
		return ((Integer) this.getNumber()).compareTo(o.getNumber());
	}
}

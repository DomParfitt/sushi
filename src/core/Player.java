package core;

import java.util.ArrayList;
import java.util.List;

import cards.Card;

public class Player implements Comparable {

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
	
	public ArrayList<Card> getHand() {
		return this.hand;
	}
	
	public ArrayList<Card> getPlayedCards() {
		return this.playedCards;
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
	public int compareTo(Object otherPlayer) {
		return ((Integer) this.getNumber()).compareTo(((Player)otherPlayer).getNumber());
	}
}

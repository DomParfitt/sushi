package core;

import java.util.ArrayList;

import cards.Card;

public class Player implements Comparable<Player> {

	private static int NUMBEROFPLAYERS = 1;
	
	private int number;
	private String name;
	private Score score;
	private ArrayList<Card> hand;
	private ArrayList<Card> playedCards;
	private PlayerThread thread;
	private ActionQueue actionQueue;
	
	public Player(String name) {
		//Give the player a unique ID
		this.number = Player.NUMBEROFPLAYERS;
		Player.NUMBEROFPLAYERS++;
		
		this.name = name;
		this.score = new Score();
		this.hand = new ArrayList<Card>();
		this.playedCards = new ArrayList<Card>();
		this.actionQueue = new ActionQueue();
		this.thread = new PlayerThread(this);
	}
	
	private Player(String name, int number, ArrayList<Card> playedCards, Score score) {
		this.name = name;
		this.number = number;
		this.playedCards = playedCards;
		this.score = score;
		this.actionQueue = new ActionQueue(); //TODO: Think about whether this needs to be copied across
		this.thread = new PlayerThread(this);
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
	
	public ActionQueue getActionQueue() {
		return this.actionQueue;
	}
	
	public PlayerThread getPlayerThread() {
		return this.thread;
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
	
	public void playCard(Card card) {
		int index = this.hand.indexOf(card);
		playCard(index);
	}
	
	/**
	 * Makes a copy of the current player without exposing hidden information,
	 * such as the contents of their hand
	 * @return
	 */
	public Player getPublicDetails() {
		return new Player(this.name, this.number, this.playedCards, this.score);
	}
	
	@Override
	public String toString() {
		return "Player " + getNumber() + " - " + getName();
	}

	@Override
	public int compareTo(Player o) {
		return ((Integer) this.getNumber()).compareTo(o.getNumber());
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		} else if (other == this) {
			return true;
		} else {
			Player p = (Player) other;
			return this.number == p.getNumber(); 
		}
		
	}
}

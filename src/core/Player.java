package core;

import java.util.ArrayList;
import java.util.Observable;

import cards.Card;
import models.PlayerModel;

public class Player extends Observable implements Comparable<Player> {

	//TODO: This might not work as intended if there are multiple Games
	private static int NUMBER_OF_PLAYERS = 0;
	
	private int number;
	private String name;
	
	private Score score;
	
	private ArrayList<Card> hand;
	private ArrayList<Card> playedCards;
	private Card card;
	private boolean hasCard;
	
	//TODO: I think these can all be removed
	private PlayerModel model;
	
	/**
	 * Initialise a Player object
	 * @param name the player's chosen display name
	 */
	public Player(String name) {
		//Give the player a unique ID
		Player.NUMBER_OF_PLAYERS++;
		this.number = Player.NUMBER_OF_PLAYERS;
		
		this.name = name;
		this.score = new Score();
		this.hand = new ArrayList<Card>();
		this.playedCards = new ArrayList<Card>();
		this.hasCard = false;
		this.model = new PlayerModel(this);
	}
	
	/**
	 * Private constructor for creating a copy of a Player
	 * @param name the name of the player
	 * @param number the unique player number
	 * @param playedCards the played cards
	 * @param score the score
	 */
	private Player(String name, int number, ArrayList<Card> playedCards, Score score) {
		this.name = name;
		this.number = number;
		this.playedCards = playedCards;
		this.score = score;
	}
	
	/**
	 * Gets the player's unique number
	 * @return
	 */
	public int getNumber() {
		return this.number;
	}
	
	/**
	 * Gets the player's name
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	
	public PlayerModel getModel() {
		return this.model;
	}
	
	/**
	 * Method to receive a card and add it to the player's
	 * hand
	 * @param card the card to add
	 */
	public void receiveCard(Card card) {
		this.hand.add(card);
	}
	
	/**
	 * Method to receive a hand of cards
	 * @param hand the hand of cards
	 */
	public void receiveHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	/**
	 * Get the player's score object
	 * @return the Score object
	 */
	public Score getScore() {
		return this.score;
	}
	
	/**
	 * Update the player's score
	 * @param newScore the score to be added
	 */
	public void updateScore(Score newScore) {
		Score current = getScore();
		Score updated = current.addScore(newScore);
		this.score = updated;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Get the player's current hand
	 * @return the player's hand
	 */
	public ArrayList<Card> getHand() {
		return this.hand;
	}
	
	/**
	 * Get the cards the player has played this round
	 * @return the played cards
	 */
	public ArrayList<Card> getPlayedCards() {
		return this.playedCards;
	}
	
	/**
	 * Resets the played cards
	 */
	public void clearPlayedCards() {
		this.playedCards = new ArrayList<Card>();
	}
	
	/**
	 * Prints the player's hand to the console
	 */
	public void showHand() {
		for (int i = 0; i < this.hand.size(); i++) {
			System.out.println("\t" + i + " - " +this.hand.get(i));
		}
		System.out.println();
	}
	
	/**
	 * Prints the player's played cards to the console
	 */
	public void showPlayed() {
		for (int i = 0; i < this.playedCards.size(); i++) {
			System.out.println("\t" + i + " - " +this.playedCards.get(i));
		}
		System.out.println();
	}
	
	/**
	 * Add a card to the player's played cards based on it's
	 * index in their hand
	 * @param index the index of the card in their hand to be played
	 */
	public void playCard(int index) {
		Card card = this.hand.remove(index);
		this.playedCards.add(card);
	}
	
	/**
	 * Add a card to the player's played cards. 
	 * TODO: Add handling for when card isn't present
	 * @param card the card to add
	 */
	public void playCard(Card card) {
		int index = this.hand.indexOf(card);
		playCard(index);
	}
	
	
	//TODO: Maybe separate these two out into a model
	/**
	 * Marks a card to be played and notifies any waiting
	 * threads looking for a card
	 * @param card
	 */
	public synchronized void play(Card card) {
		this.card = card;
		this.hasCard = true;
		notifyAll();
	}
	
	/**
	 * Checks if there is a card available to 
	 * return to the Game object, otherwise waits
	 * @return
	 */
	public synchronized Card getCard() {
		setChanged();
		notifyObservers();
		while (!hasCard) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		hasCard = false;
		return this.card;
	}
	
	/**
	 * Method called by the Game object to alert the Player 
	 * that they need to provide a Card
	 * TODO: Maybe make this method part of an interface
	 * @return the Card the player wishes to play
	 */
	public Card requestCard() {
		return getCard();
//		Scanner in = new Scanner(System.in);
//		System.out.println(this);
//		System.out.println("Hand: ");
//		showHand();
//		System.out.println("Played: ");
//		showPlayed();
//		System.out.println("Enter the index of the card you wish to play. ");
//		int index = in.nextInt();
//		Card card = hand.get(index);
////		playCard(card);
//		return card;
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

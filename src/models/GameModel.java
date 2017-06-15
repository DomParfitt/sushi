package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import cards.Card;
import core.Game;
import core.Player;
import server.GameState;

/**
 * Observable model of the Game object
 * @author Dom Parfitt
 *
 */
public class GameModel extends Observable {

	private Game game;
	
	/**
	 * Initialise the model with a new Game with a set number of
	 * players
	 * @param maxPlayers
	 */
	public GameModel(int maxPlayers) {
		this.game = new Game(maxPlayers);
	}
	
	/**
	 * Initialise a model with an existing Game object
	 * @param game
	 */
	public GameModel(Game game) {
		this.game = game;
	}
	
	/**
	 * Add a new player to the game
	 * @param player the player to add
	 */
	public void addPlayer(Player player) {
		game.addPlayer(player);
		setChanged();
		notifyObservers();
	}
	
	public void start() {
		game.start();
		setChanged();
		notifyObservers();
	}
	
	public void deal() {
		game.deal();
		setChanged();
		notifyObservers();
	}
	
	public void playCard(Player player, Card card) {
		int index = game.getPlayers().indexOf(player);
		List<Card> hand = game.getPlayers().get(index).getHand();
		int cardIndex = hand.indexOf(card);
		game.getPlayers().get(index).playCard(cardIndex);
		setChanged();
		notifyObservers();
		
	}
	
	public void updateGameState(Game state) {
		this.game = state.getGame();
		setChanged();
		notifyObservers();
	}
	
	public void play() {
		this.game.play();
	}
	
	public ArrayList<Card> getHand(Player player) {
		return game.getHand(player);
	}
	
	public ArrayList<Card> getPlayedCards(Player player) {
		return game.getPlayedCards(player);
	}
}

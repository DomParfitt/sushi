package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import cards.Card;
import core.Game;
import core.Player;
import server.GameState;

public class GameModel extends Observable {

	private Game game;
	
	public GameModel() {
		this.game = new Game();
	}
	
	public GameModel(Game game) {
		this.game = game;
	}
	
	//TODO: Not sure yet if this will need to be where the synch is
	public synchronized void addPlayer(Player player) {
		game.addPlayer(player);
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
	
	public void updateGameState(GameState state) {
		this.game = state.getGame();
		setChanged();
		notifyObservers();
	}
	
	public void play() {
		this.game.playSingle();
	}
	
	public ArrayList<Card> getHand(Player player) {
		return game.getHand(player);
	}
	
	public ArrayList<Card> getPlayedCards(Player player) {
		return game.getPlayedCards(player);
	}
}

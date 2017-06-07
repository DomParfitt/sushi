package models;

import java.util.ArrayList;
import java.util.Observable;

import cards.Card;
import core.Game;
import core.Player;

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
	
	public ArrayList<Card> getHand(Player player) {
		return game.getHand(player);
	}
}

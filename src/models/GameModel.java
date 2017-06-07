package models;

import java.util.Observable;

import core.Game;
import core.Player;

public class GameModel extends Observable {

	private Game game;
	
	public GameModel(Game game) {
		this.game = game;
	}
	
	//TODO: Not sure yet if this will need to be where the synch is
	public synchronized void addPlayer(Player player) {
		game.addPlayer(player);
		setChanged();
		notifyObservers();
	}
}

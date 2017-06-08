package server;

import core.Game;
import core.Player;

/**
 * Object sent by the server to each player containing the current state
 * of the game
 * @author Dom Parfitt
 *
 */
public class GameState {
	
	private Player recipient;
	private Game game;
	
	public GameState(Player recipient, Game game) {

	}

}

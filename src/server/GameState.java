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
		this.recipient = recipient;
		this.game = new Game(game.getMaxPlayers());
		for (Player player : game.getPlayers()) {
			if (player.equals(recipient)) {
				this.game.addPlayer(player);
			} else {
				Player playerCopy = player.getPublicDetails();
				this.game.addPlayer(playerCopy);
			}
		}
	}
	
	public Game getGame() {
		return this.game;
	}

}

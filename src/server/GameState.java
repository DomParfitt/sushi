package server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import core.Game;
import core.Player;

/**
 * Object sent by the server to each player containing the current state of the
 * game
 * 
 * @author Dom Parfitt
 *
 */
// TODO: Does this need to be observable?
public class GameState extends Observable implements Serializable {

	private Player recipient;
	private int gameID;
	private List<Player> players;

	public GameState(Player recipient, Game game) {
		this.recipient = recipient;
		this.gameID = game.getGameID();
		this.players = new ArrayList<>();
		for (Player player : game.getPlayers()) {
			if (player.equals(recipient)) {
				players.add(player);
			} else {
				players.add(player.getPublicDetails());
			}
		}
	}

	public Player getRecipient() {
		return this.recipient;
	}

	public int getGameID() {
		return this.gameID;
	}

	public List<Player> getPlayerDetails() {
		return this.players;
	}

	public void update(GameState newState) {
		if (getGameID() == newState.getGameID()) {
			for (Player updatedPlayer : newState.getPlayerDetails()) {
				if (players.contains(updatedPlayer)) {
					players.remove(updatedPlayer);
				}
				players.add(updatedPlayer);
			}
			setChanged();
			notifyObservers();
		}
	}
}

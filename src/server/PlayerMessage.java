package server;

import cards.Card;
import core.Game;
import core.Player;

/**
 * Message sent by a player to the server indicating a particular
 * action they wish to take 
 * @author Dom Parfitt
 *
 */
public class PlayerMessage {
	
	public enum PlayerAction {CREATE_GAME, VIEW_GAMES, JOIN_GAME, PLAY_CARD, LEAVE_GAME};
	
	private PlayerAction action;
	private int numPlayers;
	private GameState game;
	private Player player;
	private Card card;
	
	public PlayerMessage(PlayerAction action, Player player, Card card) {
		this.player = player;
		this.action = action;
		this.card = card;
	}
	
	public PlayerMessage(GameState game, Player player) {
		this.action = PlayerAction.JOIN_GAME;
		this.game = game;
		this.player = player;
	}
	
	public PlayerAction getAction() {
		return this.action;
	}
	
	public int getNumberOfPlayers() {
		return this.numPlayers;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public GameState getGame() {
		return this.game;
	}
	
	public Card getCard() {
		return this.card;
	}
	
	public void performAction() {
		
	}

}

package server;

import cards.Card;
import core.Player;

/**
 * Object sent by a player to the server indicating a particular
 * action they wish to take 
 * @author Dom Parfitt
 *
 */
public class PlayerAction {
	
	public enum PLAYERACTION {PLAYCARD};
	
	private Player player;
	private PLAYERACTION action;
	private Card card;
	
	public PlayerAction(Player player, PLAYERACTION action, Card card) {
		this.player = player;
		this.action = action;
		this.card = card;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Card getCard() {
		return this.card;
	}
	
	public void performAction() {
		
	}

}

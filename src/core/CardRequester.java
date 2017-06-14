package core;

/**
 * Thread to call the requestCard() method and then pass the result
 * into the Game object's played card map
 * @author Dom Parfitt
 *
 */
public class CardRequester extends Thread {

	private Game game;
	private Player player;
	
	/**
	 * Initialises a CardRequester for a particular player and
	 * game
	 * @param game the Game to pass the result to 
	 * @param player the player to request the card from
	 */
	public CardRequester(Game game, Player player) {
		this.game = game;
		this.player = player;
	}
	
	@Override
	public void run() {
		game.addPlayedCard(player, player.requestCard());
	}
}

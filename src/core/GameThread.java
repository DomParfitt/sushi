package core;

/**
 * Thread to run the main game. Allows the starting of the game
 * to run separately from players joining so the game can wait
 * until enough players are available
 * @author Dom Parfitt
 * TODO: Maybe make this a private class of Game
 */
public class GameThread extends Thread {

	private Game game;
	
	/**
	 * Initialise the thread
	 * @param game the Game object
	 */
	public GameThread(Game game) {
		this.game = game;
	}
	
	@Override
	public void run() {
		game.startGame();
	}
	
}

package core;

import java.util.concurrent.Callable;

import server.PlayerAction;

public class PlayerThread implements Callable<PlayerAction> {
	
	private Player player;
	
	public PlayerThread(Player player) {
		this.player = player;
	}
	
	@Override
	public PlayerAction call() throws Exception {
		return player.getActionQueue().dequeue();
	}

	
}

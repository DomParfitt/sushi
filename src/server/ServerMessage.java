package server;

import java.util.List;

/**
 * Class for a message sent from the server to a connected player
 * @author Dom Parfitt
 *
 */
public class ServerMessage {
	
	public enum ServerMessageType {NEW_GAME, AVAILABLE_GAMES, JOIN_SUCCESS, JOIN_FAILURE, UPDATED_GAME, REQUEST_CARD};

	private ServerMessageType type;
	private List<GameState> games;
	private boolean joinSuccessful;
	private GameState gameState;
	
	public ServerMessage(List<GameState> games) {
		this.type = ServerMessageType.AVAILABLE_GAMES;
		this.games = games;
	}
	
	public ServerMessage(ServerMessageType type, GameState gameState) {
		this.type = type;
		this.gameState = gameState;
	}
	
	public ServerMessage(ServerMessageType type) {
		this.type = type;
	}
	
	public ServerMessage(boolean joinSuccessful) {
		this.type = ServerMessageType.JOIN_SUCCESS;
		this.joinSuccessful = joinSuccessful;
	}
	
	public ServerMessageType getMessageType() {
		return this.type;
	}
	
	public List<GameState> getAvailableGames() {
		return this.games;
	}
	
	public boolean wasJoinSuccessful() {
		return this.joinSuccessful;
	}
	
	public GameState getUpdatedGameState() {
		return this.gameState;
	}
}

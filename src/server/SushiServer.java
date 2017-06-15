package server;

import java.util.ArrayList;
import java.util.List;

import core.Game;

public class SushiServer {
	
	private ConnectionHandler connectionHandler;
	private List<ConnectionThread> connections;
	private List<Game> games;
	
	public SushiServer() {
		this.connections = new ArrayList<>();
		this.games = new ArrayList<>();
		connectionHandler = new ConnectionHandler(this);
		connectionHandler.start();
	}
	
	public void addConnection(ConnectionThread connection) {
		connections.add(connection);
		connection.start();
	}
	
	public void createGame(Game game) {
		games.add(game);
	}
	
	public List<Game> getGames() {
		return this.games;
	}
	
}

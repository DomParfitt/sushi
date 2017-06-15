package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import core.Game;
import core.Player;
import server.ServerMessage.ServerMessageType;

public class ConnectionThread extends Thread {

	private SushiServer server;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public ConnectionThread(SushiServer server, Socket socket) {
		this.server = server;
		this.socket = socket;
		connect();

	}

	public void connect() {
		try {
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// TODO: Implement object for protocol
	@Override
	public void run() {
		// while (true) {
		try {

			// TODO: Might need to be threaded so that multiple actions can be
			// queued?

			// Get message from the player
			PlayerMessage playerMessage = (PlayerMessage) in.readObject();
			
			//Initialise some common objects
			Player player = playerMessage.getPlayer();
			ServerMessage response = null; // TODO: Potentially remove this when
											// all actions are implemented
			GameState newState;
			switch (playerMessage.getAction()) {
			case CREATE_GAME:
				// TODO: Will this need another set of threads? (i.e. so
				// multiple games can be hosted at once)

				// Create a new game and add the player to it
				Game game = new Game(playerMessage.getNumberOfPlayers());
				game.addPlayer(player);

				// Add the game to the server's list of games
				server.createGame(game);

				// Create the server's response
				newState = new GameState(player, game);
				response = new ServerMessage(ServerMessageType.NEW_GAME, newState);

				break;
			case VIEW_GAMES:
				//Create a list of available games as GameStates
				List<GameState> games = new ArrayList<>();
				for(Game availableGame : server.getGames()) {
					//TODO: Only add if there are spaces available
					games.add(new GameState(player, availableGame));
				}
				
				//Create a response with the available games
				response = new ServerMessage(games);
				break;
			case JOIN_GAME:
				//Get the ID of the game the player wishes to join
				int gameID = playerMessage.getGame().getGameID();
				
				//Set a default response with failuer to join game
				response = new ServerMessage(ServerMessageType.JOIN_FAILURE);
				
				// Look for the matching game on the server
				for (Game availableGame : server.getGames()) {
					if (availableGame.getGameID() == gameID) {
						if(availableGame.addPlayer(player)) {
							newState = new GameState(player, availableGame);
							response = new ServerMessage(ServerMessageType.JOIN_SUCCESS, newState);
						}
						break;
					}
				}

				break;
			case LEAVE_GAME:
				break;
			case PLAY_CARD:
				break;
			}

			// Send the response to the player
			out.writeObject(response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// }
	}
}

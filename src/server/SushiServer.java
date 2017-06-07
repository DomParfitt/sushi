package server;

import java.util.ArrayList;

public class SushiServer {
	
	private ConnectionHandler connectionHandler;
	private ArrayList<ConnectionThread> connections;
	
	public SushiServer() {
		connectionHandler = new ConnectionHandler(this);
		connectionHandler.start();
	}
	
	public void addConnection(ConnectionThread connection) {
		connections.add(connection);
		connection.start();
	}

}

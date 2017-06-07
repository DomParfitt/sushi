package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Thread to handle all incoming connections to the SushiServer
 * @author Dom Parfitt
 *
 */
public class ConnectionHandler extends Thread  {

	private SushiServer server;
	private ServerSocket serverSocket;
	
	public ConnectionHandler(SushiServer server) {
		this.server = server;
	}
	
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket();
			Socket socket = serverSocket.accept();
			ConnectionThread connection = new ConnectionThread(server, socket);
			server.addConnection(connection);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

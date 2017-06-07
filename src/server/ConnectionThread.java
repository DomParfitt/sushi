package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionThread extends Thread {
	
	private SushiServer server;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public ConnectionThread(SushiServer server, Socket socket) {
		this.server = server;
		this.socket = socket;
		
		try {
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//TODO: Implement object for protocol
	@Override
	public void run() {
//		while (true) {
			try {
				in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}
	}
}

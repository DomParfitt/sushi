package server;

import java.util.ArrayList;

public class ActionQueue {

	private ArrayList<PlayerMessage> queue;
	
	public ActionQueue() {
		this.queue = new ArrayList<PlayerMessage>();
	}
	
	public synchronized void enqueue(PlayerMessage action) {
		this.queue.add(action);
		notifyAll();
	}
	
	public synchronized PlayerMessage dequeue() {
		while(queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		PlayerMessage action = this.queue.remove(0);
		notifyAll();
		return action;
	}
	
}

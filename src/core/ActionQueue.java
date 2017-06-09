package core;

import java.util.ArrayList;

import server.PlayerAction;

public class ActionQueue {

	private ArrayList<PlayerAction> queue;
	
	public ActionQueue() {
		this.queue = new ArrayList<PlayerAction>();
	}
	
	public synchronized void enqueue(PlayerAction action) {
		this.queue.add(action);
		notifyAll();
	}
	
	public synchronized PlayerAction dequeue() {
		while(queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		PlayerAction action = this.queue.remove(0);
		notifyAll();
		return action;
	}
	
}

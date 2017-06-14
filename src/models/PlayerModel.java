package models;

import java.util.Observable;

import cards.Card;
import core.Player;

public class PlayerModel extends Observable {
	
	private Player player;
	private Card playedCard;
	private boolean hasCard;
	
	public PlayerModel(Player player) {
		this.player = player;
		this.hasCard = false;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public synchronized void putCard(Card card) {
		this.playedCard = card;
		this.hasCard = true;
		notifyAll();
		setChanged();
		notifyObservers();
	}
	
	public synchronized Card getCard() {
		setChanged();
		notifyObservers();
		while(!hasCard) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		hasCard = false;
		return playedCard;
	}
	

}

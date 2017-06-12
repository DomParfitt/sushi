package core;

import java.util.Map;

import cards.Card;

public class CardRequester extends Thread {

	private Game game;
	private Player player;
	private Card card;
	private boolean hasCard;
	
	public CardRequester(Game game, Player player) {
		this.game = game;
		this.player = player;
		this.hasCard = false;
	}
	
//	public Card getCard() {
//		while (!hasCard) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		hasCard = false;
//		//Could set card to null here but flag should cover it
//		return card;
//		
//	}
	
	@Override
	public void run() {
		game.addPlayedCard(player, player.requestCard());
//		card = player.requestCard();
//		hasCard = true;
//		notifyAll();
	}
}

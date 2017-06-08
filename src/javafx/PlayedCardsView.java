package javafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import cards.Card;
import core.Player;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import models.GameModel;

public class PlayedCardsView extends HBox implements Observer {
	
	private List<Label> cards;
	private Player player;
	
	public PlayedCardsView(Player player) {
		this.player = player;
		this.cards = new ArrayList<Label>();
	}
	
	public void addCard() {
		
	}

	@Override
	public void update(Observable obs, Object arg1) {
		// TODO Auto-generated method stub
		this.getChildren().clear();
		List<Card> played = ((GameModel) obs).getPlayedCards(player);
		this.cards.clear();
		for (Card card : played) {
			this.cards.add(new Label(card.getName()));
			this.getChildren().add(new Label(card.getName()));
		}
	}


}

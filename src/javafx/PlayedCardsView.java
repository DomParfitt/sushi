package javafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import cards.Card;
import core.Game;
import core.Player;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

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
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				getChildren().clear();
				List<Card> played = ((Game) obs).getPlayedCards(player);
				cards.clear();
				for (Card card : played) {
					cards.add(new Label(card.getName()));
					getChildren().add(new Label(card.getName()));
				}
			}
			
		});
		
	}


}

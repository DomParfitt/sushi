package javafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import cards.Card;
import core.Player;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import models.GameModel;

/**
 * @author Dom Parfitt
 *
 */
public class HandView extends HBox implements Observer {
	
	private List<Button> cards;
	private Player player;
	
	public HandView(Player player) {
		this.player = player;
		this.cards = new ArrayList<Button>();
	}
	
	public void addCard() {
		
	}

	@Override
	public void update(Observable obs, Object arg1) {
		// TODO Auto-generated method stub
		List<Card> hand = ((GameModel) obs).getHand(player);
		this.cards.clear();
		for (Card card : hand) {
			this.cards.add(new Button(card.getName()));
			this.getChildren().add(new Button(card.getName()));
		}
	}

}

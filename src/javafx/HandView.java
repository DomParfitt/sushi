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
	private HandController controller;
	
	public HandView(Player player, HandController controller) {
		this.player = player;
		this.cards = new ArrayList<Button>();
		this.controller = controller;
	}
	
	public void addController(HandController controller) {
		this.controller = controller;
	}
	
	public void addCard() {
		
	}

	@Override
	public void update(Observable obs, Object arg1) {
		// TODO Auto-generated method stub
		List<Card> hand = ((GameModel) obs).getHand(player);
		this.getChildren().clear();
		this.cards.clear();
		for (Card card : hand) {
			Button button = new Button(card.getName());
			controller.addAction(button, player, card);
			this.cards.add(button);
			this.getChildren().add(button);
		}
	}

}

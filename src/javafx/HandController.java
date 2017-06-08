package javafx;

import cards.Card;
import core.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import models.GameModel;

public class HandController {

	private GameModel model;
	
	public HandController(GameModel model) {
		this.model = model;
	}
	
	public void addAction(Button button, Player player, Card card) {
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				model.playCard(player, card);
			}
			
		});
	}
}

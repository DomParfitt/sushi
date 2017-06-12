package javafx;

import cards.Card;
import core.Game;
import core.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import models.GameModel;

public class HandController {

	private Game model;
	
	public HandController(Game gameModel) {
		this.model = gameModel;
	}
	
	public void addAction(Button button, Player player, Card card) {
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
//				model.playCard(player, card);
			}
			
		});
	}
}

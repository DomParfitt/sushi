package javafx;

import cards.Card;
import core.Player;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Pane to sit within the BoardView. Consists of a label
 * indicating the player and an image/label showing the 
 * played cards
 * @author Dom Parfitt
 *
 */
public class PlayerPane extends VBox {
	
	private Player player;
	private HBox cards;
	
	public PlayerPane(Player player) {
		this.player = player;
		this.getChildren().add(new Label(player.toString()));
		cards = new HBox();
		cards.getStyleClass().add("card-pane");
		this.getChildren().add(cards);
	}
	
	public void addPlayedCard(Card card) {
//		Button button = new Button(card.getName());
////		button.getStyleClass().clear();
//		button.getStyleClass().add("card-button");
//		button.getStyleClass().add(card.getType().toString().toLowerCase());
		CardButton button = new CardButton(card);
		button.setDisable(true);
		cards.getChildren().add(button);
//		cards.getChildren().add(new Label(card.getName()));
	}
}

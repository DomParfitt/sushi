package javafx;

import java.util.List;

import cards.Card;
import core.Player;
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
	private int handSize;
	
	public PlayerPane(Player player, int handSize) {
		this.player = player;
		this.handSize = handSize;
		this.getChildren().add(new Label(player.toString()));
		cards = new HBox();
		cards.setPrefWidth(handSize*60);
		cards.getStyleClass().add("small-card-pane");
		this.getChildren().add(cards);
	}
	
	public void addPlayedCard(Card card) {
		CardButton button = new CardButton(card);
		addCardButton(button);
	}
	
	private void addEmptyCardSpace() {
		CardButton space = new CardButton();
		addCardButton(space);
	}
	
	private void addCardButton(CardButton cardButton) {
		cardButton.getStyleClass().add("small-card");
		cardButton.setDisable(true);
		cards.getChildren().add(cardButton);
	}
	
	public void addPlayedCards(List<Card> cards) {
		for(Card card : cards) {
			addPlayedCard(card);
		}
		
		for(int i = 0; i < handSize - cards.size(); i++) {
			addEmptyCardSpace();
		}
	}
}

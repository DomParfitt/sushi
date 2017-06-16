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
		//Create elements of the pane
		this.player = player;
		this.handSize = handSize;
		this.cards = new HBox();
		HBox title = new HBox();
		
		//Add the elements to the pane
		title.getChildren().add(new Label(player.toString()));
		title.getChildren().add(new Label("\tScore: " + player.getScore().getNumScore()));
		title.getChildren().add(new Label("\tPuddings: " + player.getScore().getPuddingCount()));
		
		this.getChildren().add(title);
//		this.getChildren().add(new Label(player.toString()));
		this.getChildren().add(cards);
		
		//Set the styling
		this.getStyleClass().add("player-pane");
		this.cards.getStyleClass().add("small-card-pane");
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

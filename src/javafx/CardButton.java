package javafx;

import cards.Card;
import javafx.scene.control.Button;

public class CardButton extends Button {
	
	public CardButton() {
		setText("CARD BACK");
		getStyleClass().add("card-button");
	}
	
	public CardButton(Card card) {
		if (card.getName() == "Maki Roll" || card.getName() == "Nigiri") {
			setText(card.getName() + " (" + card.getValue() + ")");
		} else {
			setText(card.getName());
		}
		getStyleClass().add("card-button");
		getStyleClass().add(card.getType().toString().toLowerCase());
	}
}

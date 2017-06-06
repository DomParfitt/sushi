package javafx;

import javafx.scene.layout.HBox;

public class HandComponent extends HBox {

//	private ArrayList<CardButton> cardButtons;
	
	public HandComponent() {
//		this.setPrefSize(500, 300);
//		this.cardButtons = new ArrayList<CardButton>();
	}
	
	public void addCardButton(CardButton cardButton) {
//		this.cardButtons.add(cardButton);
		this.getChildren().add(cardButton);
	}
	
}

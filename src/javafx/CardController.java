package javafx;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CardController implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent e) {

		CardButton cardButton = (CardButton) e.getSource();
		double height = cardButton.getPrefHeight();
		double width = cardButton.getPrefWidth();
		
		if (e.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
			cardButton.setPrefSize(width * 2, height * 2);
			
		} else if (e.getEventType().equals(MouseEvent.MOUSE_EXITED)) {
			cardButton.setPrefSize(width / 2, height / 2);
		}
	}

}

package javafx;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class CardButton extends Button {
	
	private static Image BACK;
	private Image front;
	
	public CardButton() {
		this.setPrefSize(125, 200);
		this.setText("This is a JFX Button");
	}

}

package javafx;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class CardButton extends Button {
	
	private static Image BACK;
	private Image front;
	private boolean isShowing;
	
	public CardButton() {
		this.isShowing = true;
		this.setPrefSize(125, 200);
		this.setText("FRONT");
	}
	
	public boolean isShowing() {
		return this.isShowing;
	}
	
	public void setShowing() {
		this.isShowing = !this.isShowing();
	}

}

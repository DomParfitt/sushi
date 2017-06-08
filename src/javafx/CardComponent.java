package javafx;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class CardComponent extends StackPane {

	public CardComponent() {
		this.getChildren().add(new Button());
//		this.getChildren().add(new ImageView(new Image("tempura.jpg")));
		this.getChildren().add(new Label("SEPARATE LABEL"));
	}
	
}

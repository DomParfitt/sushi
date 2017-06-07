package javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class NewPlayerPane extends GridPane {

	public NewPlayerPane(GameApp app) {
		add(new Label("Name"),0,0);
		add(new TextField(),1,0);
		
		Button button = new Button("Join Game");
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				app.showHandView();
			}
			
		});
		add(button,0,2);
	}
	
}

package javafx;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class NewPlayerPane extends GridPane {
	
	private GameApp app;
	private TextField nameField;

	public NewPlayerPane(GameApp app) {
		this.app = app;
		nameField = new TextField();
		add(new Label("Player Name"),0,0);
		add(nameField,1,0);
		
//		Button button = new Button("Join Game");
//		button.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent e) {
//				app.showHandView();
////				app.play();
//			}
//			
//		});
//		add(button,0,2);
	}
	
	public String getPlayerName() {
		return nameField.getText();
	}
	
}

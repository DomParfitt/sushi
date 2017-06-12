package javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainMenuView extends VBox {

	public MainMenuView(GameApp app) {
		getChildren().add(new Label("Sushi Go"));
		
		Button single = new Button("Single Player Game");
		single.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				SinglePlayerSetUpView singleView = new SinglePlayerSetUpView(app);
				Scene scene = new Scene(singleView);
				app.setScene(scene);
				
			}
		});
		
		Button multi = new Button("Multi-Player Game");
		multi.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		getChildren().add(single);
		getChildren().add(multi);
	}
	
}

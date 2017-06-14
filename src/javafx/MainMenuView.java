package javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainMenuView extends VBox {

	public MainMenuView(GameApp app) {
		getStyleClass().clear();
		getStyleClass().add("pane");
		getStyleClass().add("main-menu-view");
		
		Label title = new Label("Sushi Go");
		title.getStyleClass().clear();
		title.getStyleClass().add("title-label");
		getChildren().add(title);
		
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
				// TODO: Create multiplayer setup views
				
			}
		});
		getChildren().add(single);
		getChildren().add(multi);
	}
	
}

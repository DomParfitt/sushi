package javafx;
import core.Game;
import core.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.GameModel;

public class GameApp extends Application {

	public Stage stage;
	public HandView handView;
	public NewPlayerPane newPlayerView;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;
		
		stage.setTitle("Hand");
		
		Player dom = new Player("Dom");
		
		//Create views
//		newPlayerView = new NewPlayerPane(this);
		StartView startView = new StartView(this);
		handView = new HandView(dom);
		
		//Create model
		GameModel gameModel = new GameModel();
		gameModel.addPlayer(dom);
		gameModel.addObserver(handView);
		gameModel.deal();

//		Scene handScene = new Scene(handView);
		
		Scene newPlayerScene = new Scene(startView);
		newPlayerScene.getStylesheets().add(javafx.GameApp.class.getResource("stylesheet.css").toExternalForm());
		stage.setScene(newPlayerScene);
		
		stage.show();
		
	}

	public void showHandView() {
		stage.setScene(new Scene(handView));
	}
	
}

package javafx;
import core.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.GameModel;

public class GameApp extends Application {

	public Stage stage;
	public HandView handView;
	public PlayedCardsView playedCardsView;
	public NewPlayerPane newPlayerView;
	public GameModel gameModel;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;
		
		stage.setTitle("Hand");
		
		Player dom = new Player("Dom");
		
		//Create model
		gameModel = new GameModel(1);
		gameModel.addPlayer(dom);
		
		//Create views
//		newPlayerView = new NewPlayerPane(this);
		StartView startView = new StartView(this);
		handView = new HandView(dom, new HandController(gameModel));
		
		playedCardsView = new PlayedCardsView(dom);
		
		//Add Observers to model
		gameModel.addObserver(handView);
		gameModel.addObserver(playedCardsView);
		gameModel.deal();

		//Add Controllers
//		handView.addController(new HandController(gameModel));
		
//		Scene handScene = new Scene(handView);
		
		Scene newPlayerScene = new Scene(startView);
		newPlayerScene.getStylesheets().add(javafx.GameApp.class.getResource("stylesheet.css").toExternalForm());
//		stage.setScene(newPlayerScene);
		showHandView();
		
		stage.show();
		
	}

	public void showHandView() {
		VBox vbox = new VBox();
		vbox.getChildren().add(playedCardsView);
		vbox.getChildren().add(handView);
		stage.setScene(new Scene(vbox));
	}
	
	public void play() {
		gameModel.play();
	}
	
}

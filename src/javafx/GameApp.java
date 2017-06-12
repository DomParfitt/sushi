package javafx;
import core.Game;
import core.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameApp extends Application {

	public Stage stage;
	
	public MainMenuView mainMenuView;
	public SinglePlayerSetUpView singlePlayerSetupView;
	public GameView gameView;
	
	public HandView handView;
	public PlayedCardsView playedCardsView;
	public NewPlayerPane newPlayerView;
	private BoardView boardView;
	public Game game;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;
		
		stage.setTitle("Sushi Go");
		
		mainMenuView = new MainMenuView(this);
		singlePlayerSetupView = new SinglePlayerSetUpView(this);
		
//		Player dom = new Player("Dom");
		
		//Create model
//		game = new Game(2);
//	
//		game.addPlayer(dom);
//		game.addPlayer(new RandomAIPlayer("CPU"));
		
		//Create views
//		newPlayerView = new NewPlayerPane(this);
//		StartView startView = new StartView(this);
//		handView = new HandView(dom, new HandController(game));
//		boardView = new BoardView();
		
//		playedCardsView = new PlayedCardsView(dom);
		
		//Add Observers to model - THIS NEEDS TO BE DONE BEFORE THE GAME IS STARTED
//		game.addObserver(handView);
//		dom.addObserver(handView);
//		game.addObserver(playedCardsView);
//		game.addObserver(boardView);
		
//		game.start();
//		gameModel.deal();

		//Add Controllers
//		handView.addController(new HandController(gameModel));
		
//		Scene handScene = new Scene(handView);
		
//		Scene newPlayerScene = new Scene(boardView);
//		newPlayerScene.getStylesheets().add(javafx.GameApp.class.getResource("stylesheet.css").toExternalForm());
//		stage.setScene(newPlayerScene);
//		showHandView();
		
		stage.setScene(new Scene(mainMenuView));
		stage.show();
		
	}
	
	/**
	 * Method to change the scene (view)
	 * @param scene the scene to show
	 */
	public void setScene(Scene scene) {
		stage.setScene(scene);
	}
	

	public Game getGame() {
		return this.game;
	}
	
	public void setGame(Game game) {
		this.game = game;
		this.game.addObserver(gameView.getHandView());
//		game.addObserver(playedCardsView);
		this.game.addObserver(gameView.getBoardView());
		this.game.addObserver(gameView.getScorePane());
	}
	
	public MainMenuView getMainMenuView() {
		return mainMenuView;
	}

	public void setMainMenuView(MainMenuView mainMenuView) {
		this.mainMenuView = mainMenuView;
	}

	public SinglePlayerSetUpView getSinglePlayerSetupView() {
		return singlePlayerSetupView;
	}

	public void setSinglePlayerSetupView(SinglePlayerSetUpView singlePlayerSetupView) {
		this.singlePlayerSetupView = singlePlayerSetupView;
	}

	public GameView getGameView() {
		return gameView;
	}

	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}
	
	public void setHandView(Player player) {
		handView = new HandView(player);
	}

	public void showHandView() {
		VBox vbox = new VBox();
		vbox.getChildren().add(boardView);
		vbox.getChildren().add(handView);
		stage.setScene(new Scene(vbox));
	}
	
	public void play() {
		game.play();
	}
	
}

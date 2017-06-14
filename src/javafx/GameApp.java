package javafx;
import core.Game;
import core.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Main "runner" class for the JavaFX GUI
 * @author Dom Parfitt
 *
 */
public class GameApp extends Application {
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;

	private Stage stage;
	
	private MainMenuView mainMenuView;
	private SinglePlayerSetUpView singlePlayerSetupView;
	private GameView gameView;
	
	private HandPane handView;
	private PlayedCardsView playedCardsView;
	private NewPlayerPane newPlayerView;
	private BoardPane boardView;
	private Game game;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;
		stage.setWidth(WIDTH);
		stage.setHeight(HEIGHT);
		
		stage.setTitle("Sushi Go");
		
		mainMenuView = new MainMenuView(this);
		singlePlayerSetupView = new SinglePlayerSetUpView(this);
		
		setScene(new Scene(mainMenuView));
		
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				Platform.exit();
				System.exit(0);
			}
			
		});
		
		stage.show();
		
	}
	
	/**
	 * Method to change the scene (view)
	 * @param scene the scene to show
	 */
	public void setScene(Scene scene) {
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		stage.setScene(scene);
	}
	

	public Game getGame() {
		return this.game;
	}
	
	public void setGame(Game game) {
		this.game = game;
		this.game.addObserver(gameView.getHandPane());
//		game.addObserver(playedCardsView);
		this.game.addObserver(gameView.getBoardPane());
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
		handView = new HandPane(player);
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

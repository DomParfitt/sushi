package javafx;

import core.Game;
import core.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * View for setting up a single player game
 * @author Dom Parfitt
 *
 */
public class SinglePlayerSetUpView extends VBox {

	private GameApp app;
	private NewPlayerPane newPlayerPane;
	private GameConfigPane gameConfigPane;
	private AISetupPane aiSetupPane;
	private Button startButton;

	public SinglePlayerSetUpView(GameApp app) {
		this.app = app;
		
		getStyleClass().clear();
		getStyleClass().add("single-player-setup-view");
		newPlayerPane = new NewPlayerPane(app);
		gameConfigPane = new GameConfigPane(app);
		aiSetupPane = new AISetupPane(app);
		startButton = new Button("Start Game");

		// TODO: Move to separate controller
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String playerName = newPlayerPane.getPlayerName();
				if (playerName.equals("")) {
					//TODO: Make sure closing alert works
					Alert alert = new Alert(AlertType.NONE);
					alert.setContentText("Please enter a name");
					alert.show();
				} else {
					// TODO: This seems unclean
					Player player = new Player(playerName);
					int numAI = aiSetupPane.getAINumber();
					GameView gameView = new GameView(app, player);
					app.setGameView(gameView);
					player.addObserver(gameView.getHandPane());
					// app.setHandView(player);
					Game game = new Game(numAI + 1);
					game.setHandSize(gameConfigPane.getHandSize());
					game.setNumberOfRounds(gameConfigPane.getNumberOfRounds());
					app.setGame(game);
					game.start();
					game.addPlayer(player);
					
					for(AIDetailsPane ai : aiSetupPane.getAIs()) {
						game.addPlayer(ai.getAIPlayerObject());
					}
					app.setScene(new Scene(gameView, 200, 200));

				}

			}
		});

		// Add elements
		getChildren().add(newPlayerPane);
		getChildren().add(gameConfigPane);
		getChildren().add(aiSetupPane);
		getChildren().add(startButton);
	}

}

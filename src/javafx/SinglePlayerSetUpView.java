package javafx;

import ai.RandomAIPlayer;
import core.Game;
import core.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SinglePlayerSetUpView extends VBox {

	private GameApp app;
	private NewPlayerPane newPlayerPane;
	private AISetupPane aiSetupPane;
	private Button startButton;

	public SinglePlayerSetUpView(GameApp app) {
		this.app = app;
		newPlayerPane = new NewPlayerPane(app);
		aiSetupPane = new AISetupPane(app);
		startButton = new Button("Start Game");

		// TODO: Move to separate controller
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String playerName = newPlayerPane.getPlayerName();
				if (playerName == "") {
					// show an error window
				} else {
					// TODO: This seems unclean
					Player player = new Player(playerName);
					int numAI = aiSetupPane.getAINumber();
					GameView gameView = new GameView(app, player);
					app.setGameView(gameView);
					player.addObserver(gameView.getHandView());
					// app.setHandView(player);
					Game game = new Game(numAI + 1);
					app.setGame(game);
					game.start();
					game.addPlayer(player);
					for (int i = 1; i <= numAI; i++) {
						game.addPlayer(new RandomAIPlayer("CPU" + i));
					}
					app.setScene(new Scene(gameView, 200, 200));

				}

			}
		});

		// Add elements
		getChildren().add(newPlayerPane);
		getChildren().add(aiSetupPane);
		getChildren().add(startButton);
	}

}

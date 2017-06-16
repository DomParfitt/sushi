package javafx;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import cards.Card;
import core.Game;
import core.Player;
import javafx.application.Platform;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * View to show the "board" consisting of each player and the cards they have
 * played
 * 
 * @author Dom Parfitt
 *
 */
public class BoardPane extends ScrollPane implements Observer {
	
	private VBox vBox;
	private GridPane gridPane;
	private GameApp app;
	
	public BoardPane(GameApp app) {
		this.app = app;
		vBox = new VBox();
		gridPane = new GridPane();
//		gridPane.setHgap(30);
		setContent(gridPane);
//		setContent(vBox);
	}

	@Override
	public void update(Observable obs, Object obj) {
//		System.out.println("BoardView update called");

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
//				System.out.println("Updating BoardView");
//				vBox.getChildren().clear();
				gridPane.getChildren().clear();
				
				Game game = (Game) obs;
				List<Player> players = game.getPlayers();
				int playerCount = 0;
				for (Player player : players) {
					PlayerPane playerPane = new PlayerPane(player, app.getGame().getHandSize());
					playerPane.addPlayedCards(player.getPlayedCards());
//					vBox.getChildren().add(playerPane);
					gridPane.add(playerPane, playerCount % 2, playerCount / 2);
					playerCount++;
				}
			}

		});

	}

}

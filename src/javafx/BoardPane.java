package javafx;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import cards.Card;
import core.Game;
import core.Player;
import javafx.application.Platform;
import javafx.scene.control.ScrollPane;
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
	
	public BoardPane() {
		vBox = new VBox();
		setContent(vBox);
	}

	@Override
	public void update(Observable obs, Object obj) {
//		System.out.println("BoardView update called");

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
//				System.out.println("Updating BoardView");
				vBox.getChildren().clear();
				Game game = (Game) obs;
				List<Player> players = game.getPlayers();
				for (Player player : players) {
					PlayerPane playerPane = new PlayerPane(player);
					for (Card card : player.getPlayedCards()) {
						playerPane.addPlayedCard(card);
					}
					vBox.getChildren().add(playerPane);
				}
			}

		});

	}

}

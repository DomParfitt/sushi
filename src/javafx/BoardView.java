package javafx;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import cards.Card;
import core.Game;
import core.Player;
import javafx.application.Platform;
import javafx.scene.layout.VBox;

/**
 * View to show the "board" consisting of each player and the cards they have
 * played
 * 
 * @author Dom Parfitt
 *
 */
public class BoardView extends VBox implements Observer {

	public BoardView() {

	}

	@Override
	public void update(Observable obs, Object obj) {
//		System.out.println("BoardView update called");

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
//				System.out.println("Updating BoardView");
				getChildren().clear();
				Game game = (Game) obs;
				List<Player> players = game.getPlayers();
				for (Player player : players) {
					PlayerPane playerPane = new PlayerPane(player);
					for (Card card : player.getPlayedCards()) {
						playerPane.addPlayedCard(card);
					}
					getChildren().add(playerPane);
				}
			}

		});

	}

}

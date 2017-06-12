package javafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import core.Game;
import core.Player;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ScorePane extends GridPane implements Observer {
	
	public ScorePane() {
//		HBox headers = new HBox();
//		headers.getChildren().add(new Label("Player"));
//		headers.getChildren().add(new Label("Numeric Score"));
//		headers.getChildren().add(new Label("Pudding Count"));
		getStyleClass().clear();
		getStyleClass().add("score-pane");
		addHeadings();
//		getChildren().add(headers);
	}
	
	private void addHeadings() {
		ArrayList<Label> headings = new ArrayList<>();
		headings.add(new Label("Player"));
		headings.add(new Label("Numeric Score"));
		headings.add(new Label("Pudding Count"));
		int count = 0;
		for(Label heading : headings) {
			heading.getStyleClass().clear();
			heading.getStyleClass().add("heading-label");
			add(heading, count, 0);
			count++;
		}
	}

	@Override
	public void update(Observable obs, Object obj) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Game game = (Game) obs;
//				System.out.println("Updating BoardView");
				getChildren().clear();
//				HBox headers = new HBox();
//				headers.getChildren().add(new Label("Player"));
//				headers.getChildren().add(new Label("Numeric Score"));
//				headers.getChildren().add(new Label("Pudding Count"));
//				getChildren().add(headers);
				addHeadings();
				List<Player> players = game.getPlayers();
				int row = 1;
				for (Player player : players) {
					add(new Label(player.getName()), 0, row);
					add(new Label(Integer.toString(player.getScore().getNumScore())), 1, row);
					add(new Label(Integer.toString(player.getScore().getPuddingCount())), 2, row);
					row++;
//					ScoreEntry scoreEntry = new ScoreEntry(player);
//					getChildren().add(scoreEntry);
				}
			}

		});

		
	}
}

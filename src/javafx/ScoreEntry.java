package javafx;

import core.Player;
import core.Score;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ScoreEntry extends GridPane {
	
	private Player player;
	
	public ScoreEntry(Player player) {
		this.player = player;
		Score score = player.getScore();
		add(new Label(player.toString()), 0, 0);
		add(new Label(Integer.toString(score.getNumScore())), 1, 0);
		add(new Label(Integer.toString(score.getPuddingCount())), 2, 0);
	}

}

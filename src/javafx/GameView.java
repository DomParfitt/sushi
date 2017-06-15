package javafx;

import core.Player;
import javafx.scene.layout.VBox;

/**
 * Main game view. Consists of a pane representing the board
 * with each player and their played cards, a pane representing
 * the player's hand and a score pane.
 * @author Dom Parfitt
 *
 */
//TODO: Fix issue with sizing of board and hand panes
public class GameView extends VBox {

	private GameApp app;
	private BoardPane boardPane;
	private HandPane handPane;
	private ScorePane scorePane;
	
	public GameView(GameApp app, Player player) {
		this.app = app;
		boardPane = new BoardPane();
		handPane = new HandPane(player);
		scorePane = new ScorePane();
		getChildren().add(boardPane);
		getChildren().add(handPane);
//		getChildren().add(scorePane);
	}
	
	public BoardPane getBoardPane() {
		return this.boardPane;
	}
	
	public HandPane getHandPane() {
		return this.handPane;
	}
	
	public ScorePane getScorePane() {
		return this.scorePane;
	}
}

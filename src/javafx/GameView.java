package javafx;

import core.Player;
import javafx.scene.layout.VBox;

public class GameView extends VBox {

	private GameApp app;
	private BoardView boardView;
	private HandView handView;
	private ScorePane scorePane;
	
	public GameView(GameApp app, Player player) {
		this.app = app;
		boardView = new BoardView();
		handView = new HandView(player);
		scorePane = new ScorePane();
		getChildren().add(boardView);
		getChildren().add(handView);
		getChildren().add(scorePane);
	}
	
	public BoardView getBoardView() {
		return this.boardView;
	}
	
	public HandView getHandView() {
		return this.handView;
	}
	
	public ScorePane getScorePane() {
		return this.scorePane;
	}
}

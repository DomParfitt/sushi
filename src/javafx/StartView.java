package javafx;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class StartView extends GridPane {
	
	private NewPlayerPane newPlayerPane;
	
	public StartView(GameApp app) {
		this.getStyleClass().clear();
		this.getStyleClass().add("start-view");
		this.newPlayerPane = new NewPlayerPane(app);
		render();
	}

	private void render() {
		add(new Label("SUSHI GO"), 0, 0, 3, 1);
		add(newPlayerPane,1,1);
	}

}

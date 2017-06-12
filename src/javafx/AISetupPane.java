package javafx;

import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;

public class AISetupPane extends HBox {

	private GameApp app;
	private Spinner<Integer> spinner;
	
	public AISetupPane(GameApp app) {
		this.app = app;
		spinner = new Spinner<Integer>();
		spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4));
		getChildren().add(new Label("Number of AI Players"));
		getChildren().add(spinner);
	}
	
	public int getAINumber() {
		return spinner.getValue();
	}
}

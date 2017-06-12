package javafx;

import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;

public class GameConfigPane extends GridPane {
	
	private GameApp app;
	private Spinner<Integer> handSize, roundNumber;
	
	public GameConfigPane(GameApp app) {
		this.app = app;
		
		getStyleClass().clear();
		getStyleClass().add("pane");
		
		//Create hand size spinner
		handSize = new Spinner<>();
		handSize.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 10));
		handSize.getValueFactory().setValue(9);
		
		//Create round number spinner
		roundNumber = new Spinner<>();
		roundNumber.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4));
		roundNumber.getValueFactory().setValue(3);
		
		//Add elements
		add(new Label("Hand Size"), 0, 0);
		add(handSize, 1, 0);
		
		add(new Label("Number of Rounds"), 0, 1);
		add(roundNumber, 1, 1);
	}
	
	public int getHandSize() {
		return handSize.getValue();
	}
	
	public int getNumberOfRounds() {
		return roundNumber.getValue();
	}

}

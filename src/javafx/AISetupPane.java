package javafx;

import java.util.ArrayList;
import java.util.List;

import ai.AIPlayer;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;

public class AISetupPane extends GridPane {

	private GameApp app;
	private Spinner<Integer> spinner;
	private Button button;
	private List<AIDetailsPane> ais;
	
	public AISetupPane(GameApp app) {
		this.app = app;
		this.ais = new ArrayList<>();
		
		spinner = new Spinner<Integer>();
		spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4));
		
		
		button = new Button("Add AI");
		button.setOnAction(event -> addAI(button));
//		button.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				addAI(button);
//				
//			}
//		});
		
		//Add elements
		add(button, 0, 0);
//		getChildren().add(new Label("Number of AI Players"));
//		getChildren().add(spinner);
	}
	
	private void addAI(Button button) {
		AIDetailsPane aiDetails = new AIDetailsPane("CPU" + (ais.size() + 1));
		ais.add(aiDetails);
		add(aiDetails, 0, ais.size());
		if(ais.size() >= 4) {
			button.setDisable(true);
		}
	}
	
	public int getAINumber() {
		return ais.size();
//		return spinner.getValue();
	}
	
	public List<AIDetailsPane> getAIs() {
		return this.ais;
	}
}

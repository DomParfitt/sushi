package javafx;

import ai.AIPlayer;
import ai.MakiAI;
import ai.RandomAIPlayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class AIDetailsPane extends HBox {
	
	private String name;
	private ComboBox<String> typeBox;
	private Button removeButton;
	
	public AIDetailsPane(AISetupPane root, String name) {
		this.name = name;
		ObservableList<String> options = FXCollections.observableArrayList("Random", "Maki");
		
		this.typeBox = new ComboBox<>(options);
		typeBox.getSelectionModel().selectFirst();
		
		removeButton = new Button("Remove");
		removeButton.setOnAction(event -> root.removeAI(this));
		
		getChildren().add(new Label(name));
		getChildren().add(typeBox);
		getChildren().add(removeButton);
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAIType() {
		return typeBox.getValue();
	}
	
	public AIPlayer getAIPlayerObject() {
		switch (typeBox.getValue()) {
		case "Random":
			return new RandomAIPlayer(name);
		case "Maki":
			return new MakiAI(name);
		default:
			return new RandomAIPlayer(name);
		}
	}
	
}

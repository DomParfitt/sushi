package javafx;

import ai.AIPlayer;
import ai.MakiAI;
import ai.RandomAIPlayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class AIDetailsPane extends HBox {
	
	private String name;
	private ComboBox<Class<? extends AIPlayer>> typeBox;
	
	public AIDetailsPane(String name) {
		this.name = name;
		ObservableList<Class<? extends AIPlayer>> options = FXCollections.observableArrayList(RandomAIPlayer.class, MakiAI.class);
		
		this.typeBox = new ComboBox<>(options);
		
		getChildren().add(new Label(name));
		getChildren().add(typeBox);
	}
	
	public String getName() {
		return this.name;
	}
	
	public Class<? extends AIPlayer> getAIType() {
		return typeBox.getValue();
	}
}

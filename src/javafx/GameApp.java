package javafx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("Hello");
		
		CardController eventHandler = new CardController();

		CardButton card = new CardButton();
		card.setOnMouseEntered(eventHandler);
		card.setOnMouseExited(eventHandler);

		CardButton card2 = new CardButton();
		card2.setOnMouseEntered(eventHandler);
		card2.setOnMouseExited(eventHandler);
		
		HBox root = new HBox();
		root.getChildren().add(card);
		root.getChildren().add(card2);
		
		stage.setScene(new Scene(root, 500, 500));
		
		stage.show();
	}

}

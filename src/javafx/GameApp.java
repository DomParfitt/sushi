package javafx;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
		
		HandComponent handComp = new HandComponent();
		
		for(int i = 0; i < 5; i++) {
			CardButton card = new CardButton();
			card.setOnMouseEntered(eventHandler);
			card.setOnMouseExited(eventHandler);
			card.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					CardButton c = (CardButton) e.getSource();
					if(c.isShowing()) {
						c.setText("BACK");
					} else {
						c.setText("FRONT");
					}
					c.setShowing();
				}
				
			});
			
			handComp.addCardButton(card);
		}
		
		BorderPane root = new BorderPane();
		root.setBottom(handComp);
		
//		CardButton card = new CardButton();
//		card.setOnMouseEntered(eventHandler);
//		card.setOnMouseExited(eventHandler);
//		card.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent e) {
//				CardButton c = (CardButton) e.getSource();
//				if(c.isShowing()) {
//					c.setText("BACK");
//				} else {
//					c.setText("FRONT");
//				}
//				c.setShowing();
//			}
//			
//		});
//
//		CardButton card2 = new CardButton();
//		card2.setOnMouseEntered(eventHandler);
//		card2.setOnMouseExited(eventHandler);
//		card2.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent e) {
//				CardButton c = (CardButton) e.getSource();
//				if(c.isShowing()) {
//					c.setText("BACK");
//				} else {
//					c.setText("FRONT");
//				}
//				c.setShowing();
//			}
//			
//		});
//		
//		HBox root = new HBox();
//		root.getChildren().add(card);
//		root.getChildren().add(card2);
		

		
		Scene scene = new Scene(root, 500, 500);
		scene.getStylesheets().add(javafx.GameApp.class.getResource("stylesheet.css").toExternalForm());
		
		stage.setScene(scene);
		
		stage.show();
	}

}

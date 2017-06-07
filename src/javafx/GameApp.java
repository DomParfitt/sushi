package javafx;
import core.Game;
import core.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.GameModel;

public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("Hand");
		
//		Game game = new Game();

		Player dom = new Player("Dom");
		
		HandView handView = new HandView(dom);
		
		GameModel gameModel = new GameModel();
		gameModel.addPlayer(dom);
		
		gameModel.addObserver(handView);
		
		gameModel.deal();
		Scene scene = new Scene(handView);
		
//		CardController eventHandler = new CardController();
//		
//		HandComponent handComp = new HandComponent();
//		
//		for(int i = 0; i < 5; i++) {
//			CardButton card = new CardButton();
//			card.setOnMouseEntered(eventHandler);
//			card.setOnMouseExited(eventHandler);
//			card.setOnAction(new EventHandler<ActionEvent>() {
//
//				@Override
//				public void handle(ActionEvent e) {
//					CardButton c = (CardButton) e.getSource();
//					if(c.isShowing()) {
//						c.setText("BACK");
//					} else {
//						c.setText("FRONT");
//					}
//					c.setShowing();
//				}
//				
//			});
//			
//			handComp.addCardButton(card);
//		}
//		
//		BorderPane root = new BorderPane();
//		root.setBottom(handComp);
//		
//		Scene scene = new Scene(root, 500, 500);
//		scene.getStylesheets().add(javafx.GameApp.class.getResource("stylesheet.css").toExternalForm());
		
		stage.setScene(scene);
		
		stage.show();
		
	}

}

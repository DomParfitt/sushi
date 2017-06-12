package javafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import cards.Card;
import core.Game;
import core.Player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * @author Dom Parfitt
 *
 */
public class HandPane extends HBox implements Observer {

	private List<Button> cards;
	private Player player;
	private HandController controller;

	public HandPane(Player player) {
		this.player = player;
		this.cards = new ArrayList<Button>();
		
		getStyleClass().clear();
		getStyleClass().add("pane");
		getStyleClass().add("hand-pane");
		// this.controller = controller;
	}

	public void addController(HandController controller) {
		this.controller = controller;
	}

	public void addCard() {

	}

	@Override
	public void update(Observable obs, Object arg1) {
//		System.out.println("HandView update called");

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
//				System.out.println("Updating HandView");
				if (obs.getClass().equals(Game.class)) {
//					System.out.println("Update from Game");
					// TODO Auto-generated method stub
					List<Card> hand = ((Game) obs).getHand(player);
					getChildren().clear();
					cards.clear();
					for (Card card : hand) {
						Button button;
						if(card.getName() == "Maki Roll") {
							button = new Button(card.getName() + " (" + card.getValue() + ")");
						} else {
							button = new Button(card.getName());
						}
						button.getStyleClass().add("card-button");
						button.getStyleClass().add(card.getType().toString().toLowerCase());
						button.setDisable(true);
						// controller.addAction(button, player, card);
						button.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent arg0) {
								player.play(card);

							}

						});
						cards.add(button);
						getChildren().add(button);
					}
				} else {
//					System.out.println("Update from Player");
					for (Node node : getChildren()) {
						Button button = (Button) node;
						button.setDisable(false);
					}
				}

			}

		});

	}

}

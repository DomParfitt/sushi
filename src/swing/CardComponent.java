package swing;
import javax.swing.JButton;

public class CardComponent extends JButton {

	public CardComponent() {
		this.setText("This is a card");
	}
	
	public void addController(CardController controller) {
		this.addMouseListener(controller);
	}
	
}

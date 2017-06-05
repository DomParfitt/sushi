package swing;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameView {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		
		JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setBackground(Color.RED);
//		panel.setLayout(new GridLayout());

		CardComponent card = new CardComponent();
		CardComponent card2 = new CardComponent();
		
		CardController controller = new CardController();
		
		card.addController(controller);
		card2.addController(controller);
		
		panel.add(card);
		panel.add(card2);
		
		frame.add(panel);
		
		
	}
		
}

package swing;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CardController implements MouseListener {
	
//	private CardComponent cardComponent;
	
	public CardController() {
//		this.cardComponent = cardComponent;
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		Component comp = arg0.getComponent();
		comp.setSize(200, 200);
//		this.cardComponent.setSize(200, 200);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		Component comp = arg0.getComponent();
		comp.setSize(100, 100);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}

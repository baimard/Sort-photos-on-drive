package juxo.UiTriePhotoV2;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UiQuestionActionListener implements MouseListener {
	
	private UiQuestion monUi;

	public UiQuestionActionListener(UiQuestion u){
		monUi = u;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 2)
			monUi.setVisible(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

package juxo.UiTriePhotoV2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UiQuestionActionListener implements ActionListener {
	
	private UiQuestion monUi;

	public UiQuestionActionListener(UiQuestion u){
		monUi = u;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 
		monUi.setVisible(false);
		
	}

}

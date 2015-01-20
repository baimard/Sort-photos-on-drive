package juxo;

import java.awt.AWTException;
import java.io.IOException;

import juxo.UiTriePhotoV2.UiUser;
import juxo.notification.AfficherNotification;

public class App 
{
	public static void main( String[] args ) throws IOException
    {
		String t= new String("dgiudn");
		//new UiUser();
		try {
			AfficherNotification an = new AfficherNotification();
			//an.AfficherMsgNotification(t);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

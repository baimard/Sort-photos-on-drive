package juxo;

import java.awt.AWTException;
import java.io.IOException;
import juxo.notification.AfficherNotification;

public class App 
{
	public static void main( String[] args ) throws IOException
    {
		new UiUser();
		try {
			new AfficherNotification();
		} catch (AWTException e) {
			e.printStackTrace();
		}
    }
}

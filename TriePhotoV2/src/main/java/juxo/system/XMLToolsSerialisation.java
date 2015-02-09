package juxo.system;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import juxo.notification.AfficherNotification;
import juxo.triephotoV2.accessFichier.Fichier;

public final class XMLToolsSerialisation {

	private XMLToolsSerialisation() {}
	
	
	/**
	 * serialisation d'un objet dans un fichier
	 * @param filename nom du fichier
	 */
	public static void encodeToFile(Object o, String filename) throws FileNotFoundException{
		
		File f = new File("target"+Fichier.SEPARATOR+"XML");
		if(!f.exists())
			f.mkdirs();
		
		XMLEncoder encoder = new XMLEncoder(new FileOutputStream(f+Fichier.SEPARATOR+filename+".xml"));
		try{
			encoder.writeObject(o);
			encoder.flush();
		}finally{
			encoder.close();
		}
		
	}
	
	/**
	 * Deserialisation d'un objet depuis un fichier
	 * @param filename nom du fichier
	 */
	public static Object decodeFromFile(String fileName) throws FileNotFoundException, IOException {
	    Object object = null;
	    
		File f = new File("target"+Fichier.SEPARATOR+"XML");
		if(f.exists()){
			  // ouverture de decodeur
		    XMLDecoder decoder = new XMLDecoder(new FileInputStream(f+Fichier.SEPARATOR+fileName+".xml"));
		    try {
		        // deserialisation de l'objet
		        object = decoder.readObject();
		    } finally {
		        // fermeture du decodeur
		        decoder.close();
		    }
		}
	  
	    return object;
	}
	
	public static void DeleteFile(String fileName){
		File f = new File("target"+Fichier.SEPARATOR+"XML"+Fichier.SEPARATOR+fileName+".xml");
		if(f.delete()){
			AfficherNotification.AfficherMsgNotification("Fichier bien supprimé :" + fileName);
		}
	}
	
}

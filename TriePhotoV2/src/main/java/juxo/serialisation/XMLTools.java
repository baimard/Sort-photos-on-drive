package juxo.serialisation;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class XMLTools {

	private XMLTools() {}
	
	
	/**
	 * serialisation d'un objet dans un fichier
	 * @param filename nom du fichier
	 */
	public static void encodeToFile(Object o, String filename) throws FileNotFoundException{
		
		File f = new File("target/XML");
		if(!f.exists())
			f.mkdirs();
		
		XMLEncoder encoder = new XMLEncoder(new FileOutputStream(f+"/"+filename+".xml"));
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
	    
		File f = new File("target/XML");
		if(f.exists()){
			  // ouverture de decodeur
		    XMLDecoder decoder = new XMLDecoder(new FileInputStream(f+"/"+fileName+".xml"));
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
	
}

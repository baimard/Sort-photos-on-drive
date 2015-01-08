package juxo.apiCalendar.definitionClasse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
@XmlType(name = "ExtendedProperties", namespace = "http://search.yahoo.com/mrss/", propOrder = {
    "private",
    
    
})
public class ExtendedProperties {
	@XmlElement
	protected List<String> privat;

	
	
	public List<String> getPrivate() {
		return privat;
	}
	public void setPrivate(List<String> privat) {
		this.privat = privat;
	}


}

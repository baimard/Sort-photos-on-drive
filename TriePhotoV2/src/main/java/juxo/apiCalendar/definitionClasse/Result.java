package juxo.apiCalendar.definitionClasse;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlAccessorType(XmlAccessType.NONE)
@JsonIgnoreProperties(ignoreUnknown=true)
@XmlType(name = "result", namespace = "http://search.yahoo.com/mrss/", propOrder = {
    "address_component",
})

public class Result {
    @XmlElement
	protected List<AddressComponent> address_component;


	public List<AddressComponent> getAddress_component() {
		return address_component;
	}

	public void setAddress_component(List<AddressComponent> address_component) {
		this.address_component = address_component;
	}
	
	public String getVille(){
		String s = null;
		
		for (AddressComponent c: address_component){
			if (c.getType().get(0).compareTo("locality")==0){
				s=c.getShort_name();
			}
		}
		return s;
	}
}
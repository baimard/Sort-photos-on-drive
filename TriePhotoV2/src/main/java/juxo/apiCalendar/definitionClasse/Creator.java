package juxo.apiCalendar.definitionClasse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Creator", namespace = "http://search.yahoo.com/mrss/", propOrder = {
    "email",
    "diplayName",
    "self",
    "id"
    
})

public class Creator {

	@XmlElement
	protected String email;
	@XmlElement
	protected String displayName;
	@XmlElement
	protected String self;
	@XmlElement
	protected String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}

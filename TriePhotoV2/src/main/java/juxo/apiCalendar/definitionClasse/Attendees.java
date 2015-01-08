package juxo.apiCalendar.definitionClasse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Attendees", namespace = "http://search.yahoo.com/mrss/", propOrder = {
		"email",
		"displayName",
		"self",
		"responseStatus",
		"organizer",
		"id",
		"resource",
		"optional",
		"comment",
		"additionalGuests"
    
})

public class Attendees {
	@XmlElement
	protected String email;
	@XmlElement
	protected String displayName;
	@XmlElement
	protected boolean organizer;
	@XmlElement
	protected String id;
	@XmlElement
	protected boolean resource;
	@XmlElement
	protected boolean optional;
	@XmlElement
	protected String comment;
	@XmlElement
	protected int additionalGuests;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isResource() {
		return resource;
	}
	public void setResource(boolean resource) {
		this.resource = resource;
	}
	public boolean isOptional() {
		return optional;
	}
	public void setOptional(boolean optional) {
		this.optional = optional;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getAdditionalGuests() {
		return additionalGuests;
	}
	public void setAdditionalGuests(int additionalGuests) {
		this.additionalGuests = additionalGuests;
	}
	public boolean isOrganizer() {
		return organizer;
	}
	public void setOrganizer(boolean organizer) {
		this.organizer = organizer;
	}
	@XmlElement
	protected boolean self;
	@XmlElement
	protected String responseStatus;
	
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
	public boolean isSelf() {
		return self;
	}
	public void setSelf(boolean self) {
		this.self = self;
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	

}

package juxo.apiCalendar.definitionClasse;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaGroup", namespace = "http://search.yahoo.com/mrss/", propOrder = {
    "kind",
    "etag",
    "summary",
    "updated",
    "timeZone",
    "accessRole",
    "defaultReminders",
    "nextSyncToken",
    "items",
    "nextPageToken",
    "description"
})
public class MediaGroup {
    @XmlElement(required = true)
    protected String kind;
    @XmlElement(required = true)
    protected String etag;
    @XmlElement(required = true)
    protected String summary;
    @XmlElement(required = true)
    protected String updated;
    @XmlElement(required = true)
    protected String timeZone;
    @XmlElement(required = true)
    protected String accessRole;
    @XmlTransient
    protected List<DefaultReminders> defaultReminders;
    @XmlElement
    protected String nextSyncToken;
    @XmlElement
    protected String nextPageToken;
    @XmlElement
    protected String description;
	@XmlElement
	public List<Items> items;
	
    public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNextPageToken() {
		return nextPageToken;
	}
	public void setNextPageToken(String nextPageToken) {
		this.nextPageToken = nextPageToken;
	}
	public String getNextSyncToken() {
		return nextSyncToken;
	}
	public void setNextSyncToken(String nextSyncToken) {
		this.nextSyncToken = nextSyncToken;
	}

    
    
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getAccessRole() {
		return accessRole;
	}
	public void setAccessRole(String accessRole) {
		this.accessRole = accessRole;
	}
	public List<DefaultReminders> getDefaultReminders() {
		return this.defaultReminders;
	}
	public void setDefaultReminders(List<DefaultReminders> defaultReminders) {
		this.defaultReminders = defaultReminders;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getEtag() {
		return etag;
	}
	public void setEtag(String etag) {
		this.etag = etag;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
}

package juxo.apiCalendar.definitionClasse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlAccessorType(XmlAccessType.NONE)
@JsonIgnoreProperties(ignoreUnknown=true)
@XmlType(name = "Items", namespace = "http://search.yahoo.com/mrss/", propOrder = {
    "kind",
    "etag",
    "id",
    "status",
    "htmlLink",
    "created",
    "updated",
    "summary",
    "description",
    "creator",
    "organize",
    "start",
    "end",
    "transparency",
    "visibility",
    "iCalUID",
    "sequence",
    "attendees",
    "reminders",
    "location",
    "endTimeUnspecified",
    "recurrence",
    "recurringEventId",
    "originalStartTime",
    "attendeesOmitted",
    "extendedProperties",
    "hangoutLink",
    "gadget",
    "anyoneCanAddSelf",
    "guestsCanInviteOthers",
    "guestsCanModify",
    "guestsCanSeeOtherGuests",
    "privateCopy",
    "locked",
    "source"
    
})
public class Items {

	public boolean isAnyoneCanAddSelf() {
		return anyoneCanAddSelf;
	}
	public void setAnyoneCanAddSelf(boolean anyoneCanAddSelf) {
		this.anyoneCanAddSelf = anyoneCanAddSelf;
	}
	public boolean isGuestsCanInviteOthers() {
		return guestsCanInviteOthers;
	}
	public void setGuestsCanInviteOthers(boolean guestsCanInviteOthers) {
		this.guestsCanInviteOthers = guestsCanInviteOthers;
	}
	public boolean isGuestsCanModify() {
		return guestsCanModify;
	}
	public void setGuestsCanModify(boolean guestsCanModify) {
		this.guestsCanModify = guestsCanModify;
	}
	public boolean isGuestsCanSeeOtherGuests() {
		return guestsCanSeeOtherGuests;
	}
	public void setGuestsCanSeeOtherGuests(boolean guestsCanSeeOtherGuests) {
		this.guestsCanSeeOtherGuests = guestsCanSeeOtherGuests;
	}
	public boolean isPrivateCopy() {
		return privateCopy;
	}
	public void setPrivateCopy(boolean privateCopy) {
		this.privateCopy = privateCopy;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	@XmlElement
	protected boolean anyoneCanAddSelf;
	@XmlElement
	protected boolean guestsCanInviteOthers;
	@XmlElement
	protected boolean guestsCanModify;
	@XmlElement
	protected boolean guestsCanSeeOtherGuests;
	@XmlElement
	protected boolean privateCopy;
	@XmlElement
	protected boolean locked;
	@XmlElement
	protected Source source;
	@XmlElement
	protected String location;
	@XmlElement
	protected boolean endTimeUnspecified;
	@XmlElement
    protected String kind;
	@XmlElement
	protected String etag;
	@XmlElement
    protected String id;
    @XmlElement
    protected String status;    
    @XmlElement
    protected String htmlLink;
    @XmlElement
    protected String created;    
    @XmlElement
    protected String updated;
    @XmlElement
	public String summary;
    @XmlElement
    protected String description;
    @XmlElement
    protected Creator creator;
    @XmlElement
    protected Organizer organizer;
    @XmlElement
    protected Start start;
    @XmlElement
    protected End end;
    @XmlElement
    protected String transparency;
    @XmlElement
    protected String visibility;
    @XmlElement
    protected boolean attendeesOmitted;
    @XmlElement
    protected ExtendedProperties extendedProperties;
    @XmlElement
    protected String hangoutLink;

    
    
    
    public boolean isAttendeesOmitted() {
		return attendeesOmitted;
	}
	public void setAttendeesOmitted(boolean attendeesOmitted) {
		this.attendeesOmitted = attendeesOmitted;
	}
	public ExtendedProperties getExtendedProperties() {
		return extendedProperties;
	}
	public void setExtendedProperties(ExtendedProperties extendedProperties) {
		this.extendedProperties = extendedProperties;
	}
	public String getHangoutLink() {
		return hangoutLink;
	}
	public void setHangoutLink(String hangoutLink) {
		this.hangoutLink = hangoutLink;
	}
	
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public List<String> getRecurrence() {
		return recurrence;
	}
	public void setRecurrence(List<String> recurrence) {
		this.recurrence = recurrence;
	}
	public String getRecurringEventId() {
		return recurringEventId;
	}
	public void setRecurringEventId(String recurringEventId) {
		this.recurringEventId = recurringEventId;
	}
	public Start getOriginalStartTime() {
		return originalStartTime;
	}
	public void setOriginalStartTime(Start originalStartTime) {
		this.originalStartTime = originalStartTime;
	}
	@XmlElement
    protected String iCalUID;
    @XmlElement
    protected int sequence;
    @XmlElement
    protected List<Attendees> attendees;
    @XmlElement
    protected Reminders reminders;
    @XmlElement
    protected List<String> recurrence;
    @XmlElement
    protected String recurringEventId;
    @XmlElement
    protected Start originalStartTime;
    
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHtmlLink() {
		return htmlLink;
	}
	public void setHtmlLink(String htmlLink) {
		this.htmlLink = htmlLink;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Creator getCreator() {
		return creator;
	}
	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	public Organizer getOrganizer() {
		return organizer;
	}
	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public Start getStart() {
		return start;
	}
	public void setStart(Start start) {
		this.start = start;
	}
	public End getEnd() {
		return end;
	}
	public void setEnd(End end) {
		this.end = end;
	}
	public String getTransparency() {
		return transparency;
	}
	public void setTransparency(String transparency) {
		this.transparency = transparency;
	}
	public String getiCalUID() {
		return iCalUID;
	}
	public void setiCalUID(String iCalUID) {
		this.iCalUID = iCalUID;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public List<Attendees> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<Attendees> attendees) {
		this.attendees = attendees;
	}
	public Reminders getReminders() {
		return reminders;
	}
	public void setReminders(Reminders reminders) {
		this.reminders = reminders;
	}
	public boolean isEndTimeUnspecified() {
		return endTimeUnspecified;
	}
	public void setEndTimeUnspecified(boolean endTimeUnspecified) {
		this.endTimeUnspecified = endTimeUnspecified;
	}
    public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}

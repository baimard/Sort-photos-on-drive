package juxo.apiCalendar.definitionClasse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gadget", namespace = "http://search.yahoo.com/mrss/", propOrder = {
    "type",
    "title",
    "link",
    "iconLink",
    "width",
    "height",
    "display",
    "preferences"
})

public class Gadget {
	@XmlElement
	protected String type;
	@XmlElement
	protected String title;
	@XmlElement
	protected String link;
	@XmlElement
	protected String iconLink;
	@XmlElement
	protected Integer width;
	@XmlElement
	protected Integer height;
	@XmlElement
	protected String display;
	@XmlTransient
	protected Preferences preferences;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getIconLink() {
		return iconLink;
	}
	public void setIconLink(String iconLink) {
		this.iconLink = iconLink;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	
	@XmlTransient
	public Preferences getPreferences() {
		return preferences;
	}
	@XmlTransient
	public void setPreferences(Preferences preferences) {
		this.preferences = preferences;
	}

	
}

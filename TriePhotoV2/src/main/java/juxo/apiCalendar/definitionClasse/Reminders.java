package juxo.apiCalendar.definitionClasse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reminders", namespace = "http://search.yahoo.com/mrss/", propOrder = {
    "useDefault",
    "overrides"
})
public class Reminders {
    @XmlElement
    protected String useDefault;
    @XmlElement
    protected List<Overrides> overrides;



	public List<Overrides> getOverrides() {
		return overrides;
	}

	public void setOverrides(List<Overrides> overrides) {
		this.overrides = overrides;
	}

	public String getUseDefault() {
		return useDefault;
	}

	public void setUseDefault(String useDefault) {
		this.useDefault = useDefault;
	}
    
}

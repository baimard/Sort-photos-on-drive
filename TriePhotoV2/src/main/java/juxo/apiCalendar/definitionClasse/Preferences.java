package juxo.apiCalendar.definitionClasse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Preferences", namespace = "http://search.yahoo.com/mrss/", propOrder = {
    "key"
})
public class Preferences {
 @XmlElement
 protected String key;

public String getKey() {
	return key;
}

public void setKey(String key) {
	this.key = key;
}
}

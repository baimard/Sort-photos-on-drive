package juxo.apiCalendar.definitionClasse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlAccessorType(XmlAccessType.NONE)
@JsonIgnoreProperties(ignoreUnknown=true)
@XmlType(name = "address_component", namespace = "http://search.yahoo.com/mrss/", propOrder = {
    "long_name",
	"short_name",
	"type"
})
public class AddressComponent {
	@XmlElement
	protected String long_name;
	@XmlElement
	protected String short_name;
	@XmlElement
	protected List<String> type;
	
	public String getLong_name() {
		return long_name;
	}
	public void setLong_name(String long_name) {
		this.long_name = long_name;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	public List<String> getType() {
		return type;
	}
	public void setType(List<String> type) {
		this.type = type;
	}


}

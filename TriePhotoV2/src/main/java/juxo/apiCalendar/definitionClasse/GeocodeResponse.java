package juxo.apiCalendar.definitionClasse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@XmlAccessorType(XmlAccessType.NONE)
@JsonIgnoreProperties(ignoreUnknown=true)
@XmlType(name = "GeocodeResponse", namespace = "http://search.yahoo.com/mrss/", propOrder = {
    "result",
    "status"
})
public class GeocodeResponse {
	@XmlElement
	protected List<Result> result;

    @XmlElement
    protected String status;
	
    
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}

}
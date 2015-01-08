package juxo.apiCalendar.definitionClasse;



import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Start", namespace = "http://search.yahoo.com/mrss/", propOrder = {
    "date",
    "dateTime",
    "timeZone"
    
})
public class Start {
	
	@XmlElement
	protected Date date;
	
	@XmlElement
	protected String timeZone;

	@XmlElement
	protected Date dateTime;


	public Date getDate() {
		return (Date) date.clone();
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Date getRealDate(){
		Date d = null;
		if(date!=null){
			d=(Date) date.clone();
		}else if(dateTime!=null){
			d= (Date) dateTime.clone();
		}
		
		return d;
	}

}

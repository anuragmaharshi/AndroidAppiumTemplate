package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class generalUtility {
	public static String  getDateString(){
		Date date = new Date();
	    final String dateAndTimeFormat = "MM-dd-yyyy_hh-mm-ss";
		DateFormat dateFormat = new SimpleDateFormat(dateAndTimeFormat);
	    //String dateTime = DateAndTime.getFormattedCurrentDateAndTime(dateAndTimeFormat);
	    String dateTime =dateFormat.format(date);
	    return dateTime;
	}
}

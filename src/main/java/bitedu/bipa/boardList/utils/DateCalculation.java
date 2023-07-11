package bitedu.bipa.boardList.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.util.Calendar;

public class DateCalculation {
	
	public static String getDate(Timestamp ts) {
		String date = null;
		date = "-";
		if(ts!=null) {
			Date temp = new Date(ts.getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.format(temp);
		}
		return date;
	}
	
}

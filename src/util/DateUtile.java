package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtile {

	static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("currenttime", dateFormat.format(new Date()));
    }
	public DateUtile() {
	}
}

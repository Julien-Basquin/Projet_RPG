package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author simon
 *
 * Ajoute la date et l'heure aux variables global
 */
public class DateUtile {

	static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
        System.setProperty("currenttime", dateFormat.format(new Date()));
    }
	
	/**
	 * Ajoute la date et l'heure aux variables global
	 */
	public DateUtile() {
	}
}

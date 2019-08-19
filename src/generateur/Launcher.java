package generateur;

import org.apache.log4j.PropertyConfigurator;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import util.DateUtile;

/**
 * Main du générateur, sert à lancer l'application.
 * 
 * @author Julien B.
 */

public class Launcher {
	
	public static LanguageManager languageManager;
	
	public static void main (String[] arg) {
		
		// Set date for logging system
		DateUtile dateUtile = new DateUtile();
		// Set log-level for logging system
		System.setProperty("logLevel", "DEBUG");
		// Set Log4j properties
		String log4jConfPath = "./ressources/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		// Set language
		languageManager = new LanguageManager("fr");
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		// max 60 fps
		config.foregroundFPS = 60;
		// set resolution to HD ready (1920 x 1080)
		config.width = 1920;
		config.height = 1080;
		// set full screen
		config.fullscreen = true;
		// set VSync
		config.vSyncEnabled = true;
		new LwjglApplication(new Generator(), config);
	}
}

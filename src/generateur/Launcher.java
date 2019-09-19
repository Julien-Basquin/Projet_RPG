package generateur;

import org.apache.log4j.PropertyConfigurator;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import util.DateUtile;
import util.LanguageManager;
import util.LoadConfiguration;

/**
 * Main du générateur, sert à lancer l'application.
 * 
 * @author Julien B.
 */

public class Launcher {
	
	public static LanguageManager languageManager;
	public static LoadConfiguration configuration;
	
	public static void main (String[] arg) {	
		// Set configuration
		configuration = new LoadConfiguration();
		// Set date for logging system
		DateUtile dateUtile = new DateUtile();
		// Set log-level for logging system
		System.setProperty("logLevel", configuration.getString("Config.General.LogLevel"));
		// Set Log4j properties
		String log4jConfPath = configuration.getString("Config.General.Log4J.Path");
		PropertyConfigurator.configure(log4jConfPath);
		// Set language
		languageManager = new LanguageManager(configuration.getString("Config.General.Laguage"));
		
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		// max FPS
		config.setIdleFPS(configuration.getInteger("Config.General.Max.FPS"));
		// set resolution
		config.setWindowedMode(configuration.getInteger("Config.General.Resolution.Width"), configuration.getInteger("Config.General.Resolution.Height"));
		// set VSync
		config.useVsync(configuration.getBoolean("Config.General.VSyncEnabled"));
		new Lwjgl3Application(new Generator(), config);
	}
}

package generateur;

import org.apache.log4j.PropertyConfigurator;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

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
	
	public static void main (String[] arg) {	
		// Set configuration
		LoadConfiguration configuration = new LoadConfiguration();
		// Set date for logging system
		DateUtile dateUtile = new DateUtile();
		// Set log-level for logging system
		System.setProperty("logLevel", configuration.getString("Config.General.LogLevel"));
		// Set Log4j properties
		String log4jConfPath = configuration.getString("Config.General.Log4J.Path");
		PropertyConfigurator.configure(log4jConfPath);
		// Set language
		languageManager = new LanguageManager(configuration.getString("Config.General.Laguage"));
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		// max FPS
		config.foregroundFPS = configuration.getInteger("Config.General.Max.FPS");
		// set resolution
		config.width = configuration.getInteger("Config.General.Resolution.Width");
		config.height = configuration.getInteger("Config.General.Resolution.Height");
		// set full screen
		config.fullscreen = configuration.getBoolean("Config.General.Fullscreen");
		// set VSync
		config.vSyncEnabled = configuration.getBoolean("Config.General.VSyncEnabled");
		new LwjglApplication(new Generator(), config);
	}
}
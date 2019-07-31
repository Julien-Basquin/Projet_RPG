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
	
	
	public static void main (String[] arg) {
		DateUtile dateUtile = new DateUtile();
		String log4jConfPath = "./ressources/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.width = 1024;
		config.height = 768;
		new LwjglApplication(new Generator(), config);
	}
}

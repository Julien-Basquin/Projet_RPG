package generateur;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * @author Julien
 *
 * Main du générateur, sert à lancer l'application.
 */

public class Launcher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.width = 1024;
		config.height = 768;
		new LwjglApplication(new Generator(), config);
	}
}

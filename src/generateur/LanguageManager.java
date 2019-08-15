package generateur;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * @author simon
 *
 *	Class pour la gestion du I18N
 */
public class LanguageManager {

	/**Logger*/
	private final Logger logger = Logger.getLogger(LanguageManager.class);
	private Properties prop;
	
	/**
	 * Initialisation de la lecture des langues avec choix par défeaut : anglais.
	 */
	public LanguageManager(String language) {
		try (InputStream input = new FileInputStream("ressources/generateur/language/language_"+language+".properties")) {

            prop = new Properties();


            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            logger.info("Language load : " + prop.getProperty("Languague.File.Used"));

        } catch (IOException ex) {
        	logger.fatal(ex);
        }
	}
	
	public String getProperty(String key) {
		String message = prop.getProperty(key);
		if(message == null) {
			logger.error("No key \"" + key + "\" find.");
		}
		return  message;
	}
	
	/**
	 * Change la langue du jeu.
	 */
	public void ChangeLanguage(String newLanguage) {
		try (InputStream input = new FileInputStream("ressources/generateur/language/language_"+newLanguage+".properties")) {

            prop = new Properties();


            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            logger.info("Language load : " + prop.getProperty("Languague.File.Used"));

        } catch (IOException ex) {
        	logger.fatal(ex);
        }
	}
	
}

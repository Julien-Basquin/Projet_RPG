package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.badlogic.gdx.utils.GdxRuntimeException;

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
	private Properties defaultProp;
	
	/**
	 * Initialisation de la lecture des langues avec choix par défeaut : anglais.
	 */
	public LanguageManager(String language) {
		try (InputStream input = new FileInputStream("ressources/generateur/language/language_"+language+".properties")) {

            prop = new Properties();

            //load a properties file from class path, inside static method
            prop.load(new InputStreamReader(input, Charset.forName("UTF-8")));

            //get the property value and print it out
            logger.info("Language load : " + prop.getProperty("Languague.File.Used"));

        } catch (IOException ex) {
        	logger.fatal(ex);
        }
		try (InputStream input = new FileInputStream("ressources/generateur/language/language_en.properties")) {

			defaultProp = new Properties();


            //load a properties file from class path, inside static method
			defaultProp.load(new InputStreamReader(input, Charset.forName("UTF-8")));

        } catch (IOException ex) {
        	logger.fatal("Error in Default \n" + ex);
        }
	}
	
	/**
	 * recherche dans le properties, si non trouver regarde dans le Default
	 * @param key
	 * @return Value
	 */
	public String getProperty(String key) {
		String message = prop.getProperty(key);
		if(message == null) {
			logger.error(new GdxRuntimeException("# ERROR: No key :"+ key + " find #"));
			message = defaultProp.getProperty(key);
			if(message == null) {
				logger.error(new GdxRuntimeException("# ERROR: No key :"+ key + " find in default#"));
			}
		}
		return  message;
	}
	
	/**
	 * Construit le Path et recherche dans le properties, si non trouver regarde dans le Default
	 * @param pathGlobal
	 * @param enumName
	 * @return Value
	 */
	public String getEnumProperty(String pathGlobal, String enumName) {
		String key = pathGlobal + "." + enumName;
		
		String message = prop.getProperty(key);
		if(message == null) {
			logger.error("No key \"" + key + "\" find.");
			message = defaultProp.getProperty(key);
			if(message == null) {
				logger.error("No key \"" + key + "\" find in default.");
			}
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
            prop.load(new InputStreamReader(input, Charset.forName("UTF-8")));

            //get the property value and print it out
            logger.info("Language load : " + prop.getProperty("Languague.File.Used"));

        } catch (IOException ex) {
        	logger.fatal(ex);
        }
	}
	
}

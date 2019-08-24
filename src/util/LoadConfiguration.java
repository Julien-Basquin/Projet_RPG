package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Class for load project configuration
 * @author simon
 *
 */
public class LoadConfiguration {
	private Properties configuration;
	
	/**
	 * load project configuration
	 */
	public LoadConfiguration() {
		try (InputStream input = new FileInputStream("ressources/config.properties")) {

			configuration = new Properties();

            //load a properties file from class path, inside static method
			configuration.load(new InputStreamReader(input, Charset.forName("UTF-8")));

        } catch (IOException ex) {
        	ex.printStackTrace();//can't log this
        }
	}
	
	/**
	 * get Integer property
	 * @param key
	 * @return
	 */
	public int getInteger(String key) {
		return Integer.parseInt(configuration.getProperty(key));
	}
	
	/**
	 * get Boolean property
	 * @param key
	 * @return
	 */
	public boolean getBoolean(String key) {
		return Boolean.parseBoolean(configuration.getProperty(key));
	}
	
	/**
	 * get String property
	 * @param key
	 * @return
	 */
	public String getString(String key) {
		return configuration.getProperty(key);
	}
}

package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.log4j.Logger;

public class LoadConfiguration {
	/**Logger*/
	private final Logger logger = Logger.getLogger(LanguageManager.class);
	private Properties configuration;
	
	public LoadConfiguration() {
		try (InputStream input = new FileInputStream("ressources/config.properties")) {

			configuration = new Properties();

            //load a properties file from class path, inside static method
			configuration.load(new InputStreamReader(input, Charset.forName("UTF-8")));

            //get the property value and print it out
            logger.info("configuration load");

        } catch (IOException ex) {
        	logger.fatal(ex);
        }
	}
	
	public int getInteger(String key) {
		return Integer.parseInt(configuration.getProperty(key));
	}
	
	public boolean getBoolean(String key) {
		return Boolean.parseBoolean(configuration.getProperty(key));
	}
	
	public String getString(String key) {
		return configuration.getProperty(key);
	}
}

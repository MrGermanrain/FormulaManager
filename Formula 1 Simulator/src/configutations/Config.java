package configutations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	
	public static String getConfig(String propertyName) {
		File configFile = new File("config.properties");
		String property = "";
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		    property = props.getProperty(propertyName);
		 
		    reader.close();
		    return property;
		} catch (FileNotFoundException ex) {
		    // file does not exist
		} catch (IOException ex2) {
		    // I/O error
		}
		return property;	
	}


}

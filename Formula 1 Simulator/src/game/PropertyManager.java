package game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class PropertyManager {

	public static void createProperties() {
		Properties p = new Properties();
		try {
			OutputStream os = new FileOutputStream("DriverConfig.yml");
			
			//for(int i = 0; i < CreateDrivers.drivers.length; i++) {
				//p.setProperty(CreateDrivers.drivers[i].getName(), null);
			//}
			
			p.setProperty("Test", "123");
			p.setProperty("Testing2", "1234");
			
			p.store(os, null);

			System.out.println("Driver Config has been created.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getProperties() {
		Properties p = new Properties();
		try {
			InputStream is = new FileInputStream("DriverConfig.yml");
			p.load(is);
			
			//p.getProperty("Key");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

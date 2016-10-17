package edu.classsearch.input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class get_Input {
	
	public static String inputload(String key){
	Properties prop = new Properties();
	InputStream input = null;
	String value=null;
	try {

		input = new FileInputStream("resources/inputdata/input.properties");

		// load a properties file
		prop.load(input);
		value=prop.getProperty(key);

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
	return value;
	}
}

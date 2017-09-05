package edu.asu.classsearch.input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ClassSearchInputs {

	private static String INPUT_SOURCE = "resources/inputdata/input.properties";
	private Properties props = new Properties();

	public ClassSearchInputs() throws IOException {
		InputStream is = new FileInputStream(INPUT_SOURCE);
		props.load(is);
	}

	public List<String> getTestCaseInputs(String testCaseID) {
		List<String> inputs;
		try {
			String inputString = props.getProperty(testCaseID);
			inputString = inputString.trim();
			String[] inputArray = inputString.split(",");
			inputs = new ArrayList<String>(Arrays.asList(inputArray));

		} catch (Exception e) {
			inputs = new ArrayList<>();
		}
		return inputs;
	}

}

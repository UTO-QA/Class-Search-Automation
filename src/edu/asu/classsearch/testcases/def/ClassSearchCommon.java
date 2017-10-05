package edu.asu.classsearch.testcases.def;

import java.util.List;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import edu.asu.classsearch.driver.ClassSearchDriver;

public class ClassSearchCommon {
	@After
	public void screenshotAndkillBrowser(Scenario scenario) {
		List<byte[]> screenshots = ClassSearchDriver.getAllScreenShots();
		screenshots.forEach((screenshot) -> {
			scenario.embed(screenshot, "image/png");
		});

		ClassSearchDriver.quitAllDrivers();

	}
}

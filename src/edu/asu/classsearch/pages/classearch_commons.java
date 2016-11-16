package edu.asu.classsearch.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class classearch_commons {
	private static  WebDriver driver;
	private static  String url="https://webapp4-qa.asu.edu/catalog";
	public static  WebDriver getconn(){
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	//close a connection
	public static  void closeconn(){
		driver.close();
	}
	public  WebDriver getDriver() {
		return driver;
	}
	public  void setDriver(WebDriver driver) {
		classearch_commons.driver = driver;
	}
}

package edu.asu.classearch.driver;

import org.openqa.selenium.WebDriver;

import edu.asu.classsearch.pages.classearch_commons;
import mx4j.tools.config.DefaultConfigurationBuilder.New;

public class ClassSearch_Driver {
	private  static final WebDriver driver=classearch_commons.getconn("https://webapp4-dev.asu.edu/elastic-catalog/");
	private  static final WebDriver prodDriver=classearch_commons.getconn("https://webapp4-dev.asu.edu/catalog/");
	
	private ClassSearch_Driver() {
	}
	
	public static WebDriver getInstance(){
		ClassSearch_Driver cd = new ClassSearch_Driver();
		return driver;
	} 
	
	public static WebDriver getProdInstance(){
		ClassSearch_Driver cd = new ClassSearch_Driver();
		return prodDriver;
	} 
}

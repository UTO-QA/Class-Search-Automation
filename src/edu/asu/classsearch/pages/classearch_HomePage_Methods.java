package edu.asu.classsearch.pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.*;
import cucumber.api.java.en.And;
public class classearch_HomePage_Methods {
	private static WebDriver driver;
	private String url="https://webapp4-qa.asu.edu/catalog";
	public void getconn(){
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	public void closeconn(){
		driver.close();
	}
	private static WebElement property_subject(){
		WebElement elem=driver.findElement(By.id("subjectEntry"));
		elem.clear();
		return elem;
	}
	private static WebElement property_Number(){
		WebElement elem=driver.findElement(By.id("catalogNbr"));
		elem.clear();	
		return elem;
	}
	private static WebElement property_keyword(){
		WebElement elem=driver.findElement(By.id("keywords"));
		elem.clear();
		return elem;
	}
	//-----------------------------------------------------------------------------
	public static void subject(String Searchterm){
		WebElement elem= property_subject();
		elem.sendKeys(Searchterm);
	}
	public static void subjectandnumber(String Searchterm,String number){
		WebElement elem=property_subject();
		WebElement elemnum=property_Number();
		elem.clear();
		elemnum.clear();
		elem.sendKeys(Searchterm);
		elemnum.sendKeys(number);
	}
	public static void Number(String number){
		WebElement elem= property_Number();
		elem.sendKeys(number);
	}
	public static void keyword(String keyword){
		WebElement elem= property_keyword();
		elem.sendKeys(keyword);
	}
	public static void keywordanddsubject(String Searchterm,String keyword){
		WebElement elem=property_keyword();
		WebElement elem_subject=property_subject();
		elem_subject.sendKeys(Searchterm);
		elem.sendKeys(keyword);
		
	}
	//---------------------------------------------------------------------------------
	public static void performsearch(){
		WebElement elem=driver.findElement(By.xpath("//a[@id='Go']"));
		WebDriverWait wait = new WebDriverWait(driver,30); //this is explicit wait
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		elem.click();
	}
	public static String assertresults(){
		String Text;
		try{
		WebElement elem=driver.findElement(By.id("CatalogList"));
		WebElement elem1=driver.findElement(By.id("CatalogList_info"));
		Text=elem1.getText();
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
		WebElement	elem=driver.findElement(By.className("error_msg"));
		Text=elem.getText();
		}
		return Text;
	}

}

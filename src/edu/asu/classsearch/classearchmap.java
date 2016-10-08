package edu.asu.classsearch;

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
public class classearchmap {
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
	public static void subject(String Searchterm){
		WebElement elem=driver.findElement(By.id("subjectEntry"));
		elem.clear();
		elem.sendKeys(Searchterm);
	}
	public static void subjectandnumber(String Searchterm,String number){
		WebElement elem=driver.findElement(By.id("subjectEntry"));
		WebElement elemnum=driver.findElement(By.id("catalogNbr"));
		elem.clear();
		elemnum.clear();
		elem.sendKeys(Searchterm);
		elemnum.sendKeys(number);
	}
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

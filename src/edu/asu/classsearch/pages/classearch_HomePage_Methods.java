package edu.asu.classsearch.pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.*;
import cucumber.api.java.en.And;
public class classearch_HomePage_Methods {
	private static WebDriver driver;
	private static String url="https://webapp4.asu.edu/catalog";
	public static void getconn(){
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	public static void closeconn(){
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
	private static WebElement property_radio_open(){
		WebElement elem =driver.findElement(By.id("searchTypeOpen"));
		return elem;
	}
	private static WebElement property_radio_All(){
		WebElement elem =driver.findElement(By.id("searchTypeAllClass"));				
		return elem;
	}
	private static WebElement property_radio_inperson(){
		WebElement elem =driver.findElement(By.id("typeSelectionCampus"));
		return elem;
	}
	private static WebElement property_radio_online(){
		WebElement elem =driver.findElement(By.id("typeSelectionOnline"));				
		return elem;
	}
	private static Select property_Semester_list(){
		Select select =new Select(driver.findElement(By.xpath("//select[@id='term']")));
		return select;
		
	}
	private static List<WebElement> property_Filter_By_session(){
		String[]options={"A","B","C","Dynamic"};
			List<WebElement> elem=driver.findElements(By.xpath("//input[contains(@id,'session')]"));
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
	public static void selectaterm(String term){
		Select select=property_Semester_list();
		select.selectByVisibleText(term);
	}
	public static void check_ifopenorall(String radio){
		if(radio.equals("open"))
		{
			WebElement elem=property_radio_open();
			elem.click();
		}
		if(radio.equals("all"))
		{
			WebElement elem=property_radio_All();
			elem.click();
		}
	}
	public static void check_campusoronline(String radio){
		if(radio.equals("campus"))
		{
			WebElement elem=property_radio_inperson();
			elem.click();
		}
		if(radio.equals("online"))
		{
			WebElement elem=property_radio_online();
			elem.click();
		}
	}
	//td[@class="locationBuildingColumnValue"]
	public static String verify_results(String verfiy)
		{	
		if(verfiy.equals("checkopenorall"))
			{
			List<WebElement> open=driver.findElements(By.xpath("//img[contains(@src,'circle')]"));
			List<WebElement> closed=driver.findElements(By.xpath("//img[contains(@src,'red')]"));
			if(closed.isEmpty()&& !open.isEmpty())
				return "true";
			else
				return "false";}
		if(verfiy.equals("location")){
			List<WebElement> location=driver.findElements(By.xpath("//td[@class='locationBuildingColumnValue' and not(contains(. ,'Online'))]"));
			if(!location.isEmpty())
				return "true";
			else
				return "false";
		}
		else
			return "none"; 
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

package edu.asu.classsearch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ClassSearch_AdvancedSearch {

	private WebDriver driver;
	public ClassSearch_AdvancedSearch(WebDriver driver) {
		this.driver=driver;
	}
	
	//Advanced Search Fields
	
	private  WebElement advancedSearch(){
		WebElement elem=driver.findElement(By.xpath("//*[@id='advSearchLink']"));
		return elem;
	}
	
	private  Select numberOfUnits(){
		Select elem=new Select(driver.findElement(By.xpath("//*[@id='units']")));
		return elem;
	}
	
	private  WebElement classNumber(){
		WebElement elem=driver.findElement(By.xpath("//*[@id='classNbr']"));
		return elem;
	}

	private  WebElement instructorName(){
		WebElement elem=driver.findElement(By.xpath("//*[@id='instructorName']"));
		return elem;
	}
	
	private  WebElement text_StartDate(){
		WebElement elem=driver.findElement(By.xpath("//*[@id='startDate']"));
		return elem;
	}
	
	private  WebElement text_EndDate(){
		WebElement elem=driver.findElement(By.xpath("//*[@id='endDate']"));
		return elem;
	}
	
	private  WebElement honors(){
		WebElement elem=driver.findElement(By.xpath("//*[@id='honors']"));
		return elem;
	}
	
	private  WebElement searchClassSBlocks(){
		WebElement elem=driver.findElement(By.xpath("//*[@id='Any_10']"));
		return elem;
	}
	
	private  Select collegeSchools(){
		Select elem=new Select(driver.findElement(By.xpath("//*[@id='college']")));
		return elem;
	}
	
	private  Select level(){
		Select elem=new Select(driver.findElement(By.xpath("//*[@id='level']")));	
		return elem;
	}
	
	private  Select generalStudies(){
		Select elem=new Select(driver.findElement(By.xpath("//*[@id='gs']")));
		return elem;
	}

	private  WebElement promod(){
		WebElement elem=driver.findElement(By.xpath("//*[@id='promod']"));
		return elem;
	}
	
	private Select generalStudiesOption1(){
		Select elem=new Select(driver.findElement(By.xpath("//*[@id='gsAw']")));
		return elem;
	}

	private Select generalStudiesOption2(){
		Select elem=new Select(driver.findElement(By.xpath("//*[@id='addGsAw']")));
		return elem;
	}
	


	public void clickAdvancedSearch(){
		WebElement element=advancedSearch();
		element.click();
	}
	
	public void selectNumberofUnits(String units){
		Select element= numberOfUnits();
		element.selectByVisibleText(units);
	}
	
	public void enterClassNumber(String number){
		WebElement element=classNumber();
		element.sendKeys(number);
	}
	
	public void enterInstructorName(String name){
		WebElement element=instructorName();
		element.sendKeys(name);
	}

	public void enterStartDate(String startDate){
		WebElement element=text_StartDate();
		element.sendKeys(startDate);
	}
	
	public void enterEndDate(String endDate){
		WebElement element=text_EndDate();
		element.sendKeys(endDate);
	}
	
	public void clickHonors(){
		WebElement element=honors();
		element.click();
	}
	
	public void clickPromod(){
		WebElement element=promod();
		element.click();
	}
	
	public void clickSearchClassBlocks(){
		WebElement element=searchClassSBlocks();
		element.click();
	}
	
	
	public void selectCollegeSchool(String college){
		Select element= collegeSchools();
		element.selectByVisibleText(college);
	}

	public void selectLevel(String level){
		Select element= level();
		element.selectByVisibleText(level);
	}

	public void selectGeneralStudies(String gs){
		Select element= generalStudies();
		element.selectByVisibleText(gs);
	}
	
	public void selectGeneralStudiesOption1(String gs1){
		Select element= generalStudiesOption1();
		element.selectByVisibleText(gs1);
	}
	
	public void selectGeneralStudiesOption2(String gs2){
		Select element= generalStudiesOption2();
		element.selectByVisibleText(gs2);
	}

	
}
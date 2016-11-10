package edu.asu.classsearch.pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage extends classearch_commons{
	//property username
	private static WebDriver driver;
	public void load_driver(){
		Loginpage page=new Loginpage();
		driver=page.getDriver();
	}
	private static WebElement property_username(){
		WebElement elem=driver.findElement(By.id("username"));
		return elem;
		
	}
	private static WebElement property_password(){
		WebElement elem=driver.findElement(By.id("password"));
		return elem;
		
	}
	private static WebElement property_submit(){
		WebElement elem=driver.findElement(By.id("login_submit"));
		return elem;
		
	}
	
	public void get_login(){
		Scanner sc=new Scanner(System.in);
		
		WebElement username=property_username();
		WebElement password=property_password();
		WebElement submit=property_submit();
		username.sendKeys(sc.next());
		password.sendKeys(sc.next());
		submit.click();
	}
}

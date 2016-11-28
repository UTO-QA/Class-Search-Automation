package edu.asu.classsearch.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class classearch_commons {
	private static  WebDriver driver;
	private static  String url="https://webapp4-qa.asu.edu/catalog";
	public static WebDriver select_driver(String browser){
		if(browser.equals("remote")){
			//Process child = Runtime.getRuntime().exec("");
			DesiredCapabilities capability = DesiredCapabilities.chrome();
            try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		else if(browser.equals("firefox")){
			driver=new FirefoxDriver();
		}
		else{
			Capabilities caps = new DesiredCapabilities();
            ((DesiredCapabilities) caps).setJavascriptEnabled(true);                
            ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);  
            ((DesiredCapabilities) caps).setCapability(
                    PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                    "C:\\Users\\bharadwaj\\Desktop\\phantomjs.exe");
            driver=new PhantomJSDriver(caps);
		}
			
		return driver;

	}
	public static  WebDriver getconn(){
		driver=select_driver("firefox");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		classearch_commons.url = url;
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

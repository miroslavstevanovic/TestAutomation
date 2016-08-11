package library.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Prepare {
	
	public static WebDriver getFirefoxDriver(){
		return new FirefoxDriver();		
	}
	
	public static WebDriver getChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		return new ChromeDriver();		
	}

}

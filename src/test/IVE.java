package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class IVE {
	
	WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {  
	  driver = new FirefoxDriver();
  }
  
  @Test
  public void login() {
	  driver.get("https://www.endavauniversity.com");
	  driver.manage().window().maximize();
	  Sleeper.sleepTightInSeconds(5);
	  driver.findElement(By.id("username")).sendKeys("ivecluj1");
	  driver.findElement(By.id("password")).sendKeys("IveParola2");
	  driver.findElement(By.id("loginbtn")).click();
	  Sleeper.sleepTightInSeconds(5);
	  String login = driver.findElement(By.cssSelector("div.logininfo")).getText();
	  System.out.println(login);
	  assert login.contains("You are logged in as ivecluj") : " You are not loged in!!!";
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}

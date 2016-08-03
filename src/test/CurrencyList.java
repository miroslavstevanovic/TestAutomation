package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class CurrencyList {
  
	// WEB DRIVER OBJEKAT
	WebDriver driver;
	
	
  @BeforeClass
  public void beforeClass() {
	  
	  // INICIJALIZACIJA OBJEKTA
	  driver = new FirefoxDriver();
	  
  }

  @Test
  public void f() {
	  
	  // OTVARANJE ZELJENE WEB STRANICE
	  driver.get("http://www.kursna-lista.com/");
	  
	  // TIME OUT - CEKA DA SE STRANICA UCITA
	  Sleeper.sleepTightInSeconds(5);
	  
	  // DRIVER LOCIRA WEB ELEMENT POMOCU XPATH-A I UZIMA TEKST KOJI JE ISPISAN U OKVIRU TOG ELEMENTA
	  String dan = driver.findElement(By.xpath("//header/h1")).getText();
	    
	  String euro = driver.findElement(By.xpath("//ul[contains(@id, 'highlightCurrencies')]/li[1]/big")).getText();
	  
	  // ISPISUJE TEKST KOJI JE WEB DRIVER POKUPIO IZ PRETHODNO NADJENIH ELEMENATA
	  System.out.println("===================================================================================");
	  System.out.println(dan + " - euro: " + euro);
	  System.out.println("===================================================================================");
  }
  
  
  @AfterClass
  public void afterClass() {
	  
	  // UNISTAVA INSTANCU WEB DRIVERA
	  driver.quit();
  }

}

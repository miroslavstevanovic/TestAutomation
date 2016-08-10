package library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends Page{
	
	@FindBy(id = "shortsearchbox")
	private WebElement searchInputField;
	
//	@FindBy(css = "input[type= 'submit'][value= 'Go']")
	@FindBy(xpath = "//input[contains(@value, 'Go') and contains(@type, 'submit')]")
	private WebElement goButton;
	
	private By goBtn = new ByXPath("//input[contains(@value, 'Go') and contains(@type, 'submit')]");
	
	public HomePage(WebDriver driver){
		super(driver);	
		waitForPageToBeLoaded(driver, goBtn, 5);
		/*
		 * Verovatno se pritate gde su one komande???
		 * Kada nasledimo Page.java klasu nasledjujemo i konstruktor kao sti smo i uradili: pozvali smo :     super(driver);
		 * Ako odete u Page.java klasu videcete da smo tamo stavili u konstruktor PageFactory.initElements(driver, this); - sto ce inicijalizovati 
		 * sve elemente pod klase gde je konstruktor super klase pozvan.
		 * 
		 * Pogledajte i LoginPage.java konstruktor.
		 */
	}
	
	/**
	 * Type search value into search field
	 * @param value {String}
	 * @return {HomePage}
	 */
	public HomePage typeSearchValueIntoSearchField(String value){
		System.out.println("typeSearchValueIntoSearchField("+value+")");
		searchInputField.sendKeys(value);
		return this;
	}
	
	public SearchResultPage clickOnGoButton(){
		System.out.println("clickOnGoButton()");
		//goButton.click();		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", goButton);
		return new SearchResultPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

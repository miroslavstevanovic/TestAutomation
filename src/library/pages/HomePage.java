package library.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(className = "logininfo")
	private WebElement loginInfoLabel;
	
	@FindBy(id = "shortsearchbox")
	private WebElement searchInputField;
	
	//@FindBy(css = "input[type= 'submit'][value= 'Go']")
	@FindBy(xpath = "//input[contains(@value, 'Go') and contains(@type, 'submit')]")
	private WebElement goButton;
	
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		Sleeper.sleepTightInSeconds(5);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Get text form login info label
	 * @return {String}
	 */
	public String getTextFromLoginInfoLabel(){
		return loginInfoLabel.getText();
	}
	
	/**
	 * Type search value into search field
	 * @param value {String}
	 * @return {HomePage}
	 */
	public HomePage typeSearchValueIntoSearchField(String value){
		searchInputField.sendKeys(value);
		return this;
	}
	
	public SearchResultPage clickOnGoButton(){
		//goButton.click();		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", goButton);
		return new SearchResultPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

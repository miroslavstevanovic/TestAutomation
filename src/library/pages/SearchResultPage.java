package library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends Page{
	
	@FindBy(linkText = "Career Development Discussion")
	private WebElement cddLink;
	
	@FindBy(css = "#region-main *[role='main'] h2")
	private WebElement searchResultsLabel;
	
	private By bySearchResultsLabel = new By.ByCssSelector("#region-main *[role='main'] h2");
	
	public SearchResultPage(WebDriver driver){
		super(driver);
		waitForPageToBeLoaded(driver, bySearchResultsLabel, 5);
	}

	public CDDPage clickOnCDDLink(){
		cddLink.click();
		return new CDDPage(driver);
	}
	
}

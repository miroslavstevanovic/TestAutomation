package test.cdd;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.CDDPage;
import library.pages.HomePage;
import library.pages.LoginPage;
import library.pages.SearchResultPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class CheckBoxFunctionality {

	private static WebDriver driver;

	boolean b = false;
	boolean isCheckd = false;

	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	CDDPage cddPage;

	String message;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);

	}

	@Test
	public void login() {

		loginPage.typeUsername(Property.username).typePassword(Property.password);
		homePage = loginPage.clickOnLoginButton();

		message = homePage.getTextFromLoginInfoLabel();
		System.out.println(message);

		assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";

		homePage.typeSearchValueIntoSearchField("career");
		searchResultPage = homePage.clickOnGoButton();
		cddPage = searchResultPage.clickOnCDDLink();

		cddPage.checkFristCheckBox();
		isCheckd = true;

		loginPage = cddPage.clickOnLogOutLink();

		loginPage.typeUsername(Property.username).typePassword(Property.password);
		homePage = loginPage.clickOnLoginButton();

		message = homePage.getTextFromLoginInfoLabel();
		System.out.println(message);

		assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";

		homePage.typeSearchValueIntoSearchField("career");
		searchResultPage = homePage.clickOnGoButton();
		cddPage = searchResultPage.clickOnCDDLink();

		assert cddPage.isFirstCheckBoxSelected() : "Check box should be selected";

		loginPage = cddPage.clickOnLogOutLink();
		System.out.println("Test passed");

		b = true;
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {

		driver.quit();

		if (isCheckd) {
			driver = new FirefoxDriver();
			loginPage = new LoginPage(driver);
			loginPage.typeUsername(Property.username).typePassword(Property.password);
			homePage = loginPage.clickOnLoginButton();
			message = homePage.getTextFromLoginInfoLabel();
			System.out.println(message);
			assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";
			homePage.typeSearchValueIntoSearchField("career");
			searchResultPage = homePage.clickOnGoButton();
			cddPage = searchResultPage.clickOnCDDLink();
			assert cddPage.isFirstCheckBoxSelected() : "Check box should be selected";
			cddPage.uncheckFristCheckBox();
			loginPage = cddPage.clickOnLogOutLink();
			driver.quit();
		}

		if (b) {

			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}

		

	}

}

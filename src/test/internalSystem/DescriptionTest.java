package test.internalSystem;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.CDDPage;
import library.pages.HomePage;
import library.pages.InternalSystemPage;
import library.pages.LoginPage;
import library.pages.MyProfilePage;
import library.pages.SearchResultPage;
import library.util.Prepare;
import library.util.Verification;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class DescriptionTest {

	private WebDriver driver;
	
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResult;
	CDDPage cddPage;
	MyProfilePage myProfilePage;
	InternalSystemPage internalSystemPage;
	
	String message;

	@BeforeClass
	public void beforeClass() {

		try {
			System.out.println("---Before Class");
			driver = Prepare.chromeDriver();
			
			System.out.println("---Step: Open login page");
			loginPage = new LoginPage(driver);

			System.out.println("---Step: Login");
			loginPage.typeUsername(Property.username).typePassword(Property.password);
			homePage = loginPage.clickOnLoginButton();

			System.out.println("---Step: Verify successful login");
			message = homePage.getTextFromLoginInfoLabel();
			Verification.verifyString(Property.loginMessage, message, "Verify login");
		} catch (Exception e) {
			throw e;
		}
	}

	@Test
	public void descriptionCheck() {
		try {
			System.out.println("---Test: endavaUniversity");
			System.out.println("---Step: Go to internal system page");
			homePage.clickOnEndavaUniversity();
			internalSystemPage = homePage.clickOnInternalSystemSelfHelpLink();
			message = internalSystemPage.getParagraphDescription();
			Verification.verifyString(Property.description, message, "Verify description");
			System.out.println("---Test passed");
		} catch (Exception e) {
			throw e;
		}
	}

	@AfterClass
	public void afterClass() {
		System.out.println("---After Class");
		driver.quit();
	}

}
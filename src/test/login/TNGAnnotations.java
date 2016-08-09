package test.login;

import org.testng.annotations.Test;
import library.data.Property;
import library.pages.HomePage;
import library.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TNGAnnotations {

	private static WebDriver driver;

	LoginPage loginPage;
	HomePage homePage;

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);
	}

	@BeforeMethod
	public void clearFields() {
		System.out.println("Before Method");
		loginPage.clearUsernameAndPasswordFields();
	}

	@Test(dependsOnMethods = "NeuspesnoLogovanje", groups = "Login")
	public void NeuspesnoLogovanje1() {
		System.out.println("Test: NeuspesnoLogovanje1()");
		loginPage.typeUsername(Property.username);
		loginPage.typePassword("fdsffs");
		loginPage.clickOnLoginButtonInvalidData();
		String errorMessage = loginPage.getErrorMessage();
		System.out.println(errorMessage);
		assert errorMessage.contains("Invalid login") : "ERROR: You are logged in";
		System.out.println("Test passed");
	}

	@Test()
	public void NeuspesnoLogovanje() {
		System.out.println("Test: NeuspesnoLogovanje()");
		loginPage.typeUsername("nenad");
		loginPage.typePassword(Property.password);
		loginPage.clickOnLoginButtonInvalidData();
		String errorMessage = loginPage.getErrorMessage();
		System.out.println(errorMessage);
		assert errorMessage.contains("Invalid login") : "ERROR: You are logged in";
		System.out.println("Test passed");
	}

	@Test(dependsOnMethods = "NeuspesnoLogovanje1")
	public void UspesnoLogovanje() {
		System.out.println("Test: UspesnoLogovanje");
		loginPage.typeUsername(Property.username).typePassword(Property.password);
		homePage = loginPage.clickOnLoginButton();
		String message = homePage.getTextFromLoginInfoLabel();
		System.out.println(message);
		assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("Usao u after class");
		driver.quit();
	}

}
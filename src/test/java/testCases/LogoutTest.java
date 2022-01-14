package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import main.Run.Base;
import pageObeject.LoginPage;
import pageObeject.PatientListingPage;

public class LogoutTest extends Base {
public	WebDriver driver;

	@Test
	public void logout() throws IOException, InterruptedException {
		LoginTest lg = new LoginTest();
		driver = lg.login();
		PatientListingPage pl = new PatientListingPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(pl.icon));
		pl.getIcon().click();
		pl.getLogout().click();
		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.getSignin().isDisplayed());//Sign button

	}

	@AfterTest
	public void teardown() {
		driver.close();

	}
}

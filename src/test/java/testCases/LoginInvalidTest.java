package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import main.Run.Base;
import pageObeject.LoginPage;
import pageObeject.PatientListingPage;

public final class LoginInvalidTest extends Base {
	static Logger logger = LogManager.getLogger(LoginTest.class);
	public WebDriver driver;
	@Test
	public void loginInvalid() throws IOException, InterruptedException {
		
	
		driver = Run();
		driver.get(prop.getProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("user");
		lp.getPwd().sendKeys("pass");
		lp.getSignin().click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.errMsg));
		String errorMsg=lp.getErrMsg().getText();
		Assert.assertEquals("Username or password is incorrect.", errorMsg);
		Assert.assertTrue(lp.getSignin().isDisplayed());//Sign button
	
	}
	@AfterTest
	public void teardown() {
		driver.close();
		
	}
	
	
	
}

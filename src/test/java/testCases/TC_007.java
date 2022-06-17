package testCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObeject.LoginPage;

import main.Run.Base;

public class TC_007 extends Base {

	@Test
	public void login_TC_005() throws IOException, InterruptedException {
		driver = Run();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getLogin().click();
		lp.getForgotPassword().click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(lp.getForgetPasswordModal()));
		Assert.assertTrue(lp.getForgetPasswordModal().isDisplayed());
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}

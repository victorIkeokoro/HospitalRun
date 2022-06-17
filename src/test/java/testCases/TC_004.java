package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import main.Run.Base;
import pageObeject.LoginPage;

public class TC_004 extends Base {

	public WebDriver driver;

	@Test
	public void login_TC_004() throws IOException, InterruptedException {
		driver = Run();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getLogin().click();
		lp.getAppleSigin().click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Sign in with Apple ID";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}

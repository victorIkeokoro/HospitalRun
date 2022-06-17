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

public class TC_001 extends Base {
	// static Logger logger = LogManager.getLogger(LoginTest.class);
	public WebDriver driver;

	@Test
	public void login_TC_001() throws IOException, InterruptedException {

		driver = Run();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getLogin().click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Giriş Yap - n11.com";
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@AfterTest
	public void teardown() {
		driver.close();

	}

}

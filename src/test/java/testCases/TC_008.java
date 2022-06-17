package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import pageObeject.LoginPage;

import main.Run.Base;

public class TC_008 extends Base {
	public void login_TC_005() throws IOException, InterruptedException {
		driver = Run();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getLogin().click();
		Assert.assertTrue(lp.getLoginHeader().isDisplayed());
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}

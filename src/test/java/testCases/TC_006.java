package testCases;

import java.io.IOException;
import java.util.ArrayList;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import main.Run.Base;
import pageObeject.LoginPage;

public class TC_006 extends Base {
	@Test
	public void login_TC_005() throws IOException, InterruptedException {
		driver = Run();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getLogin().click();
		String oldTab = driver.getWindowHandle();
		lp.getFacebook().click();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		;
		// change focus to new tab
		driver.switchTo().window(newTab.get(0));
		Thread.sleep(4000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook";
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}

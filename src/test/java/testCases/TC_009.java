package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import main.Run.Base;
import pageObeject.LoginPage;
import org.openqa.selenium.interactions.Actions;

public class TC_009 extends Base {
	@Test

	public void login_TC_002() throws IOException, InterruptedException {
		driver = Run();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getLogin().click();
		driver.findElement(By.className("dn-slide-accept-btn")).click();
		Actions click = new Actions(driver);
		click.moveToElement(lp.getRememberMe()).click().build().perform();
		Assert.assertTrue(lp.getRememberMe().isSelected());
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}

package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import main.Run.Base;
import pageObeject.LoginPage;

public class TC_012 extends Base {
	@Test
	public void login_TC_010() throws IOException, InterruptedException {
		driver = Run();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getLogin().click();
		driver.findElement(By.className("dn-slide-accept-btn")).click();
		lp.getEmail().sendKeys("victorikeokoro37@gmail.com");
		lp.getPassword().sendKeys("PcCDfsdgsdfgaffsgn6");
		lp.getShowPassword().click();
		Assert.assertTrue(lp.getErrMsg().isDisplayed());

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}

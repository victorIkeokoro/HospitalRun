package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import main.Run.Base;
import pageObeject.LoginPage;

public class TC_010 extends Base {

	@Test
	public void login_TC_010() throws IOException, InterruptedException {
		driver = Run();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getLogin().click();
		driver.findElement(By.className("dn-slide-accept-btn")).click();
		lp.getEmail().sendKeys("victorikeokoro37@gmail.com");
		lp.getPassword().sendKeys("PcCD6R6fVgv!eVz");
		lp.getShowPassword().click();
		Assert.assertEquals("text", lp.getPassword().getAttribute("type"));
		lp.getShowPassword().click();
		Assert.assertEquals("password", lp.getPassword().getAttribute("type"));
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}

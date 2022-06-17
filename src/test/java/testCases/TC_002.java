package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import main.Run.Base;
import pageObeject.LoginPage;

public class TC_002 extends Base {
	public WebDriver driver;

	@Test
	public void login_TC_002() throws IOException, InterruptedException {
		driver = Run();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getLogin().click();
		driver.findElement(By.className("dn-slide-accept-btn")).click();
		lp.getEmail().sendKeys("victorikeokoro37@gmail.com");
		lp.getPassword().sendKeys("PcCD6R6fVgv!eVz");
		lp.getloginButton().click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "n11.com - Hayat Sana Gelir";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}

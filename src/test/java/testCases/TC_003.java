package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import main.Run.Base;
import pageObeject.LoginPage;

public class TC_003 extends Base {

	public WebDriver driver;

	@Test
	public void login_TC_003() throws IOException, InterruptedException {
		driver = Run();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getLogin().click();
		lp.getEmail().sendKeys("victorikeokoro37@gmail.com");
		lp.getPassword().sendKeys("PcCD6R6fVgv!eds");
		lp.getloginButton().click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Giriş Yap - n11.com";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(lp.getErrMsg().isDisplayed());
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}

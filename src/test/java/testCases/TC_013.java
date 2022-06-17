package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;s
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.Run.Base;
import pageObeject.LoginPage;

public class TC_013 extends Base {

	@Test

	public void login_TC_013() throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setAcceptInsecureCerts(false);

		ChromeOptions coptions = new ChromeOptions();
		coptions.merge(dc);
		WebDriver driver = new ChromeDriver(coptions);
		// Launching the URL
		driver.get("https://www.n11.com/");
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

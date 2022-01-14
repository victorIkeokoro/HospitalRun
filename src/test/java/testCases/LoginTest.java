package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import main.Run.Base;
import pageObeject.LoginPage;
import pageObeject.PatientListingPage;

public class LoginTest extends Base {
	public WebDriver driver;
	@Test
	public void login1() throws IOException, InterruptedException {
		driver = Run();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("hr.doctor@hospitalrun.io");
		lp.getPwd().sendKeys("HRt3st12");
		lp.getSignin().click();
		PatientListingPage pl = new PatientListingPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 70);
		wait.until(ExpectedConditions.elementToBeClickable(pl.title));
		Assert.assertEquals(pl.getTitile().getText(), "Patient Listing");
	
	}
	
	
	
	public WebDriver login() throws IOException, InterruptedException {
		driver = Run();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("hr.doctor@hospitalrun.io");
		lp.getPwd().sendKeys("HRt3st12");
		lp.getSignin().click();
		PatientListingPage pl = new PatientListingPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 70);
		wait.until(ExpectedConditions.elementToBeClickable(pl.title));
		Assert.assertEquals(pl.getTitile().getText(), "Patient Listing");
		return driver;
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		
	}
	
	
	
}

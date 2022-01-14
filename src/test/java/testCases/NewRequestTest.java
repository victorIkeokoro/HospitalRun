package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import pageObeject.NewMedicationtPage;
import pageObeject.PatientListingPage;

public class NewRequestTest {
	public WebDriver driver;

	@Test
	public void newRequest() throws IOException, InterruptedException {
		LoginTest lg = new LoginTest();
		driver = lg.login();
		PatientListingPage pl = new PatientListingPage(driver);
		pl.getMedication().click();
		pl.getnewRequest().click();
		Assert.assertEquals(pl.getTitile2().getText(), "New Medication Request");// New Medication Request page
		NewMedicationtPage nm = new NewMedicationtPage(driver);
		nm.getPatient().sendKeys("Test Patient");
		WebDriverWait C = new WebDriverWait(driver, 60);
		while (nm.getPatientSuggestion().size() == 0) {
			String s = Keys.chord(Keys.CONTROL, "a");
			nm.getPatient().sendKeys(s);
			nm.getPatient().sendKeys(Keys.DELETE);
			nm.getPatient().sendKeys("Test Patient");
		}

		List<WebElement> suggestions = nm.getPatientSuggestion();
		for (int i = 0; i < suggestions.size(); i++) {
			if (suggestions.get(i).getText().trim().equals("Test Patient - P00201")) {
				suggestions.get(i).click();
			}
		}
		nm.getMedication().sendKeys("Pramoxine");
		nm.getMedicationSuggestion().get(0).click();
		WebElement select = driver.findElement(By.tagName("select"));
		List<WebElement> options = select.findElements(By.tagName("option"));
		while (options.size() < 2) {
			options = select.findElements(By.tagName("option"));
		}
		options.get(1).click();
		nm.getPrescription().sendKeys("Testing prescription");
		nm.getPrescriptionDate().clear();
		nm.getPrescriptionDate().sendKeys(nm.getDate());
		int j = nm.getRand(1, 5);
		int k = nm.getRand(5, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]", nm.getQuantityRequested(), j);

		((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]", nm.getRefills(), k);
		nm.getAdd().click();
		Actions ac = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(nm.medicationPopupTitle));
		wait.until(ExpectedConditions.elementToBeClickable(nm.close));
		wait.until(ExpectedConditions.elementToBeClickable(nm.ok));
		Assert.assertTrue(nm.getMedicationPopupTitle().isDisplayed());
		Assert.assertTrue(nm.getOk().isDisplayed());
		Assert.assertTrue(nm.getClose().isDisplayed());
		ac.moveToElement(nm.getOk()).click(nm.getOk()).perform();
	((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]", nm.getQuantityRequested(), j);
		((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]", nm.getRefills(), k);
		Assert.assertTrue(nm.getMedicationPopupTitle2().size() == 0);
		Assert.assertEquals(pl.getTitile2().getText(), "New Medication Request");
	}
	@AfterTest
	public void teardown() {
		driver.close();
		
	}

}

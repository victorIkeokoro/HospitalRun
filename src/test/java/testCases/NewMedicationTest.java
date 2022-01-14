package testCases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObeject.PatientListingPage;

public class NewMedicationTest {
	public WebDriver driver;
	
	@Test
	public void newMedication() throws IOException, InterruptedException {
		LoginTest lg = new LoginTest();
		driver = lg.login();
		PatientListingPage pl = new PatientListingPage(driver);
		pl.getMedication().click();
		List<WebElement> content = pl.getMedicationContent();
		List<String> list = new ArrayList<String>();
		for (int i=0 ;i<content.size();i++) {
			list.add(content.get(i).getText());
		}
		 List<String> list2 = new ArrayList<String>();
		 list.add("Requests");
	        list2.add("Completed");
	        list2.add("New Request");
	        list2.add("Return Medication");
	       Assert.assertTrue(list.containsAll(list2));
	}
	
	
	
	@AfterTest
	public void teardown() {
		driver.close();
		
	}
	
}

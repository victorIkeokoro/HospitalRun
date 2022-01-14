package pageObeject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientListingPage {

	WebDriver driver;

	public PatientListingPage(WebDriver driver) {
		this.driver = driver;
	}

	public By title = By.tagName("h1");
	public By logout = By.xpath(".//a[text()=\"Logout\"]");
	By medication = By.xpath("//a[text()=\"Medication\"]");
	By medicationContent =By.xpath("//div[@class=\"category-sub-items\"]//a");
	By newRequest = By.xpath("//a[text()=\"New Request\"]");
	By title2 = By.tagName("h1");
	
	public By icon =By.xpath("//span[@class=\"mega-octicon octicon-gear\"]");

	public WebElement getTitile() {

		return driver.findElement(title);
	}

	public WebElement getIcon() {

		return driver.findElement(icon);
	}
	public WebElement getLogout() {
		return driver.findElement(logout);
	}
	public WebElement getMedication() {
		return driver.findElement(medication);
	}
	public List<WebElement> getMedicationContent() {
		return driver.findElements(medicationContent);
	}
	
	public WebElement getnewRequest () {
		return driver.findElement(newRequest);
	}
	
	public WebElement getTitile2() {

		return driver.findElement(title2);
	}
	
}

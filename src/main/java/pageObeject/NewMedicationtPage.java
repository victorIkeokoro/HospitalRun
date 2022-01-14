package pageObeject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewMedicationtPage {

	WebDriver driver;

	public NewMedicationtPage(WebDriver driver) {
		this.driver = driver;
	}

	By patient = By.cssSelector("input[id*=\"patientTypeAhead\"]");
	By visit = By.tagName("select");
	By medication = By.cssSelector("input[id*=\"inventoryItemType\"]");
	By prescription = By.cssSelector("textarea[id*=\"prescription\"]");
	By prescriptionDate = By.cssSelector("input[id*=\"prescription\"]");
	By quantityRequested = By.cssSelector("input[id*=\"quantity\"]");
	By refills = By.cssSelector("input[id*=\"refills\"]");
	public By patientSuggestion = By.cssSelector("div[class*=\"tt-suggestion\"]");
	public By medicationSuggestion = By.xpath("//div/strong[text()=\"Pramoxine\"]");
	By add = By.xpath("//button[text()=\"Add\"]");
	public By ok = By.xpath("//button[text()=\"Ok\"]");
	public By close = By.className("close");
	public By medicationPopupTitle= By.xpath("//h4[text()=\"Medication Request Saved\"]");

	public WebElement getPatient() {

		return driver.findElement(patient);

	}

	public WebElement getVisit() {

		return driver.findElement(visit);

	}

	public WebElement getMedication() {

		return driver.findElement(medication);

	}

	public WebElement getPrescription() {

		return driver.findElement(prescription);

	}

	public WebElement getPrescriptionDate() {

		return driver.findElement(prescriptionDate);

	}

	public WebElement getQuantityRequested() {

		return driver.findElement(quantityRequested);

	}

	public WebElement getRefills() {

		return driver.findElement(refills);

	}

	public List<WebElement> getPatientSuggestion() {

		return driver.findElements(patientSuggestion);
	}

	public List<WebElement> getMedicationSuggestion() {

		return driver.findElements(medicationSuggestion);
	}

	public String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate today = LocalDate.now();
		LocalDate yesterday = today.minusDays(1);
		return dtf.format(yesterday);

	}

	public int getRand(int lower, int upper) {

		int r = (int) (Math.random() * ((upper + 1) - lower)) + lower;

		return r;
	}

	public WebElement getAdd() {

		return driver.findElement(add);
	}

	public WebElement getClose() {

		return driver.findElement(close);
	}

	public WebElement getOk() {

		return driver.findElement(ok);
	}

	public WebElement getMedicationPopupTitle() {

		return driver.findElement(medicationPopupTitle);
	}
	public List<WebElement> getMedicationPopupTitle2() {

		return driver.findElements(medicationPopupTitle);
	}
	

}

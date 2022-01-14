package pageObeject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.id("identification");
	By pwd = By.id("password");
	By signin = By.className("btn");
	public By errMsg = By.xpath("//div[@role=\"alert\"]");

	public WebElement getUsername() {

		return driver.findElement(username);

	}

	public WebElement getPwd() {

		return driver.findElement(pwd);

	}

	public WebElement getSignin() {

		return driver.findElement(signin);

	}

	public WebElement getErrMsg() {

		return driver.findElement(errMsg);

	}

}

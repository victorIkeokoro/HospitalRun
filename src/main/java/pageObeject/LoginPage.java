package pageObeject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	
	By login =By.className("btnSignIn");
	By email = By.id("email");
	By password = By.id("password");
	By loginButton = By.id("loginButton");
	By rememberMe = By.id("rememberMe");
	By appleSigin=By.className("apple-login-btn");
	By quickLogin=By.className("quickLogin");
	By facebook =By.className("btnLogin");
	By errMsg = By.xpath("//div[contains(@data-errormessagefor,'password')]");
	By forgetPassword = By.id("forgotPassword");
	By forgetPasswordModal =By.id("forgotPasswordModalWrapper");
	By loginHeader=By.id("header");
	By showPassword = By.className("showPass");

	
	
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	public WebElement getEmail() {

		return driver.findElement(email);

	}

	public WebElement getPassword() {

		return driver.findElement(password);

	}

	public WebElement getloginButton() {

		return driver.findElement(loginButton);

	}
	public WebElement getRememberMe() {

		return driver.findElement(rememberMe);

	}

	public WebElement getErrMsg() {

		return driver.findElement(errMsg);

	}
	public WebElement getAppleSigin() {

		return driver.findElement(appleSigin);

	}	public WebElement getQuickLogin() {

		return driver.findElement(quickLogin);

	}	public WebElement getFacebook() {

		return driver.findElement(facebook);

	}
	public WebElement getForgotPassword() {

		return driver.findElement(forgetPassword);

	}
	public WebElement getForgetPasswordModal() {

		return driver.findElement(forgetPasswordModal);

	}
	
	public WebElement getLoginHeader() {

		return driver.findElement(loginHeader);

	}
	public WebElement getShowPassword () {

		return driver.findElement(showPassword );

	}
	
	
	
	
	
	

}

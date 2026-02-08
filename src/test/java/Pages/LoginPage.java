package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;

	// Locators
	By username = By.id("user-name");
	By password = By.id("password");
	By loginBtn = By.id("login-button");
	By errorMsg = By.cssSelector("h3[data-test='error']");

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Actions
	public void enterUsername(String uname) {
		driver.findElement(username).sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}

	public boolean isErrorDisplayed() {
		return driver.findElement(errorMsg).isDisplayed();
	}

}

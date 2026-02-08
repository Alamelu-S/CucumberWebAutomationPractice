package StepDefinitions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition 
{
	LoginPage loginPage;
	WebDriver driver;
	
	List<WebElement> list = new ArrayList<WebElement>();

	@Given("User is login page")
	public void userIsLoginPage() 
	{
		System.out.println("I am in 1 st method");
		//driver = new ChromeDriver();
		driver = Hooks.driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/v1/");
     	driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
	}
	
	@When("User enters username as {string}")
	public void userEntersUsernameAs(String username) 
	{
		loginPage.enterUsername(username);
				
	}
	@When("User enters password as {string}")
	public void userEntersPasswordAs(String password) 
	{
		loginPage.enterPassword(password);
	}

	@When("Click on login button")
	public void clickOnLoginButton() {
		
		loginPage.clickLogin();
		//driver.findElement(By.xpath("//input[@id='login-button']")).click();
		// driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("user navigate to login home page")
	public void userNavigateToLoginHomePage() 
	{
		// String tagName = driver.findElement(By.xpath("//title[normalize-space()='My
		// Account']")).getTagName();
//		System.out.println("Tagname ::: "+tagName);
//			//Assert.assertTrue(True, tagName);
		Assert.assertTrue(driver.findElements(By.xpath("//div[@class='app_logo']")).size() > 0,
				"user navigate to login home page");

	}
	/*
	 * @Then("Close the browser") public void closeTheBrowser() { driver.quit(); }
	 */

//Logout
	@Given("User should navigate to inventory page")
	public void userShouldNavigateToInventoryPage() 
	{
		System.out.println("Inventory Page :::");
		
		driver.findElement(By.xpath("//button[normalize-space()='Open Menu']")).click();
		//driver.findElement(By.tagName("button")).click();
	}

	@Given("User should select the dropdown list")
	public void userShouldSelectTheDropdownList() {
		System.out.println("Dropdown list method");
		list = driver.findElements(By.xpath("//div[@class='bm-menu']//a"));
		System.out.println("Size of list :" + list.size());
		}

	@When("User click the Logout")
	public void userClickTheLogout() 
	{
		System.out.println("Logout Click ");
		for (WebElement webEle : list) 
		{
			System.out.println("Element " + webEle.getText());
			if(webEle.getText().equalsIgnoreCase("Logout"))
			{
				System.out.println("Inside If");
				driver.findElement(By.linkText("Logout")).click();
				System.out.println("After logout clicked");
				break;
			}
		}
	}

	@Then("User navigate to login page")
	public void userNavigateToLoginPage() 
	{
		System.out.println("User is in Login Page after sucessful logout.");
		//driver.navigate().to("https://www.saucedemo.com/v1/index.html");
	}
	
//	@When("User enters Invalid username and Invalid password")
//	public void userEntersInvalidUsernameAndInvalidPassword() 
//	{
//		System.out.println("Invalid Username and password :");
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//		driver.findElement(By.id("password")).sendKeys("secret");
//	}
	
	@Then("user get error message")
	public void userGetErrorMessage() 
	{
		String errorMsg = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
	    System.out.println("Message :: "+errorMsg);
	    Assert.assertEquals(errorMsg, "Epic sadface: Username and "
	    		+ "password do not match any user in this service");
	    //driver.quit();-- this will take from hooks
	}
	

}


package StepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.InventoryPage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DisplayItemStepDefinition {
	WebDriver driver;
	InventoryPage inventoryPage;
	LoginPage loginPage;

	@Given("User is on the Login Page")
	public void user_is_on_login_page() {
		System.out.println("Login page ::: 1:");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");
		inventoryPage = new InventoryPage(driver);
		loginPage = new LoginPage(driver);

	}

	@When("User enters valid username as {string}")
	public void user_enters_valid_username(String username) {
		loginPage.enterUsername(username);

	}

	@When("User enters valid password as {string}")
	public void user_enters_valid_password(String password) {
		loginPage.enterPassword(password);

	}

	@When("User clicks the login button")
	public void user_clicks_login_button() {
		loginPage.clickLogin();

	}

	@Then("User should be navigated to the Inventory Page")
	public void user_should_be_navigated_to_inventory_page() {
		// Assert.assertTrue(inventoryPage.isInventoryPageDisplayed()); i didnt write
		// this into Invetorypage

		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User is not on Inventory Page!");

	}

	@Then("User should see a list of all available inventory items")
	public void user_should_see_inventory_items() {
		inventoryPage.printAllItems();
		Assert.assertTrue(inventoryPage.getItemCount() > 0, "No item found");
		driver.quit();

		/*
		 * // Find allItems in the page
		 * 
		 * List<WebElement> items =
		 * driver.findElements(By.className("inventory_item_name"));
		 * System.out.println("Available Inventory Items:");
		 * 
		 * for (WebElement eleItem : items) { System.out.println(eleItem.getText());
		 * 
		 * } // Assert that list is not empty
		 * 
		 * Assert.assertTrue(items.size() > 0, "No item found");
		 * 
		 * // Close the browser after the test
		 */

		//driver.quit();

	}

}

//package StepDefinitions;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//
//public class AddToCartStepDefinitionOld {
//	WebDriver driver;
//
//	@Given("User is login page")
//	public void user_is_login_page() {
//		System.out.println("Login page ::: 1:");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("https://www.saucedemo.com/");
//
//	}
//
//	@And("User enter login as {string} and {string}")
//	public void user_enter_login_and(String username, String password) {
//		driver.findElement(By.id("user-name")).sendKeys(username);
//		driver.findElement(By.id("password")).sendKeys(password);
//		driver.findElement(By.id("login-button")).click();
//	}
//
//	@And("User search item {string}")
//	public void user_search_item(String item) {
//		// SauceDemo inventory page doesn't have search, so we simulate by locating item
//		// Check if item exists in inventory
//		/*
//		 * WebElement inventoryItem = driver.findElement
//		 * (By.xpath("//div[@class='inventory_item_name' and text()='" + item + "']"));
//		 * Assert.assertTrue(inventoryItem.isDisplayed(), "Item not found: " + item);
//		 */
//
//		// Find allItems in the page
//
//		List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
//		System.out.println("Available Inventory Items:");
//
//		for (WebElement eleItem : items) {
//			System.out.println(eleItem.getText());
//
//			if (eleItem.getText().equalsIgnoreCase(item)) 
//			{
//				System.out.println("Inside if element before assert is displayed::"+eleItem.getText());
//				Assert.assertTrue(eleItem.isDisplayed(),"Item not Found" + item);
//				System.out.println("Inside if element after assert is displayed::"+eleItem.getText());
//			}
//
//		}
//
//	}
//
//	@And("User add the item into cart")
//	public void user_add_item_into_cart() {
//		// Click "Add to cart" button for the item found
//		System.out.println("Inside user add item cart method");
//		WebElement addButton = driver.findElement(By.xpath("//button[contains(@id,'add-to-cart')]"));
//		addButton.click();
//	}
//
//	@Then("Cart should be updated")
//	public void cart_should_be_updated() {
//		// Check cart badge count
//		System.out.println("Inside cart badge count ");
//		WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
//		Assert.assertTrue(cartBadge.isDisplayed(), "Cart was not updated!");
//		System.out.println("Cart count: " + cartBadge.getText());
//
//		// Close browser
//		driver.quit();
//
//	}
//
//}

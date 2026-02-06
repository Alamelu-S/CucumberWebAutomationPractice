//package StepDefinitions;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//
//public class AddToCartStepDefinitionold1 
//{
//	WebDriver driver;
//	WebDriverWait wait;
//
//	@Given("User enter into login page")
//	public void user_enter_into_login_page() 
//	{
//		System.out.println("Login page ::: 1:");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.saucedemo.com/");
//
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
//		System.out.println("Searching item: " + item);
//
//		// Wait until inventory items are visible
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item")));
//
//		List<WebElement> items = driver.findElements(By.className("inventory_item"));
//		boolean found = false;
//
//		for (WebElement eleItem : items) {
//			String itemName = eleItem.findElement(By.className("inventory_item_name")).getText();
//			if (itemName.equalsIgnoreCase(item)) {
//				System.out.println("Item found in inventory: " + itemName);
//				found = true;
//				break;
//			}
//		}
//
//		Assert.assertTrue(found, "Item not found in inventory: " + item);
//	}
//	
//	@And("User add the item into cart")
//	public void user_add_item_into_cart() {
//	    System.out.println("Inside user add item cart method");
//
//	    // Find all items
//	    List<WebElement> items = driver.findElements(By.className("inventory_item"));
//	    
//	    for (WebElement eleItem : items) {
//	        String itemName = eleItem.findElement(By.className("inventory_item_name")).getText();
//	        if (itemName.equalsIgnoreCase("Sauce Labs Backpack")) { // or pass the item as parameter
//	            // Click Add to cart for this item
//	            eleItem.findElement(By.tagName("button")).click();
//	            break;
//	        }
//	    }
//	}
//	
//	@Then("Cart should be updated")
//    public void cart_should_be_updated() {
//        System.out.println("Verifying cart badge...");
//
//        // Wait until cart badge appears
//        WebElement cartBadge = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
//        Assert.assertTrue(cartBadge.isDisplayed(), "Cart badge is not displayed!");
//        System.out.println("Cart count: " + cartBadge.getText());
//
//        driver.quit();
//    }
//
//
//
///*	@And("User add the item {string} into cart") // Multiple items adding
//	public void user_add_item_into_cart(String item) 
//	{
//		System.out.println("Adding item to cart...");
//
//		List<WebElement> items = driver.findElements(By.className("inventory_item"));
//		
//		for (WebElement eleItem : items) 
//		{
//			String itemName = eleItem.findElement(By.className("inventory_item_name")).getText();
//			
//			if (itemName.equalsIgnoreCase(item)) {
//
//	            WebElement addBtn =
//	                    eleItem.findElement(By.xpath(".//button[starts-with(@id,'add-to-cart')]"));
//
//	            addBtn.click();
//	            break;
//	         }
//
//		}
//	}*/
//	
//	
//
///*	@Then("Cart should be updated") //Multiple items cart
//	public void cart_should_be_updated() {
//		System.out.println("Verifying cart badge...");
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		
//		WebElement cartBadge = wait.until(
//	            ExpectedConditions.presenceOfElementLocated(
//	                    By.cssSelector(".shopping_cart_badge")));
//
//	    Assert.assertTrue(cartBadge.isDisplayed());
//	    System.out.println("Cart count: " + cartBadge.getText());
//
//	    driver.quit();	
//	}*/
//
//	
//}

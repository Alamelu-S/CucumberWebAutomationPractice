package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.InventoryPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddToCartStepDefinition {

    WebDriver driver;// = Hooks.driver; // Use driver from hooks
    WebDriverWait wait;
    LoginPage loginPage;
    InventoryPage inventoryPage;
   
    @Given("User enter into login page")
    public void user_enter_into_login_page() 
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        
        /* Chrome driver initilize will take it from Hooks so commented the above lines
    	
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Login page opened");*/

    }

    @And("User enter login as {string} and {string}")
    public void user_enter_login_and(String username, String password) 
    {
    	loginPage.enterUsername(username);
    	loginPage.enterPassword(password);
    	loginPage.clickLogin();
    }

    @And("User search item {string}")
    public void user_search_item(String item) 
    {
        boolean found = inventoryPage.isItemAvailable(item);
        Assert.assertTrue(found, "Item not found: " + item);
    }

    @And("User add the item into cart")
    public void user_add_the_item_into_cart() 
    {
        // HARDCODED item
        List<WebElement> items = driver.findElements(By.className("inventory_item"));

        for (WebElement ele : items) {
            String itemName = ele.findElement(By.className("inventory_item_name")).getText();
            if (itemName.equalsIgnoreCase("Sauce Labs Backpack")) {
                ele.findElement(By.tagName("button")).click();
                break;
            }
        }
    }

    @Then("Cart should be updated")
    public void cart_should_be_updated() 
    {
        /*WebElement cartBadge = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("shopping_cart_badge")));

        Assert.assertTrue(cartBadge.isDisplayed());
        System.out.println("Cart count: " + cartBadge.getText());*/

        Assert.assertTrue(inventoryPage.isCartUpdated(), "Cart is not updated!");
        System.out.println("Cart updated successfully.");
        driver.quit();// will use this from Hooks.
    }
}

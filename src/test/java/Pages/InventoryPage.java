package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage {

	WebDriver driver;
	WebDriverWait wait;

	// Locators
	By inventoryItemsContainer = By.className("inventory_item"); // each product box
	By inventoryItemName = By.className("inventory_item_name"); // product name inside box
	By addToCartButton = By.tagName("button");
	By cartBadge = By.className("shopping_cart_badge");

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Get all product names
	public List<WebElement> getAllItems() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItemsContainer));
		return driver.findElements(inventoryItemsContainer);
	}

	public int getItemCount() {
		return getAllItems().size();
	}

//	public void printAllItems() {
//		List<WebElement> items = getAllItems();
//		System.out.println("Available Inventory Items:");
//		for (WebElement eleItem : items) {
//			System.out.println(eleItem.getText());
//		}
//	}
	public void printAllItems() {
		System.out.println("Available Inventory Items:");
		for (WebElement ele : getAllItems()) {
			System.out.println(ele.findElement(inventoryItemName).getText());
		}
	}

	// Check if an item is available
	public boolean isItemAvailable(String item) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItemsContainer));
		for (WebElement ele : getAllItems()) {
			String name = ele.findElement(inventoryItemName).getText();
			if (name.equalsIgnoreCase(item)) {
				return true;
			}
		}
		return false;
	}

	// Add item to cart by name
	public void addItemToCart(String item) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItemsContainer));
		for (WebElement ele : getAllItems()) {
			String name = ele.findElement(inventoryItemName).getText();
			if (name.equalsIgnoreCase(item)) {
				ele.findElement(addToCartButton).click();
				break;
			}
		}
	}

	// Check if cart is updated
	public boolean isCartUpdated() {
		try {
			WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
			return badge.isDisplayed() && Integer.parseInt(badge.getText()) > 0;
		} catch (Exception e) {
			return false;
		}
	}

}

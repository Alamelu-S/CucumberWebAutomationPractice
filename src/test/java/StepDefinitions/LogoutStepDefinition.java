//package StepDefinitions;
//
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class LogoutStepDefinition 
//{
//	static WebDriver driver;
//	
//	@Given("User should navigate to inventory page") 
//	public void userShouldNavigateToInventoryPage()
//	{
//	    System.out.println("Inventory Page :::");
//	    //driver.findElement(By.xpath("//button[normalize-space()='Open Menu']")).click();
//	    driver.findElement(By.tagName("button")).click();
//	}
//	@Given("User should select the dropdown list")
//	public void userShouldSelectTheDropdownList() 
//	{
//		System.out.println("Dropdown list method");
//		List<WebElement> list = driver.findElements(By.xpath("//div[@class='bm-menu']//a"));
//		System.out.println("Size of list :"+list.size());
//		for (WebElement webElement : list) 
//		{
//			System.out.println("Element "+webElement.getText());
//		}
//	    
//	}
//	@When("User click the Logout")
//	public void userClickTheLogout() {
//	    
//	}
//	@Then("User navigate to login page")
//	public void userNavigateToLoginPage() {
//	    
//	}
//
//}

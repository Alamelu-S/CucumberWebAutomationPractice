package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FileUploadStepDefinition {

	WebDriver driver = Hooks.driver; // use the same driver from Hooks

	@Given("User is on file upload page")
	public void userIsOnFileUploadPage() {
		driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
		driver.manage().window().maximize();
		System.out.println("Navigated to file upload page");
	}

	@When("User selects the file {string}")
	public void userSelectsTheFile(String filePath) {
		driver.findElement(By.id("uploadFile")).sendKeys(filePath);
		System.out.println("File selected: " + filePath);
	}

	@When("Clicks on Upload button")
	public void clicksOnUploadButton() {
		// If your page has a separate upload button, click it
		// For Tutorialspoint, the file is automatically uploaded when input sends keys
		System.out.println("Upload button clicked (if exists)");
	}

	@Then("File should be uploaded successfully")
	public void fileShouldBeUploadedSuccessfully() {
		// You can add assertion if the page shows uploaded file name
		System.out.println("File uploaded successfully (check manually or add assertion)");
	}
}

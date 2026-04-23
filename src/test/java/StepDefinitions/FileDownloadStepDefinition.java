package StepDefinitions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FileDownloadStepDefinition {

    WebDriver driver = Hooks.driver;  // Use the shared driver from Hooks

    // Folder where downloaded files will be stored
    String downloadFolder = System.getProperty("user.dir") + "/downloads";

    @Given("User is on download page")
    public void userIsOnDownloadPage() {
        // Navigate to the page
        driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Navigated to download page");
    }

    @When("User clicks the download link")
    public void userClicksTheDownloadLink() 
    {
        // Click the download link
        driver.findElement(By.id("downloadButton")).click();
        System.out.println("Download link clicked");

        // Wait a little for download to complete
        try {
            Thread.sleep(3000); // 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("File should be downloaded successfully")
    public void fileShouldBeDownloadedSuccessfully() {
        // Check if the file exists in the downloads folder
        String filePath = downloadFolder + "/Sample File to upload.txt"; // change name if different
        File file = new File(filePath);

        // Assertion
        Assert.assertTrue(file.exists(), "Downloaded file should exist at: " + filePath);
        System.out.println("File downloaded successfully: " + filePath);
    }
}

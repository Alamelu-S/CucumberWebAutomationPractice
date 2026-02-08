package StepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Hooks {

    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest scenarioTest;

    @BeforeAll
    public static void beforeAll() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Before
    public void setup(Scenario scenario) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Browser launched and ready");

        scenarioTest = extent.createTest(scenario.getName());
    }

    @After
    public void teardown(Scenario scenario) {
        // Create screenshots folder if not exists
        File screenshotDir = new File("screenshots");
        if (!screenshotDir.exists()) screenshotDir.mkdir();

        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String status = scenario.isFailed() ? "FAILED" : "PASSED";
        String screenshotName = scenario.getName().replaceAll(" ", "_") + "_" + status + ".png";
        File dest = new File("screenshots/" + screenshotName);

        try {
            FileHandler.copy(src, dest);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());

            // Attach screenshot to Extent report
            scenarioTest.addScreenCaptureFromPath(dest.getAbsolutePath());
            scenarioTest.pass("Scenario " + status);

        } catch (IOException e) {
            e.printStackTrace();
            scenarioTest.fail("Failed to save screenshot");
        }

        // Close browser
        if (driver != null) driver.quit();
        System.out.println("Browser closed");

        // Flush report after each scenario
        extent.flush();
    }
}

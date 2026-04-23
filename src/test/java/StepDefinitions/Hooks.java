package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Hooks {

    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest scenarioTest;

    // Folder paths
    public static String downloadFolder = System.getProperty("user.dir") + "/downloads";
    public static String screenshotFolder = System.getProperty("user.dir") + "/screenshots";

    @BeforeAll
    public static void beforeAll() {
        // Initialize ExtentReports once
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        // Ensure downloads and screenshots folders exist
        new File(downloadFolder).mkdirs();
        new File(screenshotFolder).mkdirs();
    }

    @Before
    public void setup(Scenario scenario) {
        // Chrome options for automatic download
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFolder);
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);

        // Clean old downloads (optional)
        File folder = new File(downloadFolder);
        for (File file : folder.listFiles()) {
            file.delete();
        }

        // Initialize driver
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Browser launched and ready for scenario: " + scenario.getName());

        // Initialize ExtentTest for scenario
        scenarioTest = extent.createTest(scenario.getName());
    }

    @After
    public void teardown(Scenario scenario) {
        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String status = scenario.isFailed() ? "FAILED" : "PASSED";
        String screenshotName = scenario.getName().replaceAll(" ", "_") + "_" + status + ".png";
        File dest = new File(screenshotFolder + "/" + screenshotName);

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
        System.out.println("Browser closed for scenario: " + scenario.getName());

        // Flush ExtentReports after each scenario
        extent.flush();
    }
}

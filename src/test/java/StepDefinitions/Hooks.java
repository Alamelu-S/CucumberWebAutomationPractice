package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver; // Make it static if you want to use across steps

    @Before
    public void setup() {
        // This will run before every scenario
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Browser launched and ready");
    }

    @After
    public void teardown(Scenario scenario) {
        // This will run after every scenario
        if (scenario.isFailed()) {
            System.out.println("Scenario failed: " + scenario.getName());
            // You can take screenshot here if needed
        }
        driver.quit();
        System.out.println("Browser closed");
    }
}

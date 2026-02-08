package TestRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
features = {"src/test/resources/Features/login.feature"},
glue = {"StepDefinitions"},
snippets = SnippetType.CAMELCASE,
monochrome = true,

tags = "not @skip", //If any tags @skip then it will skip that execution
//plugin = {"pretty","html:target/htmlreport.html"}

plugin = {"pretty",
		"html:target/cucumber-reports/reports.html",
		"json:target/cucumber-reports/cucumber.json"  // generate JSON for advanced reporting
		},

//dryRun = true // Its a mode that will give missing step defintion from Feature 
dryRun = false // dryRun - If its false then only the program will execute and screenshot / brower will be open
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests{

}

package TestRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(tags="",features = {"src/test/resources/Features/login.feature"},
glue = {"StepDefinitions"},
snippets = SnippetType.CAMELCASE,
monochrome = true,
//plugin = {"pretty","html:target/htmlreport.html"}
plugin = {"pretty",
		"html:target/cucumber-reports/reports.html"}
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests{

}

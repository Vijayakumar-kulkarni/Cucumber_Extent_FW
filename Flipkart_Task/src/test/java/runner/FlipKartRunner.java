package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue= {"stepdefinitions", "hooks"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		publish = true,
		dryRun = false,
		snippets = SnippetType.CAMELCASE,
		monochrome = true
		)
public class FlipKartRunner extends AbstractTestNGCucumberTests{
	
}

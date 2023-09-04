package hooks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ScreenshotManager;

public class ApplicationHooks {
	TestContext testContext;
	WebDriver driver;

	public ApplicationHooks(TestContext context) {
		this.testContext = context;
		this.driver = testContext.getWebDriverManager().getDriver();
	}
	
	@Before
	public void launchApplication() {
		driver.get("https://www.flipkart.com/");
	}
	
	@After
	public void windUp(Scenario scenario) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*if condition has been commented out to take the screenshot for the TC even if that is passed
		 if we need the screenshots only for failed scenario then we need to uncomment this */
		
//		if(scenario.isFailed()) {
			ScreenshotManager.saveScreenshots(driver, scenario);
			ScreenshotManager.attachScreenshot(driver, scenario);
//		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		testContext.getWebDriverManager().closeDriver();
	}
}

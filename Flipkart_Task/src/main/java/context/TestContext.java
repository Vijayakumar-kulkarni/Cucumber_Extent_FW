package context;

import org.openqa.selenium.WebDriver;

import utilities.DriverManager;
import utilities.PageObjectManager;
/* This is the class of whose instance the cucumber will inject through picocontainer's
 * Constructor Injection approach through which the state of the object will be shared
 * among the different step definition files*/

public class TestContext {
	private DriverManager driverManager;
	private PageObjectManager pageObjectManager;
	private WebDriver driver;
	private ScenarioContext scenarioContext;
	
	public TestContext(){
		driverManager = new DriverManager();
		driver = driverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		scenarioContext = new ScenarioContext();
	}
	
	public DriverManager getWebDriverManager() {
		return driverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

}

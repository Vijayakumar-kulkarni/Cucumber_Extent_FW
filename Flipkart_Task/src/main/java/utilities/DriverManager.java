package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverManager {
	private WebDriver driver;
	private String browserName;

	public DriverManager() {
		browserName = new ConfigFileReader().getBrowserName();
	}
	public WebDriver getDriver() {
		if(driver == null) 
		{
			 switch (browserName) {	    
		        case "firefox" : 
		        	WebDriverManager.firefoxdriver().setup();
		        	driver = new FirefoxDriver();
			    	break;
		        case "chrome" : 
//		        	System.setProperty(CHROME_DRIVER_PROPERTY, "Path to driver file");
//		        	driver = new ChromeDriver();
		        	WebDriverManager.chromedriver().setup();
		        	driver = new ChromeDriver();
		    		break;
		        case "ie" : 
		        	WebDriverManager.iedriver().setup();
		        	driver = new InternetExplorerDriver();
		    		break;
		    	default:
		    		
		        }
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public void closeDriver() {
		//driver.close();
		if(driver!=null)
			driver.quit();
	}
}

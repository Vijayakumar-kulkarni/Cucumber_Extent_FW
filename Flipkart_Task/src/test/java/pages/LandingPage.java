package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	private WebDriver driver;
	private By productSearchBox = By.className("_3704LK");
	private By searchBtn = By.className("L0Z3Pu");
	private By newLookPopup = By.xpath("//span[text()='Liked the new design ?']");
	private By listOfProducts = By.xpath("//div[contains(text(),'Nothing Phone (1) ')]");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getCurrentURL() {
		//getting the current url
		return driver.getCurrentUrl();
	}
	public void searchProduct(String productName) {
		try {
			WebElement ele = driver.findElement(newLookPopup);
			productSearchBox = By.xpath("//div//input[@class='Pke_EE']");
			searchBtn = By.xpath("//div//button[@class='_2iLD__']");
		}catch(Exception e) {
//			System.out.println("Use old locators");
		}
		
		driver.findElement(productSearchBox).sendKeys(productName);
		driver.findElement(searchBtn).click();	
		
		productSearchBox = By.className("_3704LK");
		searchBtn = By.className("L0Z3Pu");
	}

	public void clickFirstMatchingProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfProducts));
		driver.findElement(listOfProducts).click();	
		
	}
	public void clearLoginPopupWindow() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).build().perform();
	}

}

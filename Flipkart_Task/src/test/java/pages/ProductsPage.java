package pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
	private WebDriver driver;
	private By listOfProducts = By.xpath("//div[contains(text(),'Nothing Phone')]");
	private By firstProductName = By.xpath("(//div[@class='_4rR01T'])[1]");
	private By productPrice = By.xpath("(//div[@class='_30jeq3 _1_WHN1'])[1]");
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickFirstMatchingProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfProducts));
		driver.findElement(listOfProducts).click();	
		
	}
	public Map<String, String> getDetailsOfTheFirstProduct() {
		HashMap<String, String> productDetails = new HashMap<>();
		productDetails.put("productName", driver.findElement(firstProductName).getText());
		productDetails.put("price", driver.findElement(productPrice).getText());
		
		return productDetails;
	}
	
}

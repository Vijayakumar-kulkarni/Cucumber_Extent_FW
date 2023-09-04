package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	private WebDriver driver;
	private By productName = By.xpath("//div//a[@class='_2Kn22P gBNbID']");
	private By price = By.xpath("//div//a[@class='_2Kn22P gBNbID']/parent::div/following-sibling::span[@class='_2-ut7f _1WpvJ7']");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public Map<String, String> getProductDetailsFromCartPage(){
		
		HashMap<String, String> productDetails = new HashMap<>();
		productDetails.put("productName", driver.findElement(productName).getText());
		productDetails.put("price", driver.findElement(price).getText());
		
		return productDetails;
	}
	
}

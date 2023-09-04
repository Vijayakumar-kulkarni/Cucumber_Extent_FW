package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
	private WebDriver driver;
	private By productName = By.xpath("//span[@class='B_NuCI']");
	private By price = By.xpath("//div[@class='_30jeq3 _16Jk6d']");
	private By addToCartBtn = By.xpath("//div//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	public Map<String, String> getDetailsOfTheSelectedProduct() {
		HashMap<String, String> productDetails = new HashMap<>();
		productDetails.put("productName", driver.findElement(productName).getText());
		productDetails.put("price", driver.findElement(price).getText());
		
		return productDetails;
	}
	public boolean isButtonClickable() {
		return driver.findElement(addToCartBtn).isEnabled();
	}
	public void addToCart() {
		driver.findElement(addToCartBtn).click();
	}
	 
}

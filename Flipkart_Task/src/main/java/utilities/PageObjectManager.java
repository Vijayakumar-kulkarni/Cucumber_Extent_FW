package utilities;

import java.lang.reflect.Constructor;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	private WebDriver driver;
	private Object pageObject;
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public Object getPageObject(@SuppressWarnings("rawtypes") Class class1) {
		@SuppressWarnings("rawtypes")
		Constructor c;
		try {
			c = Class.forName(class1.getName()).getConstructor(WebDriver.class);
			pageObject = c.newInstance(driver);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return pageObject;
	}
}

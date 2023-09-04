package stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
/*  Step definition file for the respective steps defined in Feature files */

public class AddProductStepDefs {
	TestContext context;
	LandingPage landingPage;
	ProductsPage productsPage;
	ProductDetailsPage productDetailsPage;
	Map<String, String> details = new LinkedHashMap<String, String>();
	
	/* Passing TestContext object through constructor and pico container will inject the instances */
	public AddProductStepDefs(TestContext context) {
		this.context = context;
		landingPage = (LandingPage) context.getPageObjectManager().getPageObject(LandingPage.class);
		productsPage = (ProductsPage) context.getPageObjectManager().getPageObject(ProductsPage.class);
		productDetailsPage = (ProductDetailsPage) context.getPageObjectManager().getPageObject(ProductDetailsPage.class);
	}
	
	@Given("I am on page {string}")
	public void iAmOnPage(String landingPageUrl) {
		landingPage.clearLoginPopupWindow();
	    String currentUrl = landingPage.getCurrentURL();
	    Assert.assertEquals(currentUrl, landingPageUrl);
	}
	
	@When("I search for the product {string}")
	public void iSearchForTheProduct(String productName) {
	    landingPage.searchProduct(productName);
	}
	
	@When("I click on first product in the search result")
	public void iClickOnFirstProductInTheSearchResult() {
		details = productsPage.getDetailsOfTheFirstProduct();
		context.getScenarioContext().setContext("productName", details.get("productName"));
		context.getScenarioContext().setContext("price", details.get("price"));
		productsPage.clickFirstMatchingProduct();
	}
	
	@Then("I verify the product details")
	public void iVerifyTheProductDetails() {
		 String parentWindow = context.getWebDriverManager().getDriver().getWindowHandle();
		 Set<String> windowHandles = context.getWebDriverManager().getDriver().getWindowHandles();
	     Iterator<String> itr = windowHandles.iterator();
	     while(itr.hasNext()) {
	    	 String childWindow = itr.next();
	    	 if(!childWindow.equalsIgnoreCase(parentWindow)) {
	    		 context.getWebDriverManager().getDriver().switchTo().window(childWindow);
	    	 }
	     }
		 details = productDetailsPage.getDetailsOfTheSelectedProduct();
	     Assert.assertTrue(context.getScenarioContext().getContext("productName").
	    		 equalsIgnoreCase(details.get("productName"))||details.get("productName").
	    		 contains(context.getScenarioContext().getContext("productName")) );
	     Assert.assertEquals(context.getScenarioContext().getContext("price"), details.get("price"));
	}
	
	@When("I click on Add To Cart button")
	public void iClickOnAddToCartButton() {
		Assert.assertTrue(productDetailsPage.isButtonClickable());
	    productDetailsPage.addToCart();
	}
	
	@Then("I verify the product in the cart")
	public void iVerifyTheProductCartPage() {
		 details = productDetailsPage.getDetailsOfTheSelectedProduct();
	     Assert.assertTrue(context.getScenarioContext().getContext("productName").equalsIgnoreCase(details.get("productName"))||
	    		details.get("productName").contains(context.getScenarioContext().getContext("productName")) );
	     Assert.assertEquals(context.getScenarioContext().getContext("price"), details.get("price"));
	}
}

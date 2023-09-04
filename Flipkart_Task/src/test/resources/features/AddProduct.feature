Feature: Add Product to Cart
  
@first    
 Scenario Outline: Serach the given product and add it to cart
 		Given I am on page "https://www.flipkart.com/"
 		When I search for the product <productName>
 		When I click on first product in the search result
 		Then I verify the product details
 		And I click on Add To Cart button
 		Then I verify the product in the cart
 		
 		Examples:
		|productName|
		|'Nothing phone 1'|
#		|'Nothing phone 2'|
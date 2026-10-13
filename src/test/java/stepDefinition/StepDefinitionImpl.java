package stepDefinition;

import org.testng.Assert;

import Courses.SeleniumFrame.CartPage;
import Courses.SeleniumFrame.CheckoutPage;
import Courses.SeleniumFrame.ConfirmPage;
import Courses.SeleniumFrame.LoginScreen;
import Courses.SeleniumFrame.ProductListing;
import TestBase.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{
	
	public LoginScreen logscreen;
	public ProductListing productCatalog ;
	public CartPage caRt;
	public ConfirmPage confmsg;
	
	
	@Given("landed on Ecommerce page")
	public void landed_on_ecommerce_page() throws Exception {
	    driver = initBrowser();
	    logscreen = new LoginScreen(driver);
	    logscreen.getUrl();
	}
	
	@Given("logged in with username {string} and password {string}")
	public void logged_in_with_username_and_password(String user, String pwd) {
	    productCatalog = logscreen.LoginCred(user, pwd);
	}

	@When("add product {string} to cart")
	public void add_product_to_cart(String prodName) {
	    caRt = productCatalog.cartBut(prodName);
	}

	@When("checkout {string} and submit to order")
	public void checkout_and_submit_to_order(String prodName) {
	    Boolean check = caRt.cartPn(prodName);
	    Assert.assertTrue(check, "Product not found in cart: " + prodName);

	    CheckoutPage chpage = caRt.checkButton();
	    chpage.country("India");
	    chpage.select.click();

	    confmsg = chpage.sumbitOrd();
	}

	@Then("{string} message displayed on confirmation page")
	public void message_displayed_on_confirmation_page(String expectedMessage) {
	    String actualMessage = confmsg.Confirmation();
	    Assert.assertEquals(actualMessage.trim(), expectedMessage.trim());
	    driver.close();
	}
	
	@Then ("{string} message displayed on Login page")
	public void message_displayed_on_Login_page(String string) {
		Assert.assertEquals(string, logscreen.ErrorMsg());
		driver.close();
	}

}
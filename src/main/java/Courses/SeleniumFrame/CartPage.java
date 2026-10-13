package Courses.SeleniumFrame;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Courses.SeleniumFrame.testPages.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css="div[class='cartSection'] h3")
	List <WebElement> cartProduct; 
	
	@FindBy(css="li[class='totalRow'] button")
	WebElement checkout; 
	
	public  Boolean cartPn(String productName){
		Boolean check = cartProduct.stream().anyMatch(c->c.getText().equalsIgnoreCase(productName));
		return check;
	}
	
	public CheckoutPage checkButton() {
		checkout.click();
		CheckoutPage chpage = new CheckoutPage(driver);// action class
		return chpage;
	}
}

package Courses.SeleniumFrame;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import Courses.SeleniumFrame.testPages.AbstractComponent;

public class ProductListing extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductListing(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css=".mb-3")
	List <WebElement> products; 
	
	By productBy = By.cssSelector(".mb-3");
	
	By card = By.cssSelector(".card-body button:last-of-type");
	
	By toast = By.cssSelector("#toast-container");
	
	//By loadWheel = By.cssSelector(".ng-animating");
	
	@FindBy(css="button[routerlink*=\"cart\"]")
	WebElement cartButton;
	
	@FindBy(css=".ng-animating")
	WebElement loadWheel;
	
	public  List<WebElement> getPnList(){
		WaitElementToCall(productBy);
		return products;
	}
	
	public WebElement getProductsbyName(String productName) {
		
		WebElement prod = getPnList().stream().filter(p->p.findElement(By.cssSelector("b"))
			.getText().equals(productName)).findFirst().orElse(null);	
		return prod;
	}	
	
	public CartPage cartBut(String productName) {
		
		WebElement item = getProductsbyName(productName);
		item.findElement(card).click();
		WaitElementToCall(toast);
		WaitElementNovis(loadWheel);
		cartButton.click();
		CartPage caRt = new CartPage(driver);
		return caRt;
	}
	
}

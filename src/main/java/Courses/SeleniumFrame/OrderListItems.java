package Courses.SeleniumFrame;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Courses.SeleniumFrame.testPages.AbstractComponent;

public class OrderListItems extends AbstractComponent{
	
	WebDriver driver;
	
	public OrderListItems(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(css="tr td:nth-child(3)")
	List <WebElement> productNames ; 
	
	public  Boolean Orderitempn(String productName){
		Boolean itemOrder = productNames.stream().anyMatch(c->c.getText().equalsIgnoreCase(productName));
		return itemOrder;
	}

}

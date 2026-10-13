package Courses.SeleniumFrame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Courses.SeleniumFrame.testPages.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement selectCoun; 
	
	@FindBy(xpath ="//button[@class='ta-item list-group-item ng-star-inserted'][2]")
	public
	WebElement select; 
	
	@FindBy(css="a[class*='action__submit")
	WebElement submit; 
	
	public void country(String Country) {
		
		Actions a = new Actions(driver);
		a.sendKeys(selectCoun, Country).build().perform();	
		
	}
	
	public ConfirmPage sumbitOrd() {
		submit.click();
		ConfirmPage confmsg = new ConfirmPage(driver);
		return confmsg;
	}
	
}
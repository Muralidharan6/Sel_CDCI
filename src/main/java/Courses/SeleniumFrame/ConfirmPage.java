package Courses.SeleniumFrame;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Courses.SeleniumFrame.testPages.AbstractComponent;

public class ConfirmPage extends AbstractComponent{
	
	WebDriver driver;
	
	public ConfirmPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css="h1[class='hero-primary']")
	WebElement message; 
	
	public String Confirmation() {
		String confirmsg = message.getText();
		return confirmsg;
	}
	

}

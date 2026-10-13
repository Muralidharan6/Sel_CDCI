package Courses.SeleniumFrame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Courses.SeleniumFrame.testPages.AbstractComponent;

public class LoginScreen extends AbstractComponent {

	WebDriver driver;
	
	public LoginScreen(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
			
	//Page factory
	
	@FindBy(id = "userEmail")
	WebElement username;
	
	@FindBy(id = "userPassword")
	WebElement password;
	
	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errormsg;
	
	public ProductListing LoginCred(String usernm, String paswd) {
		username.sendKeys(usernm);
		password.sendKeys(paswd);
		submit.click();		
		ProductListing productCatalog = new ProductListing(driver);
		return productCatalog;
	}
	
	public String ErrorMsg() {
		
		WaitElementToAppear(errormsg);
		return errormsg.getText();
		
	}
	
	public void getUrl() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}

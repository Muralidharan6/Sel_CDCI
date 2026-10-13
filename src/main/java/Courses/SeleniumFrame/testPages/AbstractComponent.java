package Courses.SeleniumFrame.testPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Courses.SeleniumFrame.OrderListItems;

public class AbstractComponent {

	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}

	@FindBy(css="[routerlink*='myorders']")
	WebElement orderButton;
	
	public OrderListItems gotoOrderPage() {
		orderButton.click();
		OrderListItems ord = new OrderListItems(driver);
		return ord;
	}
	
	public void WaitElementToCall(By toast) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(toast));		
	}
	
	public void WaitElementNovis(WebElement loadWheel) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(loadWheel));	
	}
	
	public void WaitElementToAppear(WebElement errormsg) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(errormsg));	
	}
}

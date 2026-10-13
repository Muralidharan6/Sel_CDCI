package Courses.SeleniumFrame;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import TestBase.Retry;

import TestBase.BaseTest;

public class UIErrorValidation extends BaseTest {
	
	@Test(groups = {"LoginError"},retryAnalyzer =Retry.class)
	
	public void ErrorValudation() throws IOException, InterruptedException {
	
	LoginScreen logscreen= new LoginScreen(driver);
	logscreen.getUrl();
	logscreen.LoginCred("testuser1269@gmail.com", "Kannan@123");
	System.out.println(logscreen.ErrorMsg());
	Assert.assertEquals("Incorrect email password.", logscreen.ErrorMsg());
	}
	
	@Test
	
	public void cartProduct() throws IOException {
		
		String reqPn = "ZARA COAT 3";
		
		LoginScreen logscreen= new LoginScreen(driver);
		logscreen.getUrl();
		ProductListing productCatalog = logscreen.LoginCred("testuser1269@gmail.com", "Kannan@123");
		List<WebElement> products = productCatalog.getPnList();
		CartPage caRt = productCatalog.cartBut(reqPn);// auto
		Boolean check = caRt.cartPn(reqPn);
		Assert.assertTrue(check);
	}

}

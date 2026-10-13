package Courses.SeleniumFrame;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestBase.BaseTest;

public class EndTo extends BaseTest{
	String reqPn = "ZARA COAT 3";
	
	@Test(dataProvider = "getData",groups = {"Purchase_Order"})
	public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		
		
		LoginScreen logscreen= new LoginScreen(driver);
		logscreen.getUrl();
		ProductListing productCatalog = logscreen.LoginCred(input.get("name"), input.get("password"));
		List<WebElement> products = productCatalog.getPnList();
		CartPage caRt = productCatalog.cartBut(input.get("reqPn"));// auto
		Boolean check = caRt.cartPn(input.get("reqPn"));
		Assert.assertTrue(check);
		CheckoutPage chpage = caRt.checkButton();
		chpage.country("India");
		chpage.select.click();
		ConfirmPage confmsg = chpage.sumbitOrd();
		String message = confmsg.Confirmation();
		System.out.println(message);
		Assert.assertTrue(message.equalsIgnoreCase(message));
	}
	
	@Test(dependsOnMethods={"SubmitOrder"}) ////adding the dependency so that once submit order execute first, then only this method will invoke
	public void OrderList() throws Exception {
		
		LoginScreen logscreen= new LoginScreen(driver);
		logscreen.getUrl();
		ProductListing productCatalog = logscreen.LoginCred("testuser1269@gmail.com", "Kannan@123");
		OrderListItems ord = productCatalog.gotoOrderPage();
		System.out.println(ord.Orderitempn(reqPn));
		Assert.assertTrue(ord.Orderitempn(reqPn));
		
		}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+ "//src//test//java//TestData//PurchaseOrderData.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	
		
//	public void SubmitOrder(String name,String password, String reqPn) throws IOException, InterruptedException {
//	public Object[][] getData() {	
//		return new Object[][] {{"testuser1269@gmail.com", "Kannan@123","ZARA COAT 3"},{"google@test.com","Admin123","ADIDAS ORIGINAL"}};
//	}
	
	
	
//	@DataProvider
//	public Object[][] getData() {
//		
//		HashMap<String, String> map= new HashMap<String, String>();
//		map.put("name", "testuser1269@gmail.com");
//		map.put("password", "Kannan@123");
//		map.put("reqPn", "ZARA COAT 3");
//		
//		HashMap<String, String> map1= new HashMap<String, String>();
//		map1.put("name", "google@test.com");
//		map1.put("password", "Admin123");
//		map1.put("reqPn", "ADIDAS ORIGINAL");
//		
//		return new Object[][] {{map},{map1}};
//	}

}

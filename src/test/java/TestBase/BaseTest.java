package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Courses.SeleniumFrame.LoginScreen;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LoginScreen loginSc;

	public WebDriver initBrowser() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Resourses//GlobalData.properties");
		prop.load(file);
		
		//String browserName = prop.getProperty("browser");
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.contains("Chrome"))
		{	
			ChromeOptions option = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) 
			{
			option.addArguments("headless");
			}
			 driver = new ChromeDriver(option);
			 driver.manage().window().setSize(new Dimension(1440,900));
		}
		
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();	
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();	
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
		
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath));
		
		//	String to Hashmap  and also adding Jackson databid
			
		ObjectMapper object = new ObjectMapper();
		List<HashMap<String,String>> data = object.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>( ){});
		
		return data;
	}
	
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot scnshot = (TakesScreenshot)driver;
		File source = scnshot.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";

	}
	
	@BeforeMethod(alwaysRun = true)
	public LoginScreen launchApp() throws IOException {
		 driver = initBrowser();
		 LoginScreen logscreen= new LoginScreen(driver);
			logscreen.getUrl();
		return logscreen;
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}

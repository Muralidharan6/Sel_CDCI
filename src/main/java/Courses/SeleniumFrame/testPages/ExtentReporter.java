package Courses.SeleniumFrame.testPages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter  {
	
	public static ExtentReports getReport() {
		String path = System.getProperty("user.dir") + "\\report\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("Test_case");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Murali");
		extent.createTest(path);
		return extent;
	}

}

package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/Cucumber",
	    glue = "stepDefinition",
	    monochrome = true,
	    //tags = "Regression",/// to select the particular cucumber 
	    plugin= {"html:report/cucumber.html"}
	)

public class TestNGRunner extends AbstractTestNGCucumberTests {

}

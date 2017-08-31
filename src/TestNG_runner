package test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Please notice that cucumber.examples.java.testNG.stepDefinitions.BeforeAfterHooks class
 * is in the same package as the steps definitions.
 * It has two methods that are executed before or after scenario.
 * I'm using it to delete cookies and take a screenshot if scenario fails.
 */
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        format = {"pretty",
                "html:target/cucumber-report/firefox"},
		tags= {"@smoke"}
        )
public class Runnerclass extends AbstractTestNGCucumberTests {
}

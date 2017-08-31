package test;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		tags =("@smoke"), 
		features ={"Features"},
		glue={"stepDefination/Registration.java"},
		plugin= {"Pretty","html:Report"},
		strict = false,
		dryRun= true,
		monochrome= true
		)

public class Runnerclass {

}

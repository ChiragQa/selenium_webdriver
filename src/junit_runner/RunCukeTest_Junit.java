package stepDefination;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Feature",
        glue = "stepDefination",
        plugin = { 
                    "pretty",
                    "html:target/cucumber",          
                },
        tags={"@smoke"}
        )
public class RunCukeTest_Junit {
}

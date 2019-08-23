package skeleton;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="CS_Feature",
glue = "caseStudy_TestMe",tags = {"@Sanity"},
plugin = {"html:target/cucumber-htmlreport.html","json:target/cucumber.json"})


public class runner_case {

}

package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		          
		           // features={".//Features/"},
		             features={".//Features/Login.feature"},
		          // features= {".//Features/LoginData.feature"},
		          //features= {".//features/Login2exceldata.feature"},
		           ///features={"@target/rerun.txt"},
		            glue="stepDefinations",
		            plugin= {"pretty","html:reports/myreport.html",
		            		"rerun:target/rerun.txt"},// T o capture failures
		            dryRun=false,
		           //tags="@Smoke" // This will execute scenario with tags Sanity only.
		           //tags="@Sanity and @Smoke"// To execute Scenario with both Sanity and Regression
		           tags="@Sanity and not @Smoke"// To execute sanity but not regression
		          // tags="@Sanity or @Regression" To execute Sanity or Regression
		        )

public class TestRunner {

}

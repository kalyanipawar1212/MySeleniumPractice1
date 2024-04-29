package TestRunner2;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = (".//Featuress/cucumber.feature"),
		//features = (".//Featuress/"),				//All feature files will execute
		// features = {".//Featuress/cucumber.feature",".//Featuress/loginMethod.feature"},			//Any 2 feature files will execute
		glue={"StepDef2"},
		dryRun=false,
		monochrome=true,
		tags="@Sanity",      //Scenarios under @Sanity tab will be executed. Does not matter if it has other tags as well
		//tag="@Sanity or @regression" 	,	// will run scenario tagged with sanity or regression
		//tag="@Sanity and @regression" ,		// will run scenario tagged with sanity as well as regression
		//tags="@Sanity and not @Regression",		//will run scenario which is tagged with Sanity but not Regression
		
		
				
		//plugin= {"pretty","html:target/cucumber-reports/reports1.html"}
		
		//plugin= {"pretty","html:target/cucumber-reports/reports1.html"}
		//"junit:target/cucumber-reports/reports_xml.xml"
		//plugin= {"pretty","json:target/cucumber-reports/reports_json.json"}
		
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class TestRunner2 
{
	/* 
	  * This class will be empty
	  * throws ExceptionInInitializerError
	  */

}

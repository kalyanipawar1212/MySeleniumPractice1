package StepDef2;

import io.cucumber.java.en.Then;

public class closeSteps extends BaseClass
{

	@Then("close browser")
	public void close_browser() 
	{
		driver.close();
		//driver.quit();
	}
}

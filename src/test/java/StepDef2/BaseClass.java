package StepDef2;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject2.AddNewCustomerPage;
import PageObject2.LoginPage2;
import PageObject2.SearchCustomerPage;

//This will be Parent class. Step def files will be its child class
public class BaseClass 
{

	public static WebDriver driver;
	public LoginPage2 loginPg;
	public AddNewCustomerPage addNewCustpg;
	public SearchCustomerPage SearchCustpg;
	
	//generate unique email address
	public String generateEmailID()
	{
		return RandomStringUtils.randomAlphabetic(5);
	}
	
}

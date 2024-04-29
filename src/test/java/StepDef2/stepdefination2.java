package StepDef2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import PageObject2.AddNewCustomerPage;
import PageObject2.LoginPage2;
import PageObject2.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;


public class stepdefination2 extends BaseClass			//Child class of Base class
{
	@Before
    public void steup()
    {
		System.out.println("Setup method is executed");
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user")+"C://Users//prati//Downloads//edgedriver_win64 (1)//msedgedriver.exe");
		//WebDriverManger.chromedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
    }
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() 
	{
		
	    loginPg=new LoginPage2(driver); 
	    addNewCustpg = new AddNewCustomerPage(driver);
	    SearchCustpg = new SearchCustomerPage(driver);
	    
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) 
	{
		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) 
	{
		
		loginPg.enterEmail(email);
		loginPg.enterPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() 
	{
		loginPg.clickOnLoginButton();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedtitle) throws Throwable 
	{
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle); 
		if(actualTitle.equals(expectedtitle))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws Throwable 
	{
		Thread.sleep(1000);
		loginPg.clickOnLogoutButton();  
	}

	/*@Then("close browser")
	public void close_browser() 
	{
		driver.close();
		//driver.quit();
	}*/
	

	
	
	
	
	///////////////////////////////////Add new customer /////////////////////////////////////////////////////
	
	
	@Then("User can view Dashborad")
	public void user_can_view_dashborad() 
	{
	    String actualTitle=addNewCustpg.getPageTitle();
	    String expectedTitle="Dashboard / nopCommerce administration";
	    if(actualTitle.equals(expectedTitle))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}

	@When("User click on customer Menu")
	public void user_click_on_customer_menu() 
	{
	    addNewCustpg.clickOnCustomerMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() 
	{
		addNewCustpg.clickOnCustomerMenuItem();
		SearchCustpg.clickOnCustomerMenuItem();
	}

	@When("click in Add new button")
	public void click_in_add_new_button() 
	{
		addNewCustpg.clickOnAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() throws Throwable 
	{
		Thread.sleep(2000);
		String actualTitle=addNewCustpg.getPageTitle();
		System.out.println(actualTitle);
	    String expectedTitle="Add a new customer / nopCommerce administration";
	    if(actualTitle.equals(expectedTitle))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}

	@When("User enter customer info")
	public void user_enter_customer_info() 
	{
		//addNewCustpg.enterEmail("test1@gmail.com");
		addNewCustpg.enterEmail(generateEmailID() + "@gmail.com");
		addNewCustpg.enterPassword("test1");
		addNewCustpg.enterFirstName("Kalyani");
		addNewCustpg.enterLastName("Pawar");
		addNewCustpg.enterGender("Female");
		addNewCustpg.enterDob("12/12/1996");
		addNewCustpg.enterCompanyName("Accenture");
		//addNewCustpg.enterManagerOfVendor("Manager");
		addNewCustpg.enterAdminContent("Admin content");
		
	}

	@When("click on save button")
	public void click_on_save_button() 
	{
		addNewCustpg.clickOnSave();
	}

	@Then("User can view confirmarion message {string}")
	public void user_can_view_confirmarion_message(String expected) 
	{
		String bodyTag=driver.findElement(By.tagName("Body")).getText();
	    
	    if(bodyTag.contains(expected))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}

///////////////////////////////////Search by Name////////////////////////////////////////////////////////////////
	

	
	@When("Enter cuctomer Email")
	public void enter_cuctomer_email() 
	{
		SearchCustpg.enterEmailadd("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() 
	{
		SearchCustpg.clickOnSearchBtn();
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() 
	{
	    String expectedEmail="victoria_victoria@nopCommerce.com";
	    Assert.assertTrue(SearchCustpg.searchCustomerByEmail(expectedEmail));
	    
	}

	
	
	//////////////////////////////Search by Name////////////////////////////////////////
	@When("Enter cuctomer FirstName")
	public void enter_cuctomer_first_name() 
	{
		SearchCustpg.enterFirstName("Victoria");
	}

	@When("Enter cuctomer LastName")
	public void enter_cuctomer_last_name() 
	{
		SearchCustpg.enterLastName("Terces");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() 
	{
		String expectedName="Victoria Terces";
	    if(SearchCustpg.searchCustomerByName(expectedName)==true)
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}

	
	//@After
	public void teardown(Scenario sc)
	{
		System.out.println("Tear down method executed");
		if(sc.isFailed()==true)
		{
			String fileWithPath ="C://Users//prati//eclipse-workspace//MySeleniumPractice//"+ "Screenshots";
			TakesScreenshot scrShot=((TakesScreenshot)driver);
			File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
			//move image file to new destination
			File DestinationFile=new File(fileWithPath);
			// Now you can do whatever you need to do with it, for example copy somewhere
			try {
				FileUtils.copyFile(scrFile, DestinationFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
				{
			final byte[] screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
				}
		
	}

	

}

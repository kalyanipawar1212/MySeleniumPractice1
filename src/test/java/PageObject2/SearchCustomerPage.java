package PageObject2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage 
{

WebDriver localdriver;
	
	public SearchCustomerPage(WebDriver rDriver)
	{
		localdriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id="SearchEmail")
	WebElement emailAdd;
	
	@FindBy(id="search-customers")
	WebElement searchBtn;
	
	@FindBy(xpath="//table[@role='grid']")
	WebElement serachResult;
	
	@FindBy(xpath="//table[@id='customer-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	//@FindBy(xpath="//table[@id='customer-grid']//tbody/tr[1]/td")
	//List<WebElement> tableCoulmn;
	
	@FindBy(id="SearchFirstName")
	WebElement firstName;
	
	@FindBy(id="SearchLastName")
	WebElement lastName;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement Customer_menuItem;
	
	
	//action method to enter email address
	public void enterEmailadd(String email)
	{
		emailAdd.sendKeys(email);
	}
	
	public void clickOnSearchBtn()
	{
		emailAdd.click();
	}
	public void clickOnCustomerMenuItem()
	{
		Customer_menuItem.click();
	}
	
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean found = false;
		
		//total no. of rows
		int ttlRows =tableRows.size();
		//total no. of columns
		//int ttlColumns =tableCoulmn.size();
		for(int i=1;i<=ttlRows;i++)
		{
			WebElement webElementEmail=localdriver.findElement(By.xpath("//table[@id='customer-grid']//tbody/tr[1]/td"));
			String actualEmailAdd = webElementEmail.getText();
			
			if(actualEmailAdd.equals(email))
			{
				found=true;
			}
			
		}
		return found;
	}
	//////////////////////////////////////Search customer by Name////////////////////////////////////////////////
	public void enterFirstName(String firstNameText)
	{
		firstName.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText)
	{
		lastName.sendKeys(lastNameText);
	}
	
	public boolean searchCustomerByName(String name)
	{
		boolean found = false;
		
		//total no. of rows
		int ttlRows =tableRows.size();
		//total no. of columns
		//int ttlColumns =tableCoulmn.size();
		for(int i=1;i<=ttlRows;i++)
		{
			WebElement webElementName=localdriver.findElement(By.xpath("//table[@id='customer-grid']//tbody/tr[" + i + "]/td[3]"));
			String actualName= webElementName.getText();
			
			if(actualName.equals(name))
			{
				found=true;
				break;
			}
			
		}
		return found;
	}
	
}

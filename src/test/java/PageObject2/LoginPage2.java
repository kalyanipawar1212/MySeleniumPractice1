package PageObject2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 
{
WebDriver localdriver;
	
	public LoginPage2(WebDriver rDriver)
	{
		localdriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//*[@class='button-1 login-button']")
	WebElement LoginBtn;
	
	@FindBy(linkText="Logout")
	WebElement Logout;
	
	public void enterEmail(String emailAddress)
	{
		email.clear();
		email.sendKeys(emailAddress);
	}
	
	public void enterPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginButton()
	{
		LoginBtn.click();
	}
	
	public void clickOnLogoutButton()
	{
		Logout.click();
	}
	

}

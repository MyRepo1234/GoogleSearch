package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 public WebDriver driver;
	
	
	@FindBy(xpath="//input[@id='user_email']")
	private WebElement emailAddressTextbox;
	@FindBy(xpath="//input[@id='user_password']")
	private WebElement passwordTextbox;
	@FindBy(xpath="//input[@name='commit']")
	private WebElement loginButton;
	@FindBy(css="[href*='password/new']")
	private WebElement forgotPassword;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}

	public WebElement getEmail()
	{
		System.out.println("Enter the emailid in the textbox");
		return emailAddressTextbox;
		
	}
	public WebElement getPassword()
	{
		return passwordTextbox;
		
	}
	public WebElement getLoginButton()
	{
		return loginButton;
		
	}
	public ForgotPasswordPage getforgotPassword()
	{
		forgotPassword.click();
		ForgotPasswordPage fp=new ForgotPasswordPage(driver);
		return fp;
		
	}
}

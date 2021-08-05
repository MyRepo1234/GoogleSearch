package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	 public WebDriver driver;
	
	
	@FindBy(xpath="//input[@id='user_email']")
	WebElement emailAddress;
	@FindBy(xpath="//input[@name='commit']")
	WebElement sendMeInstruction;
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}

	public WebElement getEmailAddress()
	{
		return emailAddress;
		
	}
	public WebElement clicksendMeInstruction()
	{
		return sendMeInstruction;
		
	}
	
}

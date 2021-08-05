package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	 public WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href*='sign_in']")
	WebElement LoginLink;
	
	@FindBy(xpath="//div[@class='col-sm-6 col-md-8 hidden-xs video-banner']/h3")
	WebElement mainheadingTitle;
	
//	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']")
//	WebElement headerNavigationBar;
	@FindBys( {
		   @FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']"),
		   @FindBy(tagName="a")
		} )
	private List<WebElement> headerLinks;
	
	
	
	

	





	public LoginPage getloginLink()
	{
		 LoginLink.click();
		 LoginPage l=new LoginPage(driver);
		 return l;
		 
	}
	public WebElement getTitle()
	{
		 return mainheadingTitle ;
		 
	}
	public List<WebElement> getHeaderSection()
	{
		 return  headerLinks;
		 
	}
	
	
}

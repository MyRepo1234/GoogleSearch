package qaAcadamy;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import resources.Driverinitialize;

public class ValidationTest extends Driverinitialize{
	public WebDriver driver;
	private static Logger log=LogManager.getLogger(ValidationTest.class.getName());
    
    @BeforeTest
	public void browserDetails() throws IOException
	{
		driver=initializeDriver();
		log.info("Initialize driver");
	}

	@Test(dataProvider="getData")
  public void 	homepagenavigation(String email,String password,String text) throws IOException
  {
		driver=initializeDriver();
		
		Homepage hp=new Homepage(driver);
		//hp.getloginLink().click();
		LoginPage l=hp.getloginLink();
		log.info("successfully click on loginlink");
		//LoginPage l=new LoginPage(driver);
		l.getEmail().sendKeys(email);
		l.getPassword().sendKeys(password);
		log.info(text);
		l.getLoginButton().click();	
		ForgotPasswordPage	fp=l.getforgotPassword();
		//ForgotPasswordPage fp=new ForgotPasswordPage(driver);
		fp.getEmailAddress().sendKeys("abcs@gmail.com");
		fp.clicksendMeInstruction().click();
		
  }
@DataProvider
public Object[][] getData()
{
	//row stands for how different data type test should run
	//coloumn represent how many values to send per test
	Object[][] data=new Object[2][3];
	//0th row
	data[0][0]="nonrestrictedUser@id.com";
	data[0][1]="1234";
	data[0][2]="nonrestricted user";
	//1st row
	data[1][0]="restricedUser@id.com";
	data[1][1]="12345";
	data[1][2]="restricted user";
return data;
}	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
	}
	
	
	
	
}

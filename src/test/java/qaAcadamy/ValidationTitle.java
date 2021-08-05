package qaAcadamy;

import java.io.IOException;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import resources.Driverinitialize;

public class ValidationTitle extends Driverinitialize {
	private static Logger log = LogManager.getLogger(ValidationTitle.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void browserDetails() throws IOException {
		driver = initializeDriver();
		log.info("Initialize driver");

	}

	@Test
	public void titleValidation() throws IOException {

		Homepage hp = new Homepage(driver);
		System.out.println(hp.getTitle().getText());
		Assert.assertTrue(hp.getTitle().isDisplayed());
		// Assert.assertEquals(hp.getTitle().getText(), "AN ACADEMY TO LEARN EVERYTHING
		// ABOUT TESTING1234");
		Assert.assertEquals(hp.getTitle().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		System.out.println(hp.getHeaderSection().size());
	Iterator<WebElement> it=	hp.getHeaderSection().iterator();
	while(it.hasNext())
	{
		System.out.println(it.next().getText());
	}

		log.info("successfully show the headersection");
		System.out.println("test completed");

	}

	@AfterTest
	public void tearDown() {
		driver.close();

	}

}

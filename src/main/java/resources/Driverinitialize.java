package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driverinitialize 
{
	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		// System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Broswerdata.properties");
		prop.load(fis);
		// String browsername=System.getProperty("broswer");
		String browsername = prop.getProperty("browser");
		System.out.println(browsername);
		String urlLink = prop.getProperty("url");
		System.out.println(urlLink);

		if (browsername.equals("chrome"))

		{
			 //WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Admin\\eclipse-workspace\\FirstExample\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
			driver = new ChromeDriver(options);
			// ChromeDriver driver = new ChromeDriver(options);
			ChromeOptions options1 = new ChromeOptions();
			options1.addArguments("headless");
			driver = new ChromeDriver(options1);

			// to run this in cmd mvn test -Dbrowser=chrome(or)chromeheadless
			driver.get(urlLink);
		}

//		 if(browsername.contains("chrome)
//	 {
//		 WebDriverManager.chromedriver().setup();
//		 ChromeOptions options= new ChromeOptions();
//	 if(browsername.contains("headless")
//			 {
//		 options.addArguments("headless");
//			 }

//		 driver =new ChromeDriver(options);
//		 //to run this in cmd mvn test -Dbrowser=chrome(or)chromeheadless
//     	 driver.get(urlLink);
//	 }
//	 

//	 else if(browsername.equals("firefox"))
//	 {
//		 WebDriverManager.firefoxdriver().setup();
//		 driver =new FirefoxDriver();
////		 driver.get(urlLink);
//	 }else if(browsername.equals("InternetExplorer"))
//	 {
//
//		 WebDriverManager.iedriver().setup();
//		 driver =new InternetExplorerDriver();
////		 driver.get(urlLink);
//	 }
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return driver;

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}

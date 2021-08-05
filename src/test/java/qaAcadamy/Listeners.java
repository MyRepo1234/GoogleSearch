package qaAcadamy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Driverinitialize;
import resources.ExtentreporterNg;

public class Listeners extends Driverinitialize implements ITestListener {
	ExtentTest test;
ExtentReports extent	=ExtentreporterNg .getReportObject();
ThreadLocal<ExtentTest> extentThread =new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
      extentThread.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentThread.get().log(Status.PASS, "Test Passed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentThread.get().fail(result.getThrowable());
		WebDriver driver=null;
	 String testMethodName= result.getMethod().getMethodName();
		try {
			   driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		    }
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			extentThread.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			getScreenShotPath(testMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}

	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
		
	}

}

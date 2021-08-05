
package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreporterNg {
	 static ExtentReports extent;
	public  static  ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir") + "//report//extentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("ExtentReport");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	    extent.setSystemInfo("Tester", "MAMATHA");
		return extent;
	}

}

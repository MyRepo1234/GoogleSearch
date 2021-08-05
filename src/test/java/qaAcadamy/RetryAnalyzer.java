package qaAcadamy;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int count=0;

	 int maxCount=2;

	 public boolean retry(ITestResult result) {

	  if(count<maxCount) {

	   System.out.println("Retrying " +result.getName() +" again and count is " +(count+1));

	   count++;

	   return true;
	  }
	  return false;
	 }

	}
package qaAcadamy;

import org.testng.ITestResult;

public interface IRetryListener {

	public boolean retry(ITestResult result);
}

package twinlight.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryanalyserImplementation implements IRetryAnalyzer {
	int count=0;
	int retrycount=2;
	public boolean retry(ITestResult result) {
		
		while(count<retrycount) {
			count++;
			return true;
		}
		return false;
	}

}

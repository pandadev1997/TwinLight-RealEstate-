package practice;

import org.testng.annotations.DataProvider;

import twinlight.GenericUtility.ExcelFileUtility;

public class DataUtility {
	@DataProvider
	public Object[][] data() throws Throwable {
		ExcelFileUtility eutil=new ExcelFileUtility();
		Object[][] setOfdata = eutil.readmultipleSetOfData("DataProvider");
		return setOfdata;
	}
}

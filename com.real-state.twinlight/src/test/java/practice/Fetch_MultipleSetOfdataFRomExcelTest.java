package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import twinlight.GenericUtility.ExcelFileUtility;

public class Fetch_MultipleSetOfdataFRomExcelTest {
	
	@Test(dataProviderClass = DataUtility.class,dataProvider = "data")
	public void getdata(String src,String dst,String price) {
		System.out.println(src+" "+dst+" "+price);
	}
	
}

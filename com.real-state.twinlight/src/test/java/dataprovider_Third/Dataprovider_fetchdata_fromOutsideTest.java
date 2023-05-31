package dataprovider_Third;

import org.testng.annotations.Test;

public class Dataprovider_fetchdata_fromOutsideTest {
	@Test(dataProviderClass = DataProvider_outsideclassTest.class,dataProvider = "data")
	public void getData(String phone,int price,int rating,String feedback,String battery) {
		System.out.println(phone+"-->"+price+"-->"+rating+" -->"+feedback+"-->"+battery);
		
	}
}

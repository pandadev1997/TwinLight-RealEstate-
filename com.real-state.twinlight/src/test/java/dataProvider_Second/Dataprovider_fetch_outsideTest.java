package dataProvider_Second;

import org.testng.annotations.Test;

public class Dataprovider_fetch_outsideTest {
	@Test(dataProviderClass = Dataprovider_outside_class.class,dataProvider = "data")
	public void getData(String phone,int price,int rating,String feedback) {
		System.out.println(phone+"-->"+price+"-->"+rating+" -->"+feedback);
		
	}
}

package practice;

import org.testng.annotations.Test;

public class First_outside_fetch_data {
	@Test(dataProviderClass = DataProvider_First_outsideclass.class,dataProvider = "data")
	public void getData(String phone,int price,int rating) {
		System.out.println(phone+"-->"+price+"-->"+rating);
		
	}

}

package dataProvider_Second;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider_InsideclassTest {
	@Test(dataProvider = "data")
	public void getData(String phone,int price,int rating,String feedback) {
		System.out.println(phone+"-->"+price+"-->"+rating+" -->"+feedback);
		
	}
	@DataProvider
	public Object[][] data(){
		Object[][] p=new Object[4][4];
		p[0][0]="samsung";
		p[0][1]=6000;
		p[0][2]=5;
		p[0][3]="good";
		p[1][0]="Nokia";
		p[1][1]=6000;
		p[1][2]=4;
		p[1][3]="good product";
		p[2][0]="mi";
		p[2][1]=6000;
		p[2][2]=3;
		p[2][3]="good phone";
		p[3][0]="xiami";
		p[3][1]=6000;
		p[3][2]=3;
		p[3][3]="good phone";
		return p;
	}

}

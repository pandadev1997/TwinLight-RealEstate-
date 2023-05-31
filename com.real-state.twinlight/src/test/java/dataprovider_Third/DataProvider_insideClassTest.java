package dataprovider_Third;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_insideClassTest {
	@Test(dataProvider = "data")
	public void getData(String phone,int price,int rating,String feedback,String battery) {
		System.out.println(phone+"-->"+price+"-->"+rating+" -->"+feedback+"-->"+battery);
		
	}
	@DataProvider
	public Object[][] data(){
		Object[][] p=new Object[4][5];
		p[0][0]="samsung";
		p[0][1]=6000;
		p[0][2]=5;
		p[0][3]="good";
		p[0][4]="6000mah";
		p[1][0]="Nokia";
		p[1][1]=6000;
		p[1][2]=4;
		p[1][3]="good product";
		p[1][4]="8000mah";
		p[2][0]="mi";
		p[2][1]=6000;
		p[2][2]=3;
		p[2][3]="good phone";
		p[2][4]="9000mah";
		p[3][0]="xiami";
		p[3][1]=6000;
		p[3][2]=3;
		p[3][3]="good phone";
		p[3][4]="5000mah";
		return p;
	}

}

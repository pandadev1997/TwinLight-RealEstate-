package practice;

import org.testng.annotations.DataProvider;

public class DataProvider_First_outsideclass {
	@DataProvider
	public Object[][] data(){
		Object[][] p=new Object[3][3];
		p[0][0]="samsung";
		p[0][1]=6000;
		p[0][2]=5;
		p[1][0]="Nokia";
		p[1][1]=6000;
		p[1][2]=4;
		p[2][0]="samsung";
		p[2][1]=6000;
		p[2][2]=3;
		return p;
	}
}

package twinlight.GenericUtility;

import java.util.Date;
import java.util.Random;
/**
 * This class consist of java related operation
 * @author debas
 *
 */

public class JavaUtility {
	/**
	 * This method is used to get a random number
	 * @return
	 */
	
	public int getRandomNumber() {
		Random r=new Random();
		return r.nextInt(900)+100;
	}
	/**
	 * This method will return the system present date
	 * @return
	 */
	public String currentSystemDate() {
		Date d=new Date();
		String currentdate = d.toString();
		return currentdate;
	}
	
	public String getSystemDateInFormat() {
		Date d=new Date();
		String date = d.toString();
		String a[]=date.split(" ");
		int month = d.getMonth();
		String week = a[0];
		String cdate = a[2];
		String year = a[5];
		
		String RequiredDateFormat=month+" "+week+" "+cdate+" "+year;
		return RequiredDateFormat;
	}

}

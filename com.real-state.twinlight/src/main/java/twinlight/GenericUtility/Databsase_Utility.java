package twinlight.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * This method help us to connect to the database
 * @author debas
 *
 */
public class Databsase_Utility {
	Connection conn=null;
	public void dbConnection() throws Throwable {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		 conn = DriverManager.getConnection(IpathConstant.jdbcurl,IpathConstant.jdbcUsername,IpathConstant.jdbcPassword);
		
	}
	/**
	 * This method help us to close the DB connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
		conn.close();
		
		
	}

}

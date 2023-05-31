package twinlight.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class have method of property file
 * @author debas
 *
 */
public class PropertyFileUtility {
	/**
	 * This method help us to fetch data from property file
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromPropertyfile(String data) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstant.propertyfilepath);
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(data);
		return value;
	}
}

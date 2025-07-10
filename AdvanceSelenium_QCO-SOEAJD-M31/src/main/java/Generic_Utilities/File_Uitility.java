package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Uitility {

	/**
	 * This method is used to read data from properties file(External resource)
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Shobha
	 */
	public String getKeyAndValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");

		// step2:- Create the object of Properties class and load all the Keys
		Properties pro = new Properties();
		pro.load(fis);

		// step3:-read the value using getProperty()
		String Value = pro.getProperty(key);

		return Value;

	}
}

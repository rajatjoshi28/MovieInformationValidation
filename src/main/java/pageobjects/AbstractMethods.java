package pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AbstractMethods {
	public String getDataProperty(String requiredDataName) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(file);
		return prop.getProperty(requiredDataName);
	}

}

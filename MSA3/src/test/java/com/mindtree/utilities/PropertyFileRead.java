package com.mindtree.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileRead
{

	public String getFromProperty(String fileName, String key)
	{
		Logging l = new Logging();
		Properties prop = null;
		try
		{
			prop = new Properties();
			FileInputStream fs = new FileInputStream("./Property File/" + fileName + ".properties");
			prop.load(fs);
		}
		catch (FileNotFoundException f)
		{
			l.error("Could not find the " + fileName + ".properties property file");
			f.getMessage();
		}
		catch (IOException i)
		{
			l.error("Failed to load the file from input");
			i.getMessage();
		}
		return prop.getProperty(key);
	}
}

package com.OrangeHRMTC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyHandling {
	private Properties prop;
	public PropertyHandling(String filepath)
	{
		prop=new Properties();
		try {
			FileInputStream input=new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getProperty(String key)
	{
		return prop.getProperty(key);
	}

}

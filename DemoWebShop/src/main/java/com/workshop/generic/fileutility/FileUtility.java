package com.workshop.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	public String getDataFromProperties(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./configAppData/Commondata.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String data=pObj.getProperty(key);
		
		return data;
		
	}
}

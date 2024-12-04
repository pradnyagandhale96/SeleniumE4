package com.crm.javautility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonData {
	
	Properties  properties=new Properties();
	FileInputStream inputStream;
	
	public String data(String key) throws IOException {
		
		inputStream=new FileInputStream("src/main/java/file_utility/CommonData.properties");
		properties.load(inputStream);
		String data=properties.getProperty(key);
		
		return data;
		
	}
	
	}



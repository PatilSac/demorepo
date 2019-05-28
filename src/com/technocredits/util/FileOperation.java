package com.technocredits.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileOperation {
	
	private static Properties prop;
		
	final static public Properties LoadFile(String path)
	{
		File file = new File(path);
		try {
			FileInputStream input = new FileInputStream(file);
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}

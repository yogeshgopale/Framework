package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRead {
public	Properties prop;
public	PropertiesRead(){
		String path = "C:\\Users\\Admin\\eclipse-workspace\\FrameWork\\ConfigFiles\\config.properties";
		 prop = new Properties();
		try {
		FileInputStream file = new FileInputStream(path);
		prop.load(file);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

	public String URL() {
		String mainURL = prop.getProperty("url");
		return mainURL;
	}
	
	public String username() {
		String mainusername = prop.getProperty("username");
		return mainusername;
	}
	
	public String password() {
		String mainpassword = prop.getProperty("password");
		return mainpassword;
	}
	
	public String browser() {
		String mainbrowser = prop.getProperty("browser");
		return mainbrowser;
	}
	
}

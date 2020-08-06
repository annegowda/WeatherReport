package com.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author Annegowda
 * This class read all properties values from dafault.properties file
 *
 */


public class RunTimeConfig {

	
	private static final ThreadLocal<Properties> config=new InheritableThreadLocal<Properties>();
	
	
	
	 public RunTimeConfig() {
		// TODO Auto-generated constructor stub
		Properties temppropholder=new Properties();
		
try {
			
			
			temppropholder.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\default.properties"));
			//System.out.println(temppropholder.getProperty("env"));
			
		}catch (FileNotFoundException file) {
			
			file.getMessage();
		}catch (IOException e) {
			
			e.getMessage();
		}
		config.set(temppropholder);
	}
	
	
	
	/**
	 * initating the property file and reading all preset data from property file
	 *
	 */
	public static void  init() {
		
		Properties temppropholder=new Properties();
		
		try {
			
			
			temppropholder.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\default.properties"));
			
		}catch (FileNotFoundException file) {
			
			file.getMessage();
		}catch (IOException e) {
			
			e.getMessage();
		}
		config.set(temppropholder);
	}
	
	public static Properties getConfig() {
		return config.get();
	}
	
	
	public static void setConfig(Properties prop) {
		config.set(prop);
	}
	
	
	public static String  getPropertyByName(String propname) {
		
		String value=RunTimeConfig.getConfig().getProperty(propname);
		
		
		return value;
	}
	
	public static String  getChromedriverlocation() {
	
		return RunTimeConfig.getConfig().getProperty(Property.CHROME_DRIVER_LOCATION);
		
		}
	
	public static String  getERPURL() {
		
		return RunTimeConfig.getConfig().getProperty(Property.URL);
		
		}
	
	public static String  getAPIL() {
		
		return RunTimeConfig.getConfig().getProperty(Property.API);
		
		}
	
	
	
	
	public static String  getDatafilepath() {
		
		return RunTimeConfig.getConfig().getProperty(Property.TEST_DATA_FILEPATH);
		
		}
	
	public static String  getDatasheetname() {
	
		return RunTimeConfig.getConfig().getProperty(Property.TEST_SHEET);
		
		}
	
	
	
	public static void main(String[] a) {
		System.out.println(System.getProperty("user.dir"));
		init();
		
	}

}
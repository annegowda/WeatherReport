package com.core;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class WebdriverFactory {
	
	
	private static WebDriver driver;
	
	
	private WebdriverFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static  WebDriver createDriverIntence(String browser) {
		driver=null;
		if(driver==null) {
		ChromeOptions options=new ChromeOptions();
		System.out.println("path="+RunTimeConfig.getPropertyByName(Property.CHROME_DRIVER_LOCATION));
		System.setProperty(Property.CHROME_DRIVER_LOCATION, RunTimeConfig.getPropertyByName(Property.CHROME_DRIVER_LOCATION));
		/*
		 * start-maximized: Opens Chrome in maximize mode incognito: Opens Chrome in incognito mode 
		 * headless: Opens Chrome in headless mode 
		 * disable-extensions:Disables existing extensions on Chrome browser
		 *  disable-popup-blocking: Disables pop-ups displayed on Chrome browser
		 *   make-default-browser: Makes Chrome default browser 
		 *   version: Prints chrome browser version
		 * disable-infobars: Prevents Chrome from displaying the notification 'Chrome is
		 * being controlled by automated software'
		 */
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("version");
		LoggingPreferences logPrefs = new LoggingPreferences();
    	logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
    	logPrefs.enable(LogType.SERVER, Level.ALL);
    	logPrefs.enable(LogType.BROWSER, Level.ALL);
    	logPrefs.enable(LogType.CLIENT, Level.ALL);
    	logPrefs.enable(LogType.DRIVER, Level.ALL);

    	options.setCapability( "goog:loggingPrefs", logPrefs );
    	options.setCapability( "goog:chromeOptions", logPrefs );
    	
    	options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
    	System.out.println("browser returned");
        driver=new ChromeDriver(options);
		}
		
		
		return driver;
	}
	
}
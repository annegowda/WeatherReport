package com.core;


import java.io.IOException;
import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


/*class help us to iniate the webdriver and close the driver*/

public class DefaultTestNGclass{
	
	
	//Logger log=LoggerFactory.getLogger(DefaultTestNGclass.class);
	
	protected WebDriver driver;
	
	
	
	

	
	
	 @BeforeSuite(alwaysRun=true)
	    public void defaultBeforeSuite(ITestContext context) {
	    //	log.info ("**********Starting Test suite**********");
	        RunTimeConfig.init();
		
	       
    
	 }
	 
	 
	 @AfterSuite(alwaysRun=true)
	    public void defaultAfterSuite(ITestContext context) {
		 
	    	//log.info ("**********end Test suite**********");
	    	
	       
	       
	    }
	 
	 
	
	 
	 @BeforeClass(alwaysRun=true)
	    public void defaultBeforeClass(ITestContext context) throws Exception {
		  
		 
		  System.out.println("browser initate");
		  
	       this.driver= WebdriverFactory.createDriverIntence(RunTimeConfig.getPropertyByName(Property.BROWSER))	;  
		   System.out.println(RunTimeConfig.getPropertyByName(Property.URL));
            driver.get(RunTimeConfig.getPropertyByName(Property.URL));
        
	       
	    }

	 
	
	  @AfterClass(alwaysRun = true)
	  public void teardownbrowser() throws IOException {
		 
		 driver.close();
		     
		System.out.println("Excution completed ");	 
	  }
	  
     
	  
	 
	 
	  
	  
	  
	
	 
}

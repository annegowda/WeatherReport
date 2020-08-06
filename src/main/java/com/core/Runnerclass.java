package com.core;

import java.util.ArrayList;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.google.gson.JsonObject;

/*the class init the data factory based on the data factory params, TestNG XML create Programmatically and will execute*/

public class Runnerclass {
	
	
	public static void main(String arg0[]) {
		
		DataFactory data=new DataFactory();
		data.init();
	JsonObject alldata=	data.getAllData();
	System.out.println(alldata);
    TestNG runner=new TestNG(true);
	//runner.setTestSuites(suites);
	
    ArrayList<XmlSuite> suits=new ArrayList<XmlSuite>();
	XmlSuite suit=new XmlSuite();
	 suit.setName("TestExcution");
	// suit.addListener("reporting.listners");

	
	 ArrayList<XmlTest> tests=new ArrayList<XmlTest>();
	 
	 
	 
	 Set<String> tds=data.getAllData().keySet();
	 for(String td:tds) {
		 System.out.println(td);
		 System.out.println(data.getAllData().getAsJsonObject().get(td).getAsJsonObject().get("TestName").getAsString().replace("\"", ""));
		 String testname=data.getAllData().getAsJsonObject().get(td).getAsJsonObject().get("TestName").getAsString().replaceAll("\"", "");
		 XmlTest test=new XmlTest(suit);
		 test.setName(testname.concat(String.valueOf(System.currentTimeMillis())));
		 tests.add(test);
		 ArrayList<XmlClass> classes=new ArrayList<XmlClass>();
			classes.add(new XmlClass("tests."+testname));
			test.setXmlClasses(classes);
			Set<String> params=data.getAllData().getAsJsonObject().get(td).getAsJsonObject().keySet();
			
			for(String parm:params) {
				test.addParameter(parm, data.getAllData().getAsJsonObject().get(td).getAsJsonObject().get(parm).getAsString().replace("\"", ""));
			}
		
	 }
	 
	 System.out.println(suit);
	 
	 suits.add(suit);
	 
	 runner.setXmlSuites(suits);
	 runner.run();
	
	}


}

package com.core;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


/*this class read the data from excel and convert into json*/

public class DataFactory {
	static JsonObject allData = null;

	//private static final Logger log = LoggerFactory.getLogger(DataFactory.class);

	public void init() {
		XSSFWorkbook workbook=null;
	
		RunTimeConfig.init();
		XSSFSheet sheet=null;
		allData=new JsonObject();
		
		 try {
			//  log.info("loading the file from path"+RunTimeConfig.getPropertyByName(Property.TEST_DATA_FILEPATH));
				System.out.println(System.getProperty("user.dir")+RunTimeConfig.getPropertyByName(Property.TEST_DATA_FILEPATH));
			 workbook=new XSSFWorkbook(new FileInputStream(System.getProperty("user.dir")+RunTimeConfig.getPropertyByName(Property.TEST_DATA_FILEPATH)) );
			// log.info("loading the file from sheet"+RunTimeConfig.getPropertyByName(Property.TEST_SHEET));
			  sheet=workbook.getSheet(RunTimeConfig.getPropertyByName(Property.TEST_SHEET));
			 
						 
		 }catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			 
		}
		 
		 System.out.println(sheet.getSheetName());
		 System.out.println(sheet.getFirstRowNum());
		 System.out.println(sheet.getLastRowNum());
		 Iterator<Row> rowiterator=sheet.rowIterator();
		
		 
		 
		 int count=1;
		 rowiterator.next();
		 while(rowiterator.hasNext()) {
			 
			
			 XSSFRow currentRow = (XSSFRow) rowiterator.next();
			
			Iterator<Cell> celliterator = currentRow.cellIterator();
			JsonObject rowobject=new JsonObject();
			
			 while(celliterator.hasNext()) {
				 
			 String cellvalue=celliterator.next().getStringCellValue();
			
			 if(cellvalue.contains("=")) {
				String key= cellvalue.split("=")[0];
				
				
				String value=cellvalue.substring(cellvalue.indexOf("=")+1);
				
				rowobject.add(key, (new JsonParser()).parse("\""+value+"\""));
				
			 }else if(cellvalue.endsWith("Test")) {
				
				 rowobject.add("TestName", (new JsonParser()).parse("\""+cellvalue+"\"")); 
				
			 }
			 
			 }
			 
			
			 
			 allData.add("TD"+count, rowobject);
			 
			 
			 count++;
			 }
		

	}
	
	public JsonObject getAllData() {
		return allData;
		
	}
	

}

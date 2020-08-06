package com.ndtv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/* The class contain weather forecast page obects and function*/
public class Weatherpage {
	
	WebDriverWait wait;
	WebDriver driver;
	
	@FindBy(css=".searchBox")
	WebElement SearchBox;
	
	@FindBy(css="div[title='Bengaluru']")
	WebElement Bengaluru;
	
	@FindBy(css = "span.heading:nth-child(6)")
	WebElement gethumidity;
	
	@FindBy(css = "span.heading:nth-child(8)")
	WebElement getTemp_in_deg;
	
	//intiate the class
 public Weatherpage(WebDriver driver) {
		this.wait=new WebDriverWait(driver, 100);
		this.driver=driver;
		PageFactory.initElements(driver, this);
			
	}

 //enter the city name into search field
 public void Click_on_Search(String cityname) {
		wait.until(ExpectedConditions.elementToBeClickable(SearchBox)).sendKeys(cityname);
	}
 
 //click on city
 public void Click_on_city(String cityname) {
	 String city="div[title='"+cityname+"']";
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(city))).click();
	}
	
 //get Humidity
 public String Get_Humidity() {
	
	 String humidity=wait.until(ExpectedConditions.elementToBeClickable(gethumidity)).getText();
	
		return humidity;
	}
	
 //get the Temp in Degrees
 public String Get_Temp_Degree() {
		
	 String temp=wait.until(ExpectedConditions.elementToBeClickable(getTemp_in_deg)).getText();
		
		return temp;
	}

}

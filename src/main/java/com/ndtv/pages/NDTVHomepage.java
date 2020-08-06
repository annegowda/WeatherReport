package com.ndtv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/* NDTV Home page, this class contain Webelements and function related to this page.*/
public class NDTVHomepage {

String url="https://www.ndtv.com/";
	
	WebDriverWait wait;
	WebDriver driver;
	
	
	@FindBy(css = ".notnow")
	WebElement Nothanks;
	
	@FindBy(css = "#h_sub_menu")
	WebElement Submenu;
	
	@FindBy(css = "a[href='https://social.ndtv.com/static/Weather/report/?pfrom=home-topsubnavigation']")
	WebElement Weather;
	
	@FindBy(css=".searchBox")
	WebElement SearchBox;
	
	@FindBy(css="div[title='Bengaluru']")
	WebElement Bengaluru;
	
	@FindBy(css = "span.heading:nth-child(6)")
	WebElement gethumidity;
	
	@FindBy(css = "span.heading:nth-child(6)")
	WebElement getTemp_in_deg;
	
	
	//class init
	public NDTVHomepage(WebDriver driver) {
		this.wait=new WebDriverWait(driver, 100);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
				
	}
	
	
	//click on No Thanks 
	public void Click_on_NoThanks() {
		
		
		wait.until(ExpectedConditions.elementToBeClickable(Nothanks)).click();
	}
	
	//Click on submenu
	public void Click_on_SubMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(Submenu)).click();
	}
	

	//Click on Weather Link
	public Weatherpage Click_on_Weather() {
		wait.until(ExpectedConditions.elementToBeClickable(Weather)).click();
		return new Weatherpage(driver) ;
		
	}
	
	
}

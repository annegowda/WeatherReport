package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.core.DefaultTestNGclass;
import com.ndtv.pages.NDTVHomepage;
import com.ndtv.pages.Weatherpage;
import com.openweather.apis.OpenWeather;
import com.utilities.ObjComparator;
import com.utilities.Resultobject;


public class ApptempTest extends DefaultTestNGclass {
	
	NDTVHomepage ndtvpage;
	Weatherpage weatherpage;
	Resultobject UIResult;
	Resultobject APIResult;
	
	@Test()
	@Parameters({"city","TempVarience","HumidityVarience"})
	public void WeatherTest(String city,int TempVarience, int HumidityVarience ) {
	 ndtvpage=new NDTVHomepage(driver);
	 ndtvpage.Click_on_NoThanks();
	 ndtvpage.Click_on_SubMenu();
	 weatherpage= ndtvpage.Click_on_Weather();
	 weatherpage.Click_on_Search(city);
	 weatherpage.Click_on_city(city);
float humidity= Float.parseFloat(weatherpage.Get_Humidity().trim().replace("Humidity: ", "").replace("%", ""));
float temp= Float.parseFloat(weatherpage.Get_Temp_Degree().trim().replace("Temp in Degrees: ", ""));
System.out.println("Temp in C from UI= "+temp);
System.out.println("Humidity from UI= "+humidity);

UIResult=new Resultobject();
UIResult.setTemp(temp);
UIResult.setHumidity(humidity);

APIResult=new Resultobject();

APIResult.setTemp(OpenWeather.Get_Temp_in_degree(OpenWeather.Get_WeatherResponse(city)));
APIResult.setHumidity(OpenWeather.Get_Humidity(OpenWeather.Get_WeatherResponse(city)));


 System.out.println("Temp in C= from API= "+APIResult.getTemp());
 System.out.println("Humidity from API= "+APIResult.getHumidity());
boolean testresult= ObjComparator.compartor(UIResult, APIResult, TempVarience, HumidityVarience);
assertTrue(testresult);

}
}

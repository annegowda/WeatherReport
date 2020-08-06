package com.openweather.apis;

import static io.restassured.RestAssured.given;

import com.core.Property;
import com.core.RunTimeConfig;

import io.restassured.response.Response;

public class OpenWeather {

	
	
		
		static String baseuri=RunTimeConfig.getPropertyByName(Property.API);
		
		static Response currentbalancejson;
		
		//This method will give you whole api response
		
		
		public   static Response Get_WeatherResponse(String city) {
			
			
			
			Response response=(Response) given().queryParam("q", city).queryParam("appid", "439d4b804bc8187953eb36d2a8c26a02").get(baseuri).then().extract();
			
			//return response;
			return response;
			
		}
		
		
		
		//extracting the temp using json path method and converting from Kalven to Celsius .
		public static  Float Get_Temp_in_degree(Response response) {
			
		Float	kalven=response.jsonPath().getFloat("list[0].main.temp");
			Float temp=(float) (kalven-273.15);

			return temp;
			
			
		}
		
		
		//extracting Humidity using json path method
		public static Float Get_Humidity(Response response) {
			
			Float	humidity=response.jsonPath().getFloat("list[0].main.humidity");
				
	       return humidity;
					
				
			}
}

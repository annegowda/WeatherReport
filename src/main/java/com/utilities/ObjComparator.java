package com.utilities;


public class ObjComparator{
	
	
	public static boolean compartor(Resultobject obj1,Resultobject obj2,int tempvar,int humvar) {
	
	 boolean[] r=new boolean[2];
	 float tempmax=obj1.getTemp() + tempvar;
	 float tempmin=obj1.getTemp() - tempvar;
	 System.out.println("Max Temp Range=" +tempmin+ "to" +tempmax );
	 

	if(obj2.getTemp() <= obj1.getTemp() + tempvar  && obj2.getTemp() >= obj1.getTemp() - tempvar){
	 r[0]=true;
	 System.out.println("Temp Match with in Range");
	} else{
	 r[0]=false;
	 System.out.println("Temp not Match with in Range");
	}

	
	float tenpercmax = obj1.getHumidity() + (obj1.getHumidity() * humvar/100);
	float tenpercmin = obj1.getHumidity() - (obj1.getHumidity() * humvar/100);
	System.out.println("Humid range="+tenpercmin+ "to" +tenpercmax);
	
	
	
	if(obj2.getHumidity() <= tenpercmax  &&  obj2.getHumidity() >= tenpercmin){
	 r[1]=true;
	 System.out.println("Humidity Match with in Range");
	} else{
	 r[1]=false;
	 System.out.println("Humidity not match with in Range");
	}

	
	if(r[0]==true && r[1]== true) {
		 System.out.println("true");
		 return true;
	}else {
		 System.out.println("false");
		 return false;
	}
	
	
    	 
     }
	
	
}


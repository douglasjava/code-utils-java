package com.example.demo.datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DataUTC {

	public static void main(String[] args) throws ParseException {
		
		String dataString = "2020-12-13T00:00:00";

		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    df.setTimeZone(TimeZone.getTimeZone("UTC"));
	    Date date = df.parse(dataString);
	    
	    System.out.println(date);
		
	}
	
}

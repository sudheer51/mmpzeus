package javaexamples;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFunctionality {
	
	public static void main(String[] args) {
		 
			DateFunctionality df = new DateFunctionality();
			
			String result = df.getFutureDate(30,"MM/d/yyyy");
			System.out.println(result);
			String dateArr[]=result.split("/");
			System.out.println(dateArr[0]);
			System.out.println(dateArr[1]);
			System.out.println(dateArr[2]);
		 
			
	}
	public String getFutureDate(int noofdays)
	{

		Calendar cal = 	Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noofdays);
		
		Date d = cal.getTime();
		System.out.println("Current Date :" + d);
				
		SimpleDateFormat sdf = new SimpleDateFormat();
		String defaultformat = sdf.format(d);
		System.out.println(defaultformat);
		
		sdf = new SimpleDateFormat("MM/dd/yyyy");
		String formatDate = sdf.format(d);
		System.out.println(formatDate);
		return formatDate;
	}
	public String getFutureDate(int noofdays,String pattern)
	{

		Calendar cal = 	Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noofdays);
		
		Date d = cal.getTime();
		System.out.println("Current Date :" + d);
				
		SimpleDateFormat sdf = new SimpleDateFormat();
		String defaultformat = sdf.format(d);
		System.out.println(defaultformat);
		
		sdf = new SimpleDateFormat(pattern);
		String formatDate = sdf.format(d);
		System.out.println(formatDate);
		return formatDate;
	}

}
/**
Reasons for not creating an object of the class:
Abstract Class
Private Constructor

**/
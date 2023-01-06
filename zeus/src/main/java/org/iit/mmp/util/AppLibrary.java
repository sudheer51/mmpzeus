package org.iit.mmp.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppLibrary {
	
	 
		public static String getFutureDate(int noofdays,String pattern)
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
		public static String getFutureDate(int noofdays)
		{

			Calendar cal = 	Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, noofdays);

			Date d = cal.getTime();
			System.out.println("Current Date :" + d);

			SimpleDateFormat sdf = new SimpleDateFormat();
			String defaultformat = sdf.format(d);
			System.out.println(defaultformat);

			sdf = new SimpleDateFormat("dd/MM/yyyy");
			String formatDate = sdf.format(d);
			System.out.println(formatDate);
			return formatDate;
		}

}

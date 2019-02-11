package com.bruno.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	public static String getDateToday() {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		final String now = dateFormat.format(new Date());
		return now;
	}
	
	public static void main(String[] args) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = "10/02/2019";
        
		Date date;
		try {
			date = formatter.parse(dateInString);
			java.sql.Date dateSQL = new java.sql.Date(date.getTime());
			System.out.println(dateSQL); // (YYYY/MM/dd)
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}

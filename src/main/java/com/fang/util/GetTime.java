package com.fang.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetTime {

	public static Date getNowTime(){
		Date newDate = Calendar.getInstance().getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		try {
			 d = dateFormat.parse(dateFormat.format(newDate));//Sun Jan 08 13:29:15 CST 2017
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static Date getTime(String time){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d =new Date();
		try {
			 d  = dateFormat.parse(time);//Sun Jan 08 13:29:15 CST 2017
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static String format(Date date,String s){
		SimpleDateFormat sdf=new SimpleDateFormat(s);
		String d = sdf.format(date);
	    return d;
	}
	
	public static String formatAll(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String d = sdf.format(date);
	    return d;
	}

	
	public static void main(String[] args) {
		System.out.println(GetTime.getTime("1994-11-11"));
	}

}

package br.com.furb.engenhariasoftware.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	private static SimpleDateFormat dateFormat;
	
	public static final String DATEFORMAT_DD_MM_YYYY = "dd/MM/yyyy";
	
	public static final String DATEFORMAT_DD_MM_YYYY_HH_MM = "dd/MM/yyyy HH:mm";
	
	public static final String DATEFORMAT_DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
	
	public static final String DATEFORMAT_HH_MM_SS = "HH:mm:ss";
	
	public static final String DATEFORMAT_HH_MM = "HH:mm";
	
	public static Timestamp getTimestampOfDate(Date date){
		return new Timestamp(date.getTime());
	}
	
	public static Date getDateOfTimestamp(Timestamp date){
		return new Date(date.getTime());
	}
	
	public static String getStringOfDate(Date date, String pattern){
		dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}
}

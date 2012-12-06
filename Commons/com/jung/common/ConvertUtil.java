package com.jung.common;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
/**
 * 
*  @Description: 常用工具类
*  @version Revision: V1.0 2012-8-22 上午12:23:46
*  @author GuoJun mailto: jackson@highcolu.com
 */
public class ConvertUtil {
	public static String toStr(Object o) {
		return o == null ? "" : o.toString();
	}

	public static Integer toInt(Object o) {
		return o == null || o.equals("") ? null : Integer
				.parseInt(o.toString());
	}

	public static Long toLong(Object o) {
		return o == null || o.equals("") ? null : Long.parseLong(o.toString());
	}

	public static Double toDouble(Object o) {
		return o == null || o.equals("") ? null : Double.parseDouble(o
				.toString());
	}

	public static BigDecimal toBigDecimal(Object o) {
		return o == null || o.equals("") ? null : BigDecimal.valueOf(Double
				.parseDouble(o.toString()));
	}

	public static Date toDate(Object o) throws ParseException {
		return o == null || o.equals("") ? null : new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss").parse(o.toString());
	}

	public static Date toDate(String str, String format) throws ParseException {
		return str == null || str.equals("") ? null : new SimpleDateFormat(
				format).parse(str);
	}

	public static Date toDate(Object o, SimpleDateFormat sdf)
			throws ParseException {
		return o == null || o.equals("") ? null : sdf.parse(o.toString());
	}

	public static String toDateStr(Object o) throws ParseException {
		return o == null ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format((Date) o);
	}

	public static String toYMDStr(Object o) throws ParseException {
		return o == null ? null : new SimpleDateFormat("yyyy-MM-dd")
				.format((Date) o);
	}
	
	public static java.sql.Date toYMDDate(String str, String format) throws ParseException {
		 java.util.Date date =str == null || str.equals("") ? null : new SimpleDateFormat(
				format).parse(str);
		return new java.sql.Date(date.getTime());
	}
	public static java.sql.Date timestampToDate(java.util.Date date){
		return new java.sql.Date(date.getTime());
	}
	public static String toYMDStr(Object o, SimpleDateFormat sdf)
			throws ParseException {
		return o == null ? null : sdf.format((Date) o);
	}

	public static String toDateStr(Object o, SimpleDateFormat sdf)
			throws ParseException {
		return o == null ? null : sdf.format((Date) o);
	}

	public static String getStr(Map<String, Object> map, Object key) {
		Object value = null;

		if (key != null && map.containsKey(key.toString()))
			value = map.get(key.toString());

		return value == null ? "" : value.toString();
	}

	public static Integer getTimeRange(Date begin, Date end) {
		Integer minutes = null;
		if (begin == null)
			return minutes;

		if (end == null)
			end = new Date();

		long ms = end.getTime() - begin.getTime();
		minutes = (int) (ms / 1000 / 60);

		return minutes;
	}

}

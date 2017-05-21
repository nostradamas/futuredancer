package com.fdw.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static final Timestamp getTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static final Timestamp getTimestamp(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 24:00:00");

		try {
			Date date = sdf.parse(dateStr);
			Timestamp ts = new Timestamp(date.getTime());
			return ts;
		} catch (Exception e) {
			return null;
		}
	}

	public static final Timestamp getTimestamp(String dateStr, String format) {
		SimpleDateFormat sdf = null;
		if (format == null)
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		else
			sdf = new SimpleDateFormat(format);
		try {
			Date date = sdf.parse(dateStr);
			Timestamp ts = new Timestamp(date.getTime());
			return ts;
		} catch (Exception e) {
			return null;
		}
	}

	public static final int getAge(Timestamp date) {
		if (date == null) {
			return 0;
		}
		long day = (System.currentTimeMillis() - date.getTime()) / (24 * 60 * 60 * 1000) + 1;
		return (int) (day / 365);
	}

	/**
	 * 格式化日�?
	 * 
	 * @param format
	 * @return
	 */
	public static final String getDate(String format) {
		if (format == null)
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

	public static final String getDate(Date date, String format) {
		if (format == null)
			format = "yyyy-MM-dd HH:mm:ss";
		if (date == null) {
			return getDate(format);
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static final int getAge(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfBirth = null;
		try {
			dateOfBirth = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int age = 0;
		Calendar born = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		if (dateOfBirth != null) {
			now.setTime(new Date());
			born.setTime(dateOfBirth);
			if (born.after(now)) {
				throw new IllegalArgumentException("Can't be born in the future");
			}
			age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
			if (now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR)) {
				age -= 1;
			}
		}
		return age;
	}

	public static final int getAge(Date dateOfBirth) {
		int age = 0;
		Calendar born = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		if (dateOfBirth != null) {
			now.setTime(new Date());
			born.setTime(dateOfBirth);
			if (born.after(now)) {
				throw new IllegalArgumentException("Can't be born in the future");
			}
			age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
			if (now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR)) {
				age -= 1;
			}
		}
		return age;
	}

	/**
	 * 返回
	 * 
	 * @param s
	 * @param d
	 * @return
	 */
	public static final long equals(String s, String d) {
		Date sd = getDate(s, "yyyy-MM-dd");
		Date dd = getDate(d, "yyyy-MM-dd");
		long delay = (sd.getTime() - dd.getTime());
		return delay;
	}

	public static final Date getDate(String date, String format) {
		if (format == null)
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Date returnDate = null;
		if (StringUtil.checkEmpty(date)) {
			returnDate = new Date();
		} else {
			try {
				returnDate = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return returnDate;
	}

	/**
	 * 将时间戳转换成标准时�?
	 * 
	 * @param ms
	 * @param format
	 * @return
	 */
	public static final String getDate(long ms, String format) {
		Date date = new Date(ms);
		if (format == null)
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static final String getDateByUnix(long ms, String format) {
		Date date = new Date(ms * 1000);
		if (format == null)
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 获取传入的日期所在的周，周一日期 
	 * 
	 * @param dateTime
	 *            传入的时�? 格式�? yyyy-MM-dd
	 * @return
	 * @throws Exception
	 */
	public static String getNowWeekMonday(String dateTime) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(dateTime));
		cal.add(Calendar.DAY_OF_MONTH, -1); // 解决周日会出�? 并到下一周的情况
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return sdf.format(cal.getTime());
	}

	/**
	 * 获取上周�?的日�? 
	 * @param dateTime
	 *            传入的时�? 格式�? yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 * @throws Exception
	 */
	public static String getLastWeekMonday(String dateTime) throws ParseException, Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date a = sdf.parse(addDay(dateTime, -1));
		Calendar cal = Calendar.getInstance();
		cal.setTime(a);
		cal.add(Calendar.WEEK_OF_YEAR, -1);// �?�?
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return sdf.format(cal.getTime());
	}

	/**
	 * 获取上周日的日期 
	 * @param dateTime
	 *            传入的时�? 格式�? yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 * @throws Exception
	 */
	public static String getLastWeekSunday(String dateTime) throws ParseException, Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date a = sdf.parse(addDay(dateTime, -1));
		Calendar cal = Calendar.getInstance();
		cal.setTime(a);
		cal.set(Calendar.DAY_OF_WEEK, 1);
		return sdf.format(cal.getTime());
	}

	/**
	 * 获取周一 日期和周�? 日期 
	 * @param radomdate
	 *            传入的日�? 格式�? yyyy-MM-dd
	 * @param i
	 *            0:上周周一和周日日�? 1:本周周一和周日日�? 2:下周周一和周日日�?
	 * @return 返回周一和周日的日期
	 * @throws Exception
	 */
	public static String[] returnWeekBetween(String radomdate, int i) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (StringUtil.checkEmpty(radomdate)) {
			radomdate = sdf.format(new Date());
		}
		Date a = sdf.parse(addDay(radomdate, -1));
		Calendar cal = Calendar.getInstance();
		String startMonthDay = "";
		String endMonthDay = "";
		if (i == 0) {
			cal.setTime(a);
			cal.add(Calendar.WEEK_OF_YEAR, -1);// �?�?
			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			startMonthDay = sdf.format(cal.getTime()); // 周一日期

			cal.setTime(a);
			cal.set(Calendar.DAY_OF_WEEK, 1); // 周日日期
			endMonthDay = sdf.format(cal.getTime());
		} else if (i == 1) {
			cal.setTime(a);
			cal.add(Calendar.WEEK_OF_YEAR, 0);// �?�?
			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			startMonthDay = sdf.format(cal.getTime()); // 周一日期

			cal.setTime(a);
			cal.add(Calendar.WEEK_OF_YEAR, 1);// �?�?
			cal.set(Calendar.DAY_OF_WEEK, 1); // 周日日期
			endMonthDay = sdf.format(cal.getTime());
		} else if (i == 2) {
			cal.setTime(a);
			cal.add(Calendar.WEEK_OF_YEAR, 1);// �?�?
			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			startMonthDay = sdf.format(cal.getTime()); // 周一日期

			cal.setTime(a);
			cal.add(Calendar.WEEK_OF_YEAR, 2);// �?�?
			cal.set(Calendar.DAY_OF_WEEK, 1); // 周日日期
			endMonthDay = sdf.format(cal.getTime());
		}
		String xx[] = new String[] { startMonthDay, endMonthDay };
		return xx;
	}

	/**
	 * 获取上个月的 
	 * @param radomdate
	 *            根据传入的时�? 去获得是上个月还是下个月还是当前�?
	 * @param i
	 *            0:上个月，1当前月，2下个�?
	 * @return
	 */
	public static String[] returnLastMonthBetween(String radomdate, int i) {
		Date inputDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputDate);

		if (i == 0) {
			cal.add(Calendar.MONTH, -1); // 上个�?
		} else if (i == 1) {
			cal.add(Calendar.MONTH, 0); // 当前�?
		} else if (i == 2) {
			cal.add(Calendar.MONTH, 1); // 下个�?
		}

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int maxDateNum = cal.getActualMaximum(Calendar.DATE);
		String monthstr = "";
		if (month < 10) {
			monthstr = "0" + month;
		} else {
			monthstr = "" + month;
		}
		String startMonthDay = year + "-" + monthstr + "-" + "01";
		String endMonthDay = year + "-" + monthstr + "-" + maxDateNum;
		String xx[] = new String[] { startMonthDay, endMonthDay };
		return xx;
	}

	/**
	 * 设置传入的时间增加一�? 
	 * 
	 * @param dateTime
	 *            设置的时�? 格式 yyyy-MM-dd
	 * @param n
	 *            增加的天�?
	 * @return 返回�? 设置时间的基�?上加 n
	 */
	public static String addDay(String dateTime, int n) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cd = Calendar.getInstance();
		try {
			cd.setTime(sdf.parse(dateTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cd.add(Calendar.DATE, n);// 增加 n �?
		// cd.add(Calendar.MONTH, n);//增加�?个月
		return sdf.format(cd.getTime());
	}

	/**
	 * 两个时间之间相差距离多少�?
	 * 
	 * @param str1
	 *            时间参数 1 时间格式 yyyy-MM-dd
	 * @param str2
	 *            时间参数 2时间格式 yyyy-MM-dd
	 * @return 相差天数
	 * @throws Exception
	 */
	public static long getDistanceDays(String str1, String str2) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date one = df.parse(str1);
		Date two = df.parse(str2);
		long time1 = one.getTime();
		long time2 = two.getTime();
		long diff;
		if (time1 < time2) {
			diff = time2 - time1;
		} else {
			diff = time1 - time2;
		}
		return diff / (1000 * 60 * 60 * 24);
	}

	/**
	 * 两个时间之间相差距离多少�?
	 * 
	 * @auther 车库互联�?+ 2016�?7�?14�?
	 * @param date
	 *            Date()类型
	 * @param startTime
	 *            Date()类型
	 * @return
	 */
	public static long getDistanceDays(Date date1, Date date2) {
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		long diff;
		if (time1 < time2) {
			diff = time2 - time1;
		} else {
			diff = time1 - time2;
		}
		return diff / (1000 * 60 * 60 * 24);
	}

	/**
	 * 两个时间相差距离 多少�? 多少小时 多少�? 多少�?
	 * 下午9:03:34
	 * 
	 * @param str1
	 *            时间参数 1 格式：yyyy-MM-dd HH:mm:ss
	 * @param str2
	 *            时间参数 2 格式：yyyy-MM-dd HH:mm:ss
	 * @return 返回值为：xx天xx小时xx分xx�?
	 */
	public static String getDistanceTime(String str1, String str2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date one;
		Date two;
		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		try {
			one = df.parse(str1);
			two = df.parse(str2);
			long time1 = one.getTime();
			long time2 = two.getTime();
			long diff;
			if (time1 < time2) {
				diff = time2 - time1;
			} else {
				diff = time1 - time2;
			}
			day = diff / (24 * 60 * 60 * 1000);
			hour = (diff / (60 * 60 * 1000) - day * 24);
			min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return day + "�?" + hour + "小时" + min + "�?" + sec + "�?";
	}

	/**
	 * 两个时间相差距离多少天多少小时多少分多少�?
	 * 
	 * @param str1
	 *            时间参数 1 格式�?1990-01-01 12:00:00
	 * @param str2
	 *            时间参数 2 格式�?2009-01-01 12:00:00
	 * @return String 返回值为：xx天xx小时xx分xx�?
	 */
	public static String getDistanceTime(Date enDate, Date noDate) {
		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		long time1 = noDate.getTime();
		long time2 = enDate.getTime();
		long diff;
		if (time1 < time2) {
			diff = time2 - time1;
		} else {
			diff = time1 - time2;
		}
		day = diff / (24 * 60 * 60 * 1000);
		hour = (diff / (60 * 60 * 1000) - day * 24);
		min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
		sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		return day + "�?" + hour + "小时" + min + "�?" + sec + "�?";
	}

}

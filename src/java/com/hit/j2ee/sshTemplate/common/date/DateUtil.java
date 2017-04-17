package com.hit.j2ee.sshTemplate.common.date;

import java.text.DateFormatSymbols;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.hit.j2ee.sshTemplate.common.utils.DetectionUtils;

/**
* 与日期相关操作的工具�?
* @author eagler006 email:eagler006@hotmail.com
* @version  1.1
*
*/
public class DateUtil {

	/*********************** 类型间转�?**************************/

	/**
	* <p> 将字符串格式转换为Date类型，dateformat为null时，默认格式为yyyy-MM-dd<br/>
	* @param sdate 目标字符�?
	* @param dateformat �?��转化的日期格�?
	* @return Date
	* @throws ParseException
	*/
	public static Date String2Date(String sdate, String dateformat) throws ParseException {
		return getSimpleDateFormat(dateformat).parse(sdate);
	}

	/**
	*  <p> 把Date类型转化为字符串格式，dateformat为null时，默认格式为�?yyyy-MM-dd�?br/>
	* @param ddate
	* @param dateformat
	* @return String
	*/
	public static String Date2String(Date ddate, String dateformat) {
		return getSimpleDateFormat(dateformat).format(ddate);
	}


	/**
	* <p> 把美国时间格式，如Jun 11 2010 6:05:243 AM，转化为Date类型<br/>
	* @param sdate
	* @return Date
	* @throws ParseException
	* 
	*/
	public static Date EDate2Date(String sdate) throws ParseException {
		SimpleDateFormat formatter =new SimpleDateFormat("MMM dd yyyy HH:mm:ss",new DateFormatSymbols(Locale.US));
		
		return formatter.parse(sdate);
		
	}

	/**
	* <p> 把Date类型转化为美国时间格式，如Jun 11 2010 6:05:243 AM<br/>
	* @param ddate
	* @return String
	* @throws ParseException
	* 
	*/
	public static String EDate2Date(Date ddate) throws ParseException {
		SimpleDateFormat formatter =new SimpleDateFormat("MMM dd yyyy HH:mm:ss",new DateFormatSymbols(Locale.US));
		Calendar c = Calendar.getInstance();
		c.setTime(ddate);
		return formatter.format(c.getTime());
		
	}
	
	/**
	* <p>把Date型转化为linux时间<br/>
	* @param ddate
	* @return long
	* 
	*/
	public static long Date2Linuxtime(Date ddate) {
		return ddate.getTime();
	}

	/**
	 * <p>把long型的时间转化为Date<br/>
	 * @param ldate
	 * @return Date
	 * @throws ParseException
	 */
	public static Date Linuxtime2Date(long ldate, String dateformat) throws ParseException {
		
		
		 return String2Date(getSimpleDateFormat(dateformat).format(new Date(ldate)),dateformat);
	}

	
	public static Long Date2MysqlLinuxtime(Date ddate) throws ParseException {
	      
	         return Date2Linuxtime(ddate) / 1000;
	     
	 }
	
	public static Date MysqlLinuxtime2Date(long ldate, String dateformat) throws ParseException {
	      
        return Linuxtime2Date(ldate*1000, dateformat);
    
}
	
	/*********************** 获取时间 **************************/

	/**
	 * <p> 获取现在日期<br/>
	 * @param dateformat
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getNowDate(String dateformat) throws ParseException {
		if(DetectionUtils.isBlank(dateformat))
			return new Date();
		return getSimpleDateFormat(dateformat).parse(
				getNowDateStr(dateformat));
	}

	/**
	 *  <p> 获取现在日期<br/>
	 * @param dateformat
	 * @return String
	 */
	public static String getNowDateStr(String dateformat) {
		return getSimpleDateFormat(dateformat).format(new Date());
	}

	

	/**
	 *  <p> 获取现在时间 小时:�?�?HH:mm:ss<br/>
	 * @param dateformat
	 * @return String
	 * @throws ParseException
	 */
	public static String getNowTime(String dateformat) throws ParseException {
		return getSimpleDateFormat(dateformat).format(getNowDate(null));
	}

	
	/**
	 * <p> 获取�?��月的第一�?br/>
	 * 
	 * @param sdate
	 * @return String
	 */
	public static String getBeginDateOfMonth(String sdate) {
		return sdate.substring(0, 8) + "01";
	}

	/**
	 * <p>获取�?��月的�?���?��<br/>
	 * 
	 * @param sdate
	 * @return String
	 * @throws ParseException
	 */
	public static String getEndDateOfMonth(String sdate) throws ParseException {
		String str = sdate.substring(0, 8);
		String month = sdate.substring(5, 7);
		int mon = Integer.parseInt(month);
		if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8
				|| mon == 10 || mon == 12) {
			str += "31";
		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			str += "30";
		} else {
			if (isLeapYear(String2Date(sdate,null))) {
				str += "29";
			} else {
				str += "28";
			}
		}
		return str;
	}

	

	
	/**
	 * <p>获得�?��日期�?��的周的星期几的日期，如要找出2002�?�?日所在周的星期一是几�?br/>
	 * 
	 * @param ddate
	 * @param num
	 * @return String
	 * @throws ParseException
	 */
	public static String getDateInWeek(Date ddate, String num)
			throws ParseException {
		// 再转换为时间
		Calendar c = Calendar.getInstance();
		c.setTime(ddate);
		if (num.equals("1")) // 返回星期�?��在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		else if (num.equals("2")) // 返回星期二所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		else if (num.equals("3")) // 返回星期三所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		else if (num.equals("4")) // 返回星期四所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		else if (num.equals("5")) // 返回星期五所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		else if (num.equals("6")) // 返回星期六所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		else if (num.equals("0")) // 返回星期日所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return getSimpleDateFormat(null).format(c.getTime());
	}

	/**
	 *<p> 根据�?��日期，返回是星期几的字符�?br/>
	 * 
	 * @param ddate
	 * @return String
	 * @throws ParseException
	 */
	public static String getWeekStr(Date ddate) throws ParseException {
		String str = "";
		Calendar c = Calendar.getInstance();
		c.setTime(ddate);
		str = new SimpleDateFormat("EEEE").format(c.getTime());
		if ("1".equals(str)){
			str="星期一";
		} else if ("2".equals(str)) {
			str = "星期二";
		} else if ("3".equals(str)) {
			str = "星期三";
		} else if ("4".equals(str)) {
			str = "星期四";
		} else if ("5".equals(str)) {
			str = "星期五";
		} else if ("6".equals(str)) {
			str = "星期六";
		} else if ("7".equals(str)) {
			str = "星期天";
		}
		return str;
	}

	/**
	 * <p>产生周序�?即得到当前时间所在的年度是第几周<br/>
	 * 
	 * @return String
	 */
	public static String getSeqWeek() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		if (week.length() == 1)
			week = "0" + week;
		
		return week;
	}

	/*********************** 获取时间间隔 **************************/
	

	/**
	 * <p>得到二个日期间的间隔天数<br/>
	 * @param sdate1
	 * @param sdate2
	 * @return long 
	 * @throws ParseException
	 */
	public static long getDiffDate(String sdate1, String sdate2) throws ParseException {

		long day = (getSimpleDateFormat(null).parse(sdate1).getTime() - getSimpleDateFormat(null).parse(sdate2).getTime()) / (24 * 60 * 60 * 1000);
		return day ;
	}

	
	
	
	/**
	 * <p>二个小时时间间的差�?,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟<br/>
	 * @param stime1
	 * @param stime2
	 * @return String  
	 */
	public static String getDiffTime(String stime1, String stime2) {
		String[] kk = null;
		String[] jj = null;
		kk = stime1.split(":");
		jj = stime2.split(":");
		if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
			return "0";
		else {
			double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1])
					/ 60;
			double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1])
					/ 60;
			if ((y - u) > 0)
				return y - u + "";
			else
				return "0";
		}
	}
	
	
	/*********************** 判断时间 **************************/

	/**
	 *<p> 判断是否润年<br/>
	 * 
	 * @param ddate
	 * @return boolean
	 * @throws ParseException
	 */
	public static boolean isLeapYear(Date ddate) throws ParseException {

		/**
		 * 详细设计�?1.�?00整除是闰年，否则�?2.不能�?整除则不是闰�?3.能被4整除同时不能�?00整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰�?
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(ddate);
		int year = gc.get(Calendar.YEAR);
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0) {
			if ((year % 100) == 0)
				return false;
			else
				return true;
		} else
			return false;
	}

	/**
	 * <p>判断二个时间是否在同�?���?br/>
	 * 
	 * @param date1
	 * @param date2
	 * @return boolean
	 */
	public static boolean isSameWeekDates(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (0 == subYear) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
			// 如果12月的�?���?��横跨来年第一周的话则�?���?��即算做来年的第一�?
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		return false;
	}

	/**
	 * <p>判断是否是日期格�?br/>
	 * 
	 * @param sdate
	 * @return boolean
	 */
	public static boolean isDate(String sdate) {

		SimpleDateFormat sdf = null;
		if (sdate == null)
			return false;
		if (sdate.length() > 10) {
			sdf = getSimpleDateFormat(LONGDATEFORMAT);
		} else {
			sdf = getSimpleDateFormat(SHORTDATEFORMAT);
		}
		try {
			sdf.parse(sdate);
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	/*********************** 位移时间 **************************/

	/**
	 * <p>时间前推或后推多少天,其中delay表示天数.<br/>
	 * @param ddate
	 *            Date
	 * @param delay
	 *            int 位移
	 * @param dateformat
	 *            
	 * @throws ParseException
	 * @return String
	 */
	public static String getShiftDay(Date ddate, int delay, String dateformat)
			throws ParseException {

		long myTime = (ddate.getTime() / 1000) + delay * 24 * 60 * 60;
		
		  ddate.setTime(myTime * 1000); 

		return getSimpleDateFormat(dateformat).format(ddate);
	}


	/**
	* <p>时间前推或后推分�?其中delay表示分钟.<br/>
	* @param ddate
	* @param delay
	* @param dateformat
	* @return String
	* @throws ParseException
	* 
	*/
	public static String getShiftTime(Date ddate, int delay, String dateformat) throws ParseException {

			long Time = (ddate.getTime() / 1000) + delay * 60;
			ddate.setTime(Time * 1000);
			return getSimpleDateFormat(dateformat).format(ddate);
	}
	
	/*********************** 日期格式**************************/
	
	/**
	* <p>获取DateFormat格式
	* @param dateformat
	* @return SimpleDateFormat
	* 
	*/
	private static SimpleDateFormat getSimpleDateFormat(String dateformat){
		
		if(DetectionUtils.isBlank(dateformat))
			return new SimpleDateFormat(SHORTDATEFORMAT);
		return new SimpleDateFormat(dateformat);
	}
	
	/**
	*  TIMEFORMAT : HH:mm:ss
	*/
	public final static String TIMEFORMAT="HH:mm:ss";
	
	/**
	*  TIMEFORMAT_ZH : HH时mm分ss�?
	*/
	public final static String TIMEFORMAT_ZH="HH时mm分ss秒";
	
	/**
	*  SHORTDATEFORMAT : yyyy-MM-dd
	*/
	public final static String SHORTDATEFORMAT="yyyy-MM-dd";
	
	/**
	*  SHORTDATEFORMAT_ZH : yyyy年MM月dd�?
	*/
	public final static String SHORTDATEFORMAT_ZH="yyyy年MM月dd日";
	
	/**
	*  LONGDATEFORMAT : yyyy-MM-dd HH:mm:ss
	*/
	public final static String LONGDATEFORMAT="yyyy-MM-dd HH:mm:ss";
	
	/**
	*  LONGDATEFORMAT_ZH : yyyy年MM月dd�?HH时mm分ss�?
	*/
	public final static String LONGDATEFORMAT_ZH="yyyy年MM月dd日HH时mm分ss秒";
	
}

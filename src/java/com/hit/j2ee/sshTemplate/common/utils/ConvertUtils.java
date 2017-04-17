package com.hit.j2ee.sshTemplate.common.utils;

import org.apache.commons.collections.Transformer;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

/**
 * 各种类型相互转化工具�?
 * @author eagler006 eagler006@hotmail.com
 * @version 1.1
 * 
 */
public class ConvertUtils {

	/********************* 转化为字符串 *****************/

	/**
	* 将collection类型转化为带分隔符的字符�?
	* @param coll 集合
	* @param delim 分隔�?
	* @return
	* String
	*/
	public static String Collection2String(Collection coll, String delim) {

		return StringUtils.collectionToDelimitedString(coll, delim);
	}

	/**
	* 将collection类型转化为字符串
	* @param coll 集合
	* @return
	* String
	*/
	public static String Collection2String(Collection coll) {

		return StringUtils.collectionToCommaDelimitedString(coll);
	}

	/**
	* 将数组转化为带分隔符的字符串
	* @param str 
	* @param delim
	* @return
	* String
	*/
	public static String Array2String(Object[] str, String delim) {
		return StringUtils.arrayToDelimitedString(str, delim);
	}

	/**
	* 将数组转化为字符�?
	* @param str
	* @return
	* String
	*/
	public static String Array2String(Object[] str) {
		return StringUtils.arrayToCommaDelimitedString(str);
	}

	/********************* 转化为数�?****************/
	/**
	* 将字符串转化为数组，以�?号为分隔�?
	* @param str
	* @return
	* String[]
	*/
	public static String[] String2Array(String str) {
		return StringUtils.commaDelimitedListToStringArray(str);
	}
	
	/**
	* 将字符串以自定义分隔符方式转化为数组
	* @param str
	* @param delimiters
	* @return
	* String[]
	*/
	public static String[] String2Array(String str, String delimiters) {
		return StringUtils.tokenizeToStringArray(str, delimiters);
	}
	/**
	* 将集合转化为字符串数�?
	* @param collection
	* @return
	* String[]
	*/
	public static String[] Collection2Array(Collection<String> collection) {
		return StringUtils.toStringArray(collection);
	}
	
	/**
	* 将Enumeration转化为字符串数组
	* @param enumeration
	* @return
	* String[]
	*/
	public static String[] Enumeration2Array(Enumeration<String> enumeration) {
		return StringUtils.toStringArray(enumeration);
	}
	
	/**
	* 将字符串数组转化为list链表
	* @param array
	* @return
	* List
	*/
	public static List Array2List(String[] array){
		return CollectionUtils.arrayToList(array);
	}
	
	/********************* 转化为基本类�?****************/
	/**
	* 将字符串数字转化为整�?
	* @param ori
	* @param defaultValue 如果不是字符串数字，则显示defaultValue的�?
	* @return
	* int
	*/
	public static int String2int(String ori, int defaultValue){
		
		return NumberUtils.toInt(ori, defaultValue);
	}
	
	/**
	* 将字符串数字转化为字�?
	* @param ori
	* @param defaultValue 如果无法转化，则显示defaultValue的�?
	* @return
	* byte
	*/
	public static byte String2byte(String ori, byte defaultValue){
		
		return NumberUtils.toByte(ori, defaultValue);
	}
	/**
	* 将字符串数字转化为double类型
	* @param ori
	* @param defaultValue 如果无法转化，则显示defaultValue的�?
	* @return
	* byte
	*/
	public static double String2double(String ori, double defaultValue){
		
		return NumberUtils.toDouble(ori, defaultValue);
	}
	/**
	* 将字符串数字转化为float类型
	* @param ori
	* @param defaultValue 如果无法转化，则显示defaultValue的�?
	* @return
	* byte
	*/
	public static float String2float(String ori, float defaultValue){
		
		return NumberUtils.toFloat(ori, defaultValue);
	}
	
	
	/**
	* 将字符串数字转化为long类型
	* @param ori
	* @param defaultValue
	* @return
	* long
	*/
	public static long String2long(String ori, long defaultValue){
		
		return NumberUtils.toLong(ori, defaultValue);
	}
	
	/**
	* 将字符串数字转化为short类型
	* @param ori
	* @param defaultValue
	* @return
	* short
	*/
	public static short String2short(String ori, short defaultValue){
		
		return NumberUtils.toShort(ori, defaultValue);
	}
	
	
	/********************* 转化为基本对�?****************/
	
	/**
	* 将字符串数字转化为Double对象
	* @param ori
	* @return
	* Double
	*/
	public static Double String2Double(String ori){
		
		return NumberUtils.createDouble(ori);
	}
	
	/**
	* 将字符串数字转化为Number对象
	* @param ori
	* @return
	* Number
	*/
	public static Number String2Number(String ori){
		
		return NumberUtils.createNumber(ori);
	}
	
	/**
	* 将字符串数字转化为Float对象
	* @param ori
	* @return
	* Float
	*/
	public static Float String2Float(String ori){
		
		return NumberUtils.createFloat(ori);
	}
	
	/**
	* 将字符串数字转化为Integer对象
	* @param ori
	* @return
	* Integer
	*/
	public static Integer String2Integer(String ori){
		
		return NumberUtils.createInteger(ori);
	}
	
	
	/**
	* 将字符串数字转化为Long对象
	* @param ori
	* @return
	* Long
	*/
	public static Long String2Long(String ori){
		
		return NumberUtils.createLong(ori);
	}
	
	/**
	* 将字符串数字转化为BigInteger对象
	* @param ori
	* @return
	* BigInteger
	*/
	public static BigInteger String2BigInteger(String ori){
		
		return NumberUtils.createBigInteger(ori);
	}
	
	/**
	* 将字符串数字转化为BigDecimal对象
	* @param ori
	* @return
	* BigDecimal
	*/
	public static BigDecimal String2BigDecimal(String ori){
		
		return NumberUtils.createBigDecimal(ori);
	}
	//�?27.0.0.1形式的IP地址转换成十进制整数，这里没有进行任何错误处�? 
    public static long ip2Long(String Ip) {
    	if(DetectionUtils.isEmpty(Ip))
    		return 0L;
        long[] ip = new long[4]; 
        
        String[] arr = OperateUtils.split(Ip, ".");
        //将每�?之间的字符串转换成整�? 
        ip[0] = Long.parseLong(arr[0]);
        ip[1] = Long.parseLong(arr[1]);
        ip[2] = Long.parseLong(arr[2]);
        ip[3] = Long.parseLong(arr[3]);
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];  
    }  
      
    //将十进制整数形式转换�?27.0.0.1形式的ip地址  
    public static String long2IP(long longIp) {
    	if(longIp==0L)
    		return "";
        StringBuffer sb = new StringBuffer("");
        //直接右移24�? 
        sb.append(String.valueOf((longIp >>> 24)));
        sb.append(".");  
        //将高8位置0，然后右�?6�? 
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");  
        //将高16位置0，然后右�?�? 
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");  
        //将高24位置0  
        sb.append(String.valueOf((longIp & 0x000000FF)));
        return sb.toString();  
    }  
	
    /**
	* 将字符串型集合转化为整形集合
	* @param collection
	* @return
	* String[]
	*/
	public static Collection<Integer> Collection2Collection(Collection<String> collection) {

		Transformer transformer = new Transformer() {
			public Object transform(Object obj) {
				String coll = (String)obj;
				
				return String2Integer(coll.trim());
			}
		};
		// TODO Auto-generated method stub
		return OperateUtils.replacePropertiesofCollection(collection, transformer);
		
	}
	
	/**
	* 将字符串型集合转化为整形集合
	* @param collection
	* @return
	* String[]
	*/
	public static Collection<Long> Collection2LongCollection(Collection<String> collection) {

		Transformer transformer = new Transformer() {
			public Object transform(Object obj) {
				String coll = (String)obj;
				
				return String2Long(coll.trim());
			}
		};
		// TODO Auto-generated method stub
		return OperateUtils.replacePropertiesofCollection(collection, transformer);
		
	}
	
	
	/**
     * 转换编码 ISO-8859-1到GB2312
     * @param text
     * @return
     */
     public String ISO2GB2312(String text) {
     String result = "";
     try {
     result = new String(text.getBytes("ISO-8859-1"), "GB2312");
     }
     catch (UnsupportedEncodingException ex) {
     result = ex.toString();
     }
     return result;
     }

	
     /**
      * 转换编码 GB2312到ISO-8859-1
      * @param text
      * @return
      */
      public String GB2312ISO(String text) {
      String result = "";
      try {
      result = new String(text.getBytes("GB2312"), "ISO-8859-1");
      }
      catch (UnsupportedEncodingException ex) {
      ex.printStackTrace();
      }
      return result;
      }

      /**
       * Utf8URL编码
       * @param s
       * @return
       */
       public String Utf8URLencode(String text) {
       StringBuffer result = new StringBuffer();
       for (int i = 0; i < text.length(); i++) {
       char c = text.charAt(i);
       if (c >= 0 && c <= 255) {
       result.append(c);
       }else {
       byte[] b = new byte[0];
       try {
       b = Character.toString(c).getBytes("UTF-8");
       }catch (Exception ex) {
       }
       for (int j = 0; j < b.length; j++) {
       int k = b[j];
       if (k < 0) k += 256;
       result.append("%" + Integer.toHexString(k).toUpperCase());
       }
       }
       }
       return result.toString();
       }
       /**
        * Utf8URL解码
        * @param text
        * @return
        */
        public String Utf8URLdecode(String text) {
        String result = "";
        int p = 0;
        if (text!=null && text.length()>0){
        text = text.toLowerCase();
        p = text.indexOf("%e");
        if (p == -1) return text;
        while (p != -1) {
        result += text.substring(0, p);
        text = text.substring(p, text.length());
        if (text == "" || text.length() < 9) return result;
        result += CodeToWord(text.substring(0, 9));
        text = text.substring(9, text.length());
        p = text.indexOf("%e");
        }
        }
        return result + text;
        }
        /**
         * utf8URL编码转字�?
         * @param text
         * @return
         */
         private String CodeToWord(String text) {
         String result;
         if (DetectionUtils.Utf8codeCheck(text)) {
         byte[] code = new byte[3];
         code[0] = (byte) (Integer.parseInt(text.substring(1, 3), 16) - 256);
         code[1] = (byte) (Integer.parseInt(text.substring(4, 6), 16) - 256);
         code[2] = (byte) (Integer.parseInt(text.substring(7, 9), 16) - 256);
         try {
         result = new String(code, "UTF-8");
         }catch (UnsupportedEncodingException ex) {
         result = null;
         }
         }
         else {
         result = text;
         }
         return result;
         }

	
	//删除�?��空格�?
	//System.out.println(StringUtils.deleteWhitespace(" s �?�?4j"));
	//移除�?��部分的相同的字符
	//System.out.println(StringUtils.removeStart("www.baidu.com", "www."));
	//移除�?��部分的相同的字符,不区分大小写
	//System.out.println(StringUtils.removeStartIgnoreCase("www.baidu.com", "WWW"));
	//移除后面相同的部�?
	//System.out.println(StringUtils.removeEnd("www.baidu.com", ".com"));
	//移除后面相同的部分，不区分大小写
	//System.out.println(StringUtils.removeEndIgnoreCase("www.baidu.com", ".COM"));
	//移除�?��相同的部�?
	//System.out.println(StringUtils.remove("www.baidu.com/baidu", "bai"));
	//替换指定的字符，只替换第�?��出现�?
	//System.out.println(StringUtils.replaceOnce("www.baidu.com/baidu", "baidu", "hao123"));
	//也是替换，最后一个参数表示替换几�?
	//System.out.println(StringUtils.replace("www.baidu.com/baidu", "baidu", "hao123", 1));
}

package com.hit.j2ee.sshTemplate.common.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

/**
* 用于对object的各种判�?
* @author eagler006 eagler006@hotmail.com
* @version 1.1
*
*/
public class DetectionUtils {
	
	/************************************字符串对象判�?**************************************/
	
	/**
	*判断某字符串是否不为空且长度不为0且不由空白符(whitespace)构成
	* @param  s 字符串对�?
	* @return boolean
	*/
	public static boolean isBlank(String s) {
		return StringUtils.isBlank(s);
	}
	
	/**
	* 判断某字符串是否为空,为空的标准是str==null或str.length()==0
	* @param  s
	* @return boolean
	* 
	*/
	public static boolean isEmpty(String s){
		
		return StringUtils.isEmpty(s);
	}
	
	/**
	* 判断某字符串是否为空白符
	* @param  s
	* @return boolean
	* 
	*/
	public static boolean isWhitespace(String s){
		
		return StringUtils.isWhitespace(s);
	}
	
	/**
	* 判断某字符串是否全由字母组成
	* @param  s
	* @return boolean
	*/
	public static boolean isAlpha(String s){
		
		return StringUtils.isAlpha(s);
	}
	
	/**
	* 判断某字符串是否全由数字组成
	* @param  s
	* @return boolean
	* 
	*/
	public static boolean isNumeric(String s){
		
		return StringUtils.isNumeric(s);
	}
	
	/**
	* �?��字符串是否只有可打印的ASCII编码的的字符
	* @param  s
	* @return boolean
	* 
	*/
	public static boolean isAsciiPrintable(String s){
		
		return StringUtils.isAsciiPrintable(s);
	}
	

	/**
	* �?��字符串是否只有unicode字母和数�?
	* @param  s
	* @return boolean
	*/
	public static boolean isAlphanumeric(String s){
		return StringUtils.isAlphanumeric(s);
	}
	
	/**
	* �?��字符串是否只有unicode字母和数字和空格
	* @param  s
	* @return boolean
	* 
	*/
	public static boolean isAlphanumericSpace(String s){
		return StringUtils.isAlphanumericSpace(s);
	}
	
	
	/**
	* �?��字符串是否只有unicode字母和空�?
	* @param  s
	* @return boolean
	* 
	*/
	public static boolean isAlphaSpace(String s){
		return StringUtils.isAlphaSpace(s);
	}
	
	/**
	* �?��字符串是否只有数字和空格
	* @param  s
	* @return boolean
	*/
	public static boolean isNumericSpace(String s){
		return StringUtils.isNumericSpace(s);
	}
	
	/**
	* �?��字符串是否包含特定字�?
	* @param s
	* @param searchChar
	* @return
	* boolean
	*/
	public static boolean contains(String s, char searchChar){
		return StringUtils.contains(s, searchChar);
	}
	
	
	/**
	*  �?��字符串是否包含特定字符串
	* @param s
	* @param searchStr
	* @return
	* boolean
	*/
	public static boolean contains(String s, String searchStr){
		return StringUtils.contains(s, searchStr);
	}
	
	
	//�?: �?��字符�?参数1)是否包含字符�?参数2), 忽略大小�?
	/**
	* �?��字符�?参数1)是否包含字符�?参数2), 忽略大小�?
	* @param s
	* @param searchStr
	* @return
	* boolean
	*/
	public static boolean containsIgnoreCase(String s, String searchStr){
		return StringUtils.containsIgnoreCase(s, searchStr);
	}
	
	//�?��字符�?参数1)中的字符是否全为字符�?参数2)中的字符的子�?
	/**
	* �?��字符�?参数1)中的字符是否全为字符�?参数2)中的字符的子�?
	* @param s
	* @param searchStr
	* @return
	* boolean
	*/
	public static boolean containsOnly(String s, String searchStr){
		return StringUtils.containsOnly(s, searchStr);
	}
	//�?��字符�?参数1)和字符串(参数2)中的字符是否不存在交�?
	/**
	* �?��字符�?参数1)和字符串(参数2)中的字符是否不存在交�?
	* @param s
	* @param searchStr
	* @return
	* boolean
	*/
	public static boolean containsNone(String s, String searchStr){
		return StringUtils.containsNone(s, searchStr);
	}
	//�?��字符�?参数1)和字符串(参数2)中的字符是否存在交集.
	/**
	* �?��字符�?参数1)和字符串(参数2)中的字符是否存在交集.
	* @param s
	* @param searchStr
	* @return
	* boolean
	*/
	public static boolean containsAny(String s, String searchStr){
		return StringUtils.containsAny(s, searchStr);
	}


	
	/**
	* �?��字符串开始部分是否与二参数相�?
	* @param str1
	* @param str2
	* @return
	* boolean
	*/
	public static boolean startsWith(String str1, String str2){
		return StringUtils.startsWith(str1, str2);
	}
	/**
	* �?��字符串开始部分是否与二参数相同，忽略大小�?
	* @param str1
	* @param str2
	* @return
	* boolean
	*/
	public static boolean startsWithIgnoreCase(String str1, String str2){
		return StringUtils.startsWithIgnoreCase(str1, str2);
	}
	
	/**
	* �?��字符串结尾部分是否与二参数相�?
	* @param str1
	* @param str2
	* @return
	* boolean
	*/
	public static boolean endsWith(String str1, String str2){
		return StringUtils.endsWith(str1, str2);
	}
	/**
	* �?��字符串结尾部分是否与二参数相同，忽略大小�?
	* @param str1
	* @param str2
	* @return
	* boolean
	*/
	public static boolean endsWithIgnoreCase(String str1, String str2){
		return StringUtils.endsWithIgnoreCase(str1, str2);
	}
	/************************************Collection对象判断***************************************/
	
	/**
	* 判断集合是否为空
	* @param  collection 集合对象
	* @return boolean
	* 
	*/
	public static boolean isEmpty(Collection collection) {
		return CollectionUtils.isEmpty(collection);
	}

	
	/**
	* 判断map是否为空
	* @param  map
	* @return boolean
	* 
	*/
	public static boolean isEmpty(Map map) {
		return CollectionUtils.isEmpty(map);
	}

	
	/**
	* 判断Iterator是否包含元素对象element
	* @param iterator
	* @param element
	* @return
	* boolean
	*/
	public static boolean contains(Iterator iterator , Object element){
	
		return CollectionUtils.contains(iterator, element);
	}
	
	/**
	* 判断Enumeration是否包含元素对象element
	* @param enumeration
	* @param element
	* @return
	* boolean
	*/
	public static boolean contains(Enumeration enumeration, Object element){
		
		return CollectionUtils.contains(enumeration, element);
	}
	
	
	/**
	* 判断两个Collection是否存在交集
	* @param source
	* @param candidates
	* @return
	* boolean
	*/
	public static boolean contains(Collection source, Collection candidates){
		
		return CollectionUtils.containsAny(source, candidates);
	}
	/**
	* 判断Collection是否包含元素对象element
	* @param collection
	* @param element
	* @return
	* boolean
	*/
	public static boolean contains(Collection collection, Object element){
		
		return CollectionUtils.containsInstance(collection, element);
	}
	
	
	
	/************************************数组对象判断***************************************/
	
	/**
	* 判断array是否为空
	* @param  array
	* @return boolean
	* 
	*/
	public static boolean isEmpty(Object[] array) {
		return ArrayUtils.isEmpty(array);
	}
	
	/**
	* 判断两个数组是否长度�?��
	* @param  array1
	* @param  array2
	* @return boolean
	* 
	*/
	public static boolean isSameLength(Object[] array1, Object[] array2){
		
		return ArrayUtils.isSameLength(array1, array2);
	}
	
	
	
	/**
	* 判断两个数组元素类型是否�?��
	* @param  array1
	* @param  array2
	* @return boolean
	* 
	*/
	public static boolean isSameType(Object array1, Object array2){
		
		return ArrayUtils.isSameType(array1, array2);
	}
	

	/**
	* 判断数组是否包含元素对象element
	* @param array
	* @param element
	* @return
	* boolean
	*/
	public static boolean contains(Object[] array, Object element){
		
		return ArrayUtils.contains(array, element);
	}
	
	
	/************************************数字对象判断***************************************/
	
	/**
	* 判断是否为整�?
	* @param  s
	* @return boolean
	* 
	*/
	public static boolean isDigits(String s){
		return NumberUtils.isDigits(s);
	}
	
	
	
	
	/**
	* 判断是否为有效数�?
	* @param  s
	* @return boolean
	* 
	*/
	public static boolean isNumber(String s){
		
		return NumberUtils.isNumber(s);
	}

	
	/**
     * 编码是否有效
     * @param text
     * @return
     */
	public static boolean Utf8codeCheck(String text){
     String sign = "";
     if (text.startsWith("%e"))
     for (int i = 0, p = 0; p != -1; i++) {
     p = text.indexOf("%", p);
     if (p != -1)
     p++;
     sign += p;
     }
     return sign.equals("147-1");
     }

	 /**
     * 是否Utf8Url编码
     * @param text
     * @return
     */
	public static boolean isUtf8Url(String text) {
     text = text.toLowerCase();
     int p = text.indexOf("%");
     if (p != -1 && text.length() - p > 9) {
     text = text.substring(p, p + 9);
     }
     return Utf8codeCheck(text);
     }

}

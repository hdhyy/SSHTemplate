package com.hit.j2ee.sshTemplate.common.utils;

import org.apache.commons.lang.math.NumberUtils;

import org.apache.commons.lang3.StringUtils;

import com.hit.j2ee.sshTemplate.common.exception.CustomizeException;

/**
 * 对象比较工具
 * @author eagler006 eagler006@hotmail.com
 * @version 1.1
 *
 */
public class CompareUtils {

	
	/********************* equals操作 *****************/
	/**
	* 字符串是否相�?
	* @param str1
	* @param str2
	* @return boolean
	 * @throws CustomizeException 
	* 
	*/
	public static boolean equals(String str1, String str2) throws CustomizeException {
		if(DetectionUtils.isBlank(str1) || DetectionUtils.isBlank(str2))
			throw new CustomizeException("字符串不能为空");
		return StringUtils.equals(str1, str2);
	}
	/**
	* 字符串是否相等，忽略大小�?
	* @param str1
	* @param str2
	* @return boolean
	 * @throws CustomizeException 
	* 
	*/
	
	public static boolean equalsIgnoreCase(String str1, String str2) throws CustomizeException{
		if(DetectionUtils.isBlank(str1) || DetectionUtils.isBlank(str2))
			throw new CustomizeException("字符串不能为空");
		return StringUtils.equalsIgnoreCase(str1, str2);
	}
	
	/********************* compare操作 *****************/
	/**
	* compare操作，返回�?如为:-1 is obj1<obj2,1 is obj1>obj2,0 is obj1=obj2
	* @param obj1
	* @param obj2
	* @return int
	* 
	*/
	public static int compare(double obj1, double obj2) {	
			return 	NumberUtils.compare(obj1, obj2);
	}
	/**
	* compare操作，返回�?如为:-1 is obj1<obj2,1 is obj1>obj2,0 is obj1=obj2
	* @param obj1
	* @param obj2
	* @return 返回两�?差�?
	* int
	*/
	public static int compare(float obj1, float obj2) {	
		return 	NumberUtils.compare(obj1, obj2);
	}
	
	/********************* max min操作 *****************/
	
	/**
	* 数组类型返回较大�?
	* @param arr 对象可以�?long[]、double[]、float[]、int[]、short[]、byte[]
	* @return Object
	 * @throws CustomizeException 
	* 
	*/
	public static Object max(Object arr) throws CustomizeException{
	//	double[],float[],long[],int[],short[],byte[]
		if(arr instanceof long[])
			return NumberUtils.max((long[]) arr ); 
		else if(arr instanceof double[])
			return NumberUtils.max((double[]) arr ); 
		else if(arr instanceof float[])
			return NumberUtils.max((float[]) arr ); 
		else if(arr instanceof int[])
			return NumberUtils.max((int[]) arr ); 
		else if(arr instanceof short[])
			return NumberUtils.max((short[]) arr ); 
		else if(arr instanceof byte[])
			return NumberUtils.max((byte[]) arr ); 
		else
			throw new CustomizeException("数组类型对象并非�?long[]、double[]、float[]、int[]、short[]、byte[]");
	}
	/**
	* 数组类型返回较小�?
	* @param arr 对象可以�?long[]、double[]、float[]、int[]、short[]、byte[]
	* @return
	* Object
	 * @throws CustomizeException 
	*/
	public static Object min(Object arr) throws CustomizeException{
		//	double[],float[],long[],int[],short[],byte[]
			if(arr instanceof long[])
				return NumberUtils.min((long[]) arr ); 
			else if(arr instanceof double[])
				return NumberUtils.min((double[]) arr ); 
			else if(arr instanceof float[])
				return NumberUtils.min((float[]) arr ); 
			if(arr instanceof int[])
				return NumberUtils.min((int[]) arr ); 
			else if(arr instanceof short[])
				return NumberUtils.min((short[]) arr ); 
			else if(arr instanceof byte[])
				return NumberUtils.min((byte[]) arr ); 
			else
				throw new CustomizeException("数组类型对象并非long[]、double[]、float[]、int[]、short[]、byte[]");
		}
}

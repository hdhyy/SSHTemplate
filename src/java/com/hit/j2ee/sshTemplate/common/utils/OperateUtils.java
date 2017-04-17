package com.hit.j2ee.sshTemplate.common.utils;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 各种类型操作�?
 * @author eagler006 eagler006@hotmail.com
 * @version 1.1
 *
 */
public class OperateUtils {

	/********************* add操作 *****************/
	
	/**
	* 将字符串加入字符串数�?
	* @param array
	* @param str
	* @return
	* String[]
	*/
	public static String[] addStringToArray(String[] array, String str) {

		return StringUtils.addStringToArray(array, str);
	}
	
	/********************* replace操作 *****************/
	
	/**
	* 将字符串挨个按regx替换为rep1
	* @param ori
	* @param regx
	* @param repl
	* @return
	* String
	*/
	public static String replaceEach(String ori, String[] regx, String[] repl) {

		return org.apache.commons.lang3.StringUtils.replaceEach(ori, regx, repl);
	}

	/**
	* 将字符串按regx替换为rep1
	* @param ori
	* @param regx
	* @param repl
	* @return
	* String
	*/
	public static String replace(String ori, String regx, String repl) {

		return org.apache.commons.lang3.StringUtils.replace(ori, regx, repl);
	}
	
	/********************* substring操作 *****************/
	
	/**
	* 取查找到第一次的位置，和第二次的位置中间的字�?
	* @param ori
	* @param var1
	* @param var2
	* @return
	* String
	*/
	public static String substringBetween(String ori, String var1, String var2) {

		return org.apache.commons.lang3.StringUtils.substringBetween(ori,var1,var2);
	}
	
	/**
	* 返回参数二和参数三中间的字符串，返回数组形式
	* @param ori
	* @param var1
	* @param var2
	* @return
	* String[]
	*/
	public static String[] substringsBetween(String ori, String var1, String var2) {

		return org.apache.commons.lang3.StringUtils.substringsBetween(ori, var1, var2);
	}	
	
	/**
	* 从左截取指定长度的字符串
	* @param ori
	* @param len
	* @return
	* String
	*/
	public static String left(String ori, int len) {

		return org.apache.commons.lang3.StringUtils.left(ori,len);
	}
	/**
	* 从右截取指定长度的字符串
	* @param ori
	* @param len
	* @return
	* String
	*/
	public static String right(String ori, int len) {

		return org.apache.commons.lang3.StringUtils.substring(ori,len);
	}
	
	/**
	* 截取到等于第二个参数的字符串为止
	* @param ori
	* @param var1
	* @return
	* String
	*/
	public static String substringBefore(String ori, String var1) {

		return org.apache.commons.lang3.StringUtils.substringBefore(ori,var1);
	}
	/**
	* 从左�?��查到相等的字符开始，保留后边的，不包含等于的字符
	* @param ori
	* @param var1
	* @return
	* String
	*/
	public static String substringAfter(String ori, String var1) {

		return org.apache.commons.lang3.StringUtils.substringAfter(ori,var1);
	}
	
	/**
	* 截取到相等的字符，但是是从右�?��
	* @param ori
	* @param var1
	* @return
	* String
	*/
	public static String substringBeforeLast(String ori, String var1) {

		return org.apache.commons.lang3.StringUtils.substringBeforeLast(ori,var1);
	}
	/**
	* 从右�?��，但是保留右边的字符
	* @param ori
	* @param var1
	* @return
	* String
	*/
	public static String substringAfterLast(String ori, String var1) {

		return org.apache.commons.lang3.StringUtils.substringAfterLast(ori,var1);
	}
	
	
	/**
	* 截取指定位置的字�?
	* @param ori
	* @param len
	* @return
	* String
	*/
	public static String substring(String ori, int len) {

		return org.apache.commons.lang3.StringUtils.substring(ori,len);
	}
	/**
	* 截取指定区间的字�?
	* @param ori
	* @param start
	* @param len
	* @return
	* String
	*/
	public static String substring(String ori, int start, int len) {

		return org.apache.commons.lang3.StringUtils.substring(ori,start,len);
	}
	
	/**
	* 将字符串倒序排列
	* @param ori
	* @return
	* String
	*/
	public static String reverse(String ori) {

		return org.apache.commons.lang3.StringUtils.reverse(ori);
	}
	
	//根据特定字符(二参�?分隔进行反转
	//System.out.println(StringUtils.reverseDelimited("�?�?人民", ':'));
	/**
	* 根据特定字符(二参�?分隔进行反转
	* @param ori
	* @param separatorChar
	* @return
	* String
	*/
	public static String reverse(String ori, char separatorChar) {

		return org.apache.commons.lang3.StringUtils.reverseDelimited(ori, separatorChar);
	}
	
	/**
	* 根据特定字符(二参�?分隔进行反转
	* @param ori
	* @param separatorChars
	* @return
	* String
	*/
	public static String reverseDelimitedString(String ori, String separatorChars) {

		return org.apache.commons.lang.StringUtils.reverseDelimitedString(ori, separatorChars);
	}
	
	/**
	* 查询字符串中指定字符�?参数�?出现的次�?
	* @param ori
	* @param var1
	* @return
	* int
	*/
	public static int countMatches(String ori, String var1){
		
		return org.apache.commons.lang3.StringUtils.countMatches(ori,var1);
	}
	
	/********************* trim操作 *****************/
	
	//去除字符串头尾空�?包括全角空格、TAB)
	/**
	* 去除字符串头尾空�?包括全角空格、TAB)
	* @param ori
	* @return
	* String
	*/
	public static String trim(String ori){
		
		return org.apache.commons.lang3.StringUtils.trim(ori);
	}
	//去空格，将Null�?" 转换为Null
	/**
	* 去空格，将Null�?" 转换为Null
	* @param ori
	* @return
	* String
	*/
	public static String trimToNull(String ori){
		
		return org.apache.commons.lang3.StringUtils.trimToNull(ori);
	}
	
	/**
	* 去空格，将Null�?" 转换�?"
	* @param ori
	* @return
	* String
	*/
	public static String trimToEmpty(String ori){
		
		return org.apache.commons.lang3.StringUtils.trimToEmpty(ori);
	}
	/********************* strip操作 *****************/
	
	/**
	* 去掉var1
	* @param ori
	* @param var1
	* @return
	* String
	*/
	public static String strip(String ori, String var1) {

		return org.apache.commons.lang3.StringUtils.strip(ori,var1);
	}
	
	/**
	* 去掉空格
	* @param ori
	* @return
	* String
	*/
	public static String strip(String ori) {

		return org.apache.commons.lang3.StringUtils.strip(ori);
	}
	
	/**
	* �?"和null转换为Null
	* @param ori
	* @return
	* String
	*/
	public static String stripToNull(String ori) {

		return org.apache.commons.lang3.StringUtils.stripToNull(ori);
	}
	
	/**
	* �?"和null转换�?"
	* @param ori
	* @return
	* String
	*/
	public static String stripToEmpty(String ori) {

		return org.apache.commons.lang3.StringUtils.stripToEmpty(ori);
	}

	/**
	* 返回可以处理null的toString()
	* @param ori
	* @return
	* String
	*/
	public static String defaultString(String ori) {

		return org.apache.commons.lang3.StringUtils.defaultString(ori);
	}
	/**
	* 仅当字符串为Null�?转换为指定的字符�?二参�?
	* @param ori
	* @return
	* String
	*/
	public static String defaultString(String ori, String var1) {

		return org.apache.commons.lang3.StringUtils.defaultString(ori,var1);
	}
	/**
	*  对字符串�?��去var1,如果第二个参数为null只去后面空格
	* @param ori
	* @param var1
	* @return
	* String
	*/
	public static String stripStart(String ori, String var1) {

		return org.apache.commons.lang3.StringUtils.stripStart(ori,var1);
	}
	
	/**
	* 对字符串结尾去var1,如果第二个参数为null只去后面空格
	* @param ori
	* @param var1
	* @return
	* String
	*/
	public static String stripEnd(String ori, String var1) {

		return org.apache.commons.lang3.StringUtils.stripEnd(ori,var1);
	}
	/**
	* 对数组每个字符串进行去var1，如果第二个参数为null.对数组每个字符串进行去空�?
	* @param ori
	* @param var1
	* @return
	* String[]
	*/
	public static String[] stripAll(String[] ori, String var1) {

		return org.apache.commons.lang3.StringUtils.stripAll(ori,var1);
	}
	
	/**
	* 对数组每个字符串进行去空�?
	* @param ori
	* @return
	* String[]
	*/
	public static String[] stripAll(String[] ori) {

		return org.apache.commons.lang3.StringUtils.stripAll(ori);
	}

	
	/**
	* 去除字符串中的空�?包括全角空格、TAB)
	* @param ori
	* @return
	* String
	*/
	public static String deleteWhitespace(String ori) {

		return org.apache.commons.lang3.StringUtils.deleteWhitespace(ori);
	}

	
	/*********************生成特定字符串操�?*****************/
	/**
	* 生成以separator填充的长度为n的字符串
	* @param separator
	* @param n
	* @return
	* String
	*/
	public static String repeat(String separator, int n){
		
		return org.apache.commons.lang3.StringUtils.repeat(separator, n);
	}
	
	/**
	* 生成以separator填充的长度为n的字符串
	* @param separator
	* @param n
	* @return
	* String
	*/
	public static String repeat(String separator, String var1, int n){
		
		return org.apache.commons.lang3.StringUtils.repeat(separator, var1, n);
	}
	
	/**
	* 字符串ori以自定义n长度居中，剩余部分以separator填充
	* @param ori
	* @param n
	* @param separator
	* @return
	* String
	*/
	public static String center(String ori, int n, String separator){
		
		return org.apache.commons.lang3.StringUtils.center(ori, n,separator);
	}
	
	/**
	* 将数组以separator形式拼接为字符串
	* @param s
	* @param separator
	* @return
	* String
	*/
	public static String join(Object[] s, String separator){
		return org.apache.commons.lang3.StringUtils.join(s, separator);
	}
	/**
	* �?��字符串缩减，原字符串长度小于len个字符长，则该方法将返回原文本．若原字符串长度大于len个字符，则显示len个字符和3个省�?
	* @param str
	* @param len
	* @return
	* String
	*/
	public static String abbreviate(String str, int len) {

		return org.apache.commons.lang3.StringUtils.abbreviate(str,len);
	}
	/**
	* �?��字符串在偏移offset之后缩减，原字符串长度小于len个字符长，则该方法将返回原文本．若原字符串长度大于len个字符，则显示len个字符和3个省�?
	* @param str
	* @param offset
	* @param len
	* @return
	* String
	*/
	public static String abbreviate(String str, int offset, int len) {

		return org.apache.commons.lang3.StringUtils.abbreviate(str, offset, len);
	}

	/*********************index操作 *****************/
	
	/**
	* 从头�?��，返回第�?��符合要求字符的位�?
	* @param str
	* @param searchChar
	* @return
	* int
	*/
	public static int indexOf(String str, char searchChar) {

		return org.apache.commons.lang3.StringUtils.indexOf(str, searchChar);
	}
	
	/**
	* 从结尾开始，返回第一个符合要求字符的位置
	* @param str
	* @param searchChar
	* @return
	* int
	*/
	public static int lastIndexOf(String str, char searchChar) {

		return org.apache.commons.lang3.StringUtils.lastIndexOf(str, searchChar);
	}
	
	/**
	* 从指定len位置�?��，返回第�?��符合要求字符的位�?
	* @param str
	* @param searchChar
	* @param len
	* @return
	* int
	*/
	public static int indexOf(String str, char searchChar, int len) {

		return org.apache.commons.lang3.StringUtils.indexOf(str, searchChar,len);
	}
	
	/**
	* 从指定len位置�?��，从结尾�?��返回第一个符合要求字符的位置
	* @param str
	* @param searchChar
	* @param len
	* @return
	* int
	*/
	public static int lastIndexOf(String str, char searchChar, int len) {

		return org.apache.commons.lang3.StringUtils.lastIndexOf(str, searchChar,len);
	}
	
	
	/**
	* 返回第一个符合要求字符串的位�?
	* @param str
	* @param searchStr
	* @return
	* int
	*/
	public static int indexOf(String str, String searchStr) {

		return org.apache.commons.lang3.StringUtils.indexOf(str, searchStr);
	}
	
	/**
	* 从结尾开始返回第�?��符合要求字符串的位置
	* @param str
	* @param searchStr
	* @return
	* int
	*/
	public static int lastIndexOf(String str, String searchStr) {

		return org.apache.commons.lang3.StringUtils.lastIndexOf(str, searchStr);
	}
	/**
	* 从指定len位置�?��，返回第�?��符合要求字符串的位置
	* @param str
	* @param searchStr
	* @param len
	* @return
	* int
	*/
	public static int indexOf(String str, String searchStr, int len) {

		return org.apache.commons.lang3.StringUtils.indexOf(str, searchStr,len);
	}
	/**
	* 从指定len位置�?��，从结尾�?��返回第一个符合要求字符串的位�?
	* @param str
	* @param searchStr
	* @param len
	* @return
	* int
	*/
	public static int lastIndexOf(String str, String searchStr, int len) {

		return org.apache.commons.lang3.StringUtils.lastIndexOf(str, searchStr,len);
	}
	/**
	* 从指定len位置�?��，返回第�?��符合要求字符串的位置，忽略大小写
	* @param str
	* @param searchStr
	* @param len
	* @return
	* int
	*/
	public static int indexOfIgnoreCase(String str, String searchStr, int len) {

		return org.apache.commons.lang3.StringUtils.indexOfIgnoreCase(str, searchStr,len);
	}
	
	/**
	* 从指定len位置�?��，从结尾�?��返回第一个符合要求字符串的位置，忽略大小�?
	* @param str
	* @param searchStr
	* @param len
	* @return
	* int
	*/
	public static int lastIndexOfIgnoreCase(String str, String searchStr, int len) {

		return org.apache.commons.lang3.StringUtils.lastIndexOfIgnoreCase(str, searchStr,len);
	}
	
	/**
	* 返回第一个符合要求字符串的位置，忽略大小�?
	* @param str
	* @param searchStr
	* @return
	* int
	*/
	public static int indexOfIgnoreCase(String str, String searchStr) {

		return org.apache.commons.lang3.StringUtils.indexOfIgnoreCase(str, searchStr);
	}
	/**
	* 从结尾开始返回第�?��符合要求字符串的位置，忽略大小写
	* @param str
	* @param searchStr
	* @return
	* int
	*/
	public static int lastIndexOfIgnoreCase(String str, String searchStr) {

		return org.apache.commons.lang3.StringUtils.lastIndexOfIgnoreCase(str, searchStr);
	}
	
	/**
	* 返回两字符串不同处索引号位置
	* @param str1
	* @param str2
	* @return
	* int
	*/
	public static int indexOfDifference(String str1, String str2) {

		return org.apache.commons.lang3.StringUtils.indexOfDifference(str1, str2);
	}
	
	/**
	* 返回字符�?参数2)不同于字符串(参数1)的那部分字符�?
	* @param str1
	* @param str2
	* @return
	* String
	*/
	public static String difference(String str1, String str2) {

		return org.apache.commons.lang3.StringUtils.difference(str1, str2);
	}
	

	/**
	* 返回字符�?参数1)去掉字符�?参数2)后的那部分字符串,    如果字符�?参数1)不是以字符串(参数2)结尾则返回原�?
	* @param str1
	* @param str2
	* @return
	* String
	*/
	public static String chomp(String str1, String str2) {

		return org.apache.commons.lang3.StringUtils.chomp(str1, str2);
	}

	/********************* slipt操作 *****************/
	/**
	* 字符串按字符分隔符类型切分为字符串数�?
	* @param str
	* @param separatorChar
	* @return
	* String[]
	*/
	public static String[] split(String str, char separatorChar) {

		return org.apache.commons.lang3.StringUtils.split(str, separatorChar);
	}
	
	/**
	* 字符串按字符串分隔符类型切分为字符串数组
	* @param str
	* @param separatorChars
	* @return
	* String[]
	*/
	public static String[] split(String str, String separatorChars) {

		return org.apache.commons.lang3.StringUtils.split(str, separatorChars);
	}
	
	/**
	* 替换集合中某些字段的�?
	* @param inputCollection
	* @param transformer
	* @return
	* Collection
	*/
	public static Collection replacePropertiesofCollection(Collection inputCollection, Transformer  transformer){
		
		return CollectionUtils.collect(inputCollection, transformer);
		
	}
	
	public static void addCollection(Collection collection, Object[]  elements){
		
		 CollectionUtils.addAll(collection, elements);
		
	}
	
	/**
	 * 提取集合中的对象的两个属�?通过Getter函数), 组合成Map.
	 * 
	 * @param collection 来源集合.
	 * @param keyPropertyName 要提取为Map中的Key值的属�?�?
	 * @param valuePropertyName 要提取为Map中的Value值的属�?�?
	 */
	public static Map extractToMap(final Collection collection, final String keyPropertyName,
								   final String valuePropertyName) {
		Map map = new HashMap(collection.size());

		try {
			for (Object obj : collection) {
				map.put(PropertyUtils.getProperty(obj, keyPropertyName),
						PropertyUtils.getProperty(obj, valuePropertyName));
			}
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}

		return map;
	}

	/**
	 * 提取集合中的对象的一个属�?通过Getter函数), 组合成List.
	 * 
	 * @param collection 来源集合.
	 * @param propertyName 要提取的属�?�?
	 */
	public static List extractToList(final Collection collection, final String propertyName) {
		List list = new ArrayList(collection.size());

		try {
			for (Object obj : collection) {
				list.add(PropertyUtils.getProperty(obj, propertyName));
			}
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}

		return list;
	}

	/**
	 * 提取集合中的对象的一个属�?通过Getter函数), 组合成由分割符分隔的字符�?
	 * 
	 * @param collection 来源集合.
	 * @param propertyName 要提取的属�?�?
	 * @param separator 分隔�?
	 */
	public static String extractToString(final Collection collection, final String propertyName, final String separator) {
		List list = extractToList(collection, propertyName);
		return StringUtils.collectionToDelimitedString(list, separator);
	}

	/**
	 * 转换Collection�?��元素(通过toString())为String, 中间�?separator分隔�?
	 */
	public static String convertToString(final Collection collection, final String separator) {
		return StringUtils.collectionToDelimitedString(collection, separator);
	}

	/**
	 * 转换Collection�?��元素(通过toString())为String, 每个元素的前面加入prefix，后面加入postfix，如<div>mymessage</div>�?
	 */
	public static String convertToString(final Collection collection, final String prefix, final String postfix) {
		StringBuilder builder = new StringBuilder();
		for (Object o : collection) {
			builder.append(prefix).append(o).append(postfix);
		}
		return builder.toString();
	}


	/**
	 * 取得Collection的第�?��元素，如果collection为空返回null.
	 */
	public static <T> T getFirst(Collection<T> collection) {
		if (DetectionUtils.isEmpty(collection)) {
			return null;
		}

		return collection.iterator().next();
	}

	/**
	 * 获取Collection的最后一个元�?，如果collection为空返回null.
	 */
	public static <T> T getLast(Collection<T> collection) {
		if (DetectionUtils.isEmpty(collection)) {
			return null;
		}

		//当类型为List时，直接取得�?���?��元素 �?
		if (collection instanceof List) {
			List<T> list = (List<T>) collection;
			return list.get(list.size() - 1);
		}

		//其他类型通过iterator滚动到最后一个元�?
		Iterator<T> iterator = collection.iterator();
		while (true) {
			T current = iterator.next();
			if (!iterator.hasNext()) {
				return current;
			}
		}
	}

}

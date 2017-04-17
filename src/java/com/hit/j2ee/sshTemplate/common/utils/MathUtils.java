package com.hit.j2ee.sshTemplate.common.utils;

import org.apache.commons.lang.math.NumberRange;
import org.apache.commons.lang.math.Range;
import org.apache.commons.lang3.math.Fraction;
import org.apache.commons.math3.stat.StatUtils;

/**
 * 统计工具
 * 
 * @author eagler006 eagler006@hotmail.com
 * @version 1.1
 * 
 */
public class MathUtils {

	public static double averangeVariance(double[] a,double[] b, int n){
		double result = 0;
		for (int i=0;i<n;i++){
			result += (abs(a[i])/10000-abs(b[i])/10000)*(abs(a[i])/10000-abs(b[i])/10000);
		}
		return result/n;
	}

	public static double abs(double a){
		if (a>0) return a; else return -a;
	}


	public static int getASmallestPowerOf2(int a){
		int result = 1;
		while (result < a)
			result = result<<1;
		return result;
	}

	/**
	 * a是否为b的整次方
	 * @param a,b
	 * @return boolean
     */
	public static boolean isAPowerOfB(int a,int b){
		while (a>=b){
			if (a % b != 0) return false;
			a /= b;
		}
		return true;
	}

	/**
	 * 获取向量的模长
	 * @param a
	 * @param b
     * @return
     */
	public static double getModulus(double a,double b){
		return Math.sqrt(a*a+b*b);
	}

	/**
	 * 获取double数组的平均数
	 * 
	 * @param d
	 * @return double
	 */
	public static double mean(double[] d) {

		return StatUtils.mean(d);

	}

	/**
	 * 获取double数组的积
	 * 
	 * @param d
	 * @return double
	 */
	public static double product(double[] d) {

		return StatUtils.product(d);

	}
	/**
	 * 获取double数组的和
	 * 
	 * @param d
	 * @return double
	 */
	public static double sum(double[] d) {

		return StatUtils.sum(d);

	}

	/**
	 * 获取double数组的方�?
	 * 
	 * @param d
	 * @return double
	 */
	public static double variance(double[] d) {

		return StatUtils.variance(d);

	}

	/********************* 两数相加 *****************/
	/**
	* 两double类型数相�?
	* @param d1
	* @param d2
	* @return
	* double
	*/
	public static double add(double d1, double d2) {

		return getFraction(d1).add(getFraction(d2)).doubleValue();

	}
	/**
	* 两double类型数相�?
	* @param d1
	* @param d2
	* @return
	* double
	*/
	public static double sub(double d1, double d2) {

		return getFraction(d1).subtract(getFraction(d2)).doubleValue();

	}
	/**
	* 两double类型数相�?
	* @param d1
	* @param d2
	* @return
	* double
	*/
	public static double multi(double d1, double d2) {

		return getFraction(d1).multiplyBy(getFraction(d2)).doubleValue();

	}
	/**
	* 两double类型数相�?
	* @param d1
	* @param d2
	* @return
	* double
	*/
	public static double divide(double d1, double d2) {

		return getFraction(d1).divideBy(getFraction(d2)).doubleValue();

	}

	public static Fraction getFraction(int numerator, int denominator) {
		return Fraction.getFraction(numerator, denominator);
	}

	public static Fraction getFraction(double d1) {
		return Fraction.getFraction(d1);
	}

	/********************* 判断是否在范围之�?*****************/

	/**
	* 判断数字arg0是否在数字r1-r2之间
	* @param r1
	* @param r2
	* @param arg0
	* @return
	* boolean
	*/
	public static boolean isRang(Number r1, Number r2, Number arg0) {

		Range normalScoreRange = new NumberRange(r1, r2);
		return normalScoreRange.containsNumber(arg0);

	}

}

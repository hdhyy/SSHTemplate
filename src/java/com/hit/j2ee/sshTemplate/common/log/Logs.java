package com.hit.j2ee.sshTemplate.common.log;

import org.slf4j.Logger;

//import sun.reflect.Reflection;

/**
* 日志记录类，�?��合log4j使用
* @author eagler006 email:eagler006@hotmail.com
* @version  1.1
*
*/
public final class Logs {

	private Logs() {
	}

	/*
	 * 
	 * 0是getCallerClass自身，即Reflection�?1是bean自身，即调用Reflect的Bean自身�?2就应该是bean的调用方
	 * 3 不确�?
	 */
	/**
	* 输出debug日志
	* @param obj �?��出的日志
	* void
	*/
	public static void debug(String obj) {
//		log = LoggerFactory.getLogger(Reflection.getCallerClass(2));
//		log.debug(obj);
	}

	/**
	* 输出debug日志
	* @param pattern 输出格式以{}代表�?��输入的对�?
	* @param args 对象数组
	* void
	*/
	public static void debug(String pattern, Object args[]) {
//		log = LoggerFactory.getLogger(Reflection.getCallerClass(2));
//		log.debug(pattern, args);
	}
	/**
	* 输出error日志
	* @param obj �?��出的日志
	* void
	*/
	public static void error(String obj) {
//		log = LoggerFactory.getLogger(Reflection.getCallerClass(2));
//		log.error(obj);
	}
	/**
	* 输出error日志
	* @param pattern 输出格式以{}代表�?��输入的对�?
	* @param args 对象数组
	* void
	*/
	public static void error(String pattern, Object args[]) {
//		log = LoggerFactory.getLogger(Reflection.getCallerClass(2));
//		log.error(pattern, args);

	}
	/**
	* 输出info日志
	* @param obj �?��出的日志
	* void
	*/
	public static void info(String obj) {
//		log = LoggerFactory.getLogger(Reflection.getCallerClass(2));
//		log.info(obj);
	}
	/**
	* 输出info日志
	* @param pattern 输出格式以{}代表�?��输入的对�?
	* @param args 对象数组
	* void
	*/
	public static void info(String pattern, Object args[]) {
//		log = LoggerFactory.getLogger(Reflection.getCallerClass(2));
//		log.info(pattern, args);

	}
	/**
	* 输出warn日志
	* @param obj �?��出的日志
	* void
	*/
	public static void warn(String obj) {
//		log = LoggerFactory.getLogger(Reflection.getCallerClass(2));
//		log.warn(obj);
	}
	/**
	* 输出warn日志
	* @param pattern 输出格式以{}代表�?��输入的对�?
	* @param args 对象数组
	* void
	*/
	public static void warn(String pattern, Object args[]) {
//		log = LoggerFactory.getLogger(Reflection.getCallerClass(2));
//		log.warn(pattern, args);

	}

	private static Logger log = null;

}
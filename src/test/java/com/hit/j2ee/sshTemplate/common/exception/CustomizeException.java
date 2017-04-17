package com.hit.j2ee.sshTemplate.common.exception;

/**
 * 自定义异常处理
 * @author eagler006 eagler006@hotmail.com
 * @version 1.1
 * 
 */
public class CustomizeException extends Exception {

	/**
	 * <p>
	 * Description: 带自定义错误信息的输出
	 * </p>
	 * 
	 * @param message 自定义错误信息
	 */
	public CustomizeException(final String message) {

		super(message);

	}

	/**
	 * <p>
	 * Description: 自定义错误信息和异常抛出
	 * </p>
	 * 
	 * @param message 自定义错误信息
	 * @param cause 自定义异常抛出
	 */
	public CustomizeException(final String message, final Throwable cause) {

		super(message, cause);

	}

	/**
	 * <p>
	 * Description: 只有异常抛出
	 * </p>
	 * 
	 * @param cause
	 */
	public CustomizeException(final Throwable cause) {

		super(cause);
	}

}

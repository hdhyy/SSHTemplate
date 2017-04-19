package com.hit.j2ee.sshTemplate.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.hit.j2ee.sshTemplate.pojo.User;

/**
 * session工具类
 * @author HD
 *
 */
public class SessionUtill {

	/**
	 * 验证码匹配判断
	 * @param request
	 * @return
	 */
	public static boolean isCodeMatch(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session == null){
			return false;
		}
		//获取验证码
		String existCode = (String)session.getAttribute(ConstUtil.KEY_VERIFICATION_CODE);
		if(StringUtils.isBlank(existCode)){
			return false;
		}
		
		String inputCode = request.getParameter("verificationCode");
		if(StringUtils.isBlank(inputCode)){
			return false;
		}
		
		return existCode.equalsIgnoreCase(inputCode);
	}
	/**
	 * 用户信息存入session
	 * @param request
	 * @param user
	 */
	public static void setUserToSession(HttpServletRequest request,User user){
		HttpSession session = request.getSession();
		if(user == null){
			return;
		}
		session.setAttribute(ConstUtil.KEY_USER_INFO, user);
	}
	/**
	 * d得到session中的用户对象
	 * @param request
	 * @return
	 */
	public static User getUserFromSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session == null){
			return null;
		}
		return (User)session.getAttribute(ConstUtil.KEY_USER_INFO);
	}
	
	/**
	 * 用户注销，去除session中用户信息
	 * @param request
	 */
	public static void removeUserFromSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session == null){
			return ;
		}
		session.removeAttribute(ConstUtil.KEY_USER_INFO);
	}
	
	
	
	
	
	
	
}

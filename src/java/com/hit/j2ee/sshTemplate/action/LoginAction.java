package com.hit.j2ee.sshTemplate.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hit.j2ee.sshTemplate.common.ConstUtil;
import com.hit.j2ee.sshTemplate.service.UserService;

@Namespace("/login")
@ParentPackage(value="struts-default")
@Results({
    @Result(name="success" , location=ConstUtil.BASE_JSP_PATH+"index1.jsp"),
    @Result(name="error" , location=ConstUtil.BASE_JSP_PATH+"login.jsp")
})
@Controller(value="loginAction")
@Scope(value="prototype")
public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private UserService userService;
	
	private String userName;
	private String password;
	private String verificationCode;
	
	@Action("login")
	public String init(){
		return "Login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

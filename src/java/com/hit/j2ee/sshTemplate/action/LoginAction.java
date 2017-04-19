package com.hit.j2ee.sshTemplate.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hit.j2ee.sshTemplate.service.UserService;

@SuppressWarnings("serial")
@Controller
public class LoginAction extends BaseAction {

	@Resource
	private UserService userService;
	
	private String userName;
	private String password;
	private String verificationCode;
	
	
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

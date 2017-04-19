package com.hit.j2ee.sshTemplate.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hit.j2ee.sshTemplate.service.UserService;

@SuppressWarnings("serial")
@Controller
public class LoginAction extends BaseAction {

	@Resource
	private UserService userService;
	
	
}

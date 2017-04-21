package com.hit.j2ee.sshTemplate.action;

import java.io.UnsupportedEncodingException;



import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hit.j2ee.sshTemplate.common.ConstUtil;
import com.hit.j2ee.sshTemplate.service.UserService;

  
@Namespace("/user")
@ParentPackage(value="struts-default")
@Results({
    @Result(name="success" , location=ConstUtil.BASE_JSP_PATH+"index.jsp"),
    @Result(name="error" , location=ConstUtil.BASE_JSP_PATH+"login.jsp")
})
@Controller(value="userAction")
@Scope(value="prototype")
@AllowedMethods
public class UserAction extends BaseAction {

    private static final long serialVersionUID = 1L;
  
    @Resource
	private UserService userService;
    
    public String execute(){
        return SUCCESS;
    }  
    
    @Action("login")
    public String login() {
        try {
            request = ServletActionContext.getRequest();
            response = ServletActionContext.getResponse();  
            request.setCharacterEncoding("UTF-8");  
            response.setContentType("text/html;charset=utf-8");  
            String username = request.getParameter("username");  
            String password = request.getParameter("password");  
            userService.isUserNameExist("hd");
            System.out.println("name->" + username + ",password->"  
                    + password);  
            if ("admin".equals(username) && "123456".equals(password)) {  
                return SUCCESS;
            } else {  
                return ERROR;
            } 
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return SUCCESS;  
    }  
}  
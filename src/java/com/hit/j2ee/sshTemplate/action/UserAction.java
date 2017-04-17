package com.hit.j2ee.sshTemplate.action;

import java.io.UnsupportedEncodingException;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;  
  
@Namespace("/main/user")
@ParentPackage(value="struts-default")
@Results({
    @Result(name="success" , location="/main/desktop/desktop.jsp"),
    @Result(name="fail" , location="/main/user/login.jsp")
})
@Service(value="userAction")
@Scope(value="prototype")
public class UserAction extends ActionSupport {  
  
    private static final long serialVersionUID = 1L;  
  
    public String execute(){  
        return SUCCESS;  
    }  
      
    public String login() {
        try {  
            HttpServletRequest request = ServletActionContext.getRequest();  
            HttpServletResponse response = ServletActionContext.getResponse();  
            request.setCharacterEncoding("UTF-8");  
            response.setContentType("text/html;charset=utf-8");  
            String username = request.getParameter("username");  
            String password = request.getParameter("password");  
            System.out.println("name->" + username + ",password->"  
                    + password);  
            if ("admin".equals(username) && "123456".equals(password)) {  
                return SUCCESS;
            } else {  
                return "login";  
            }  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return SUCCESS;  
    }  
}  
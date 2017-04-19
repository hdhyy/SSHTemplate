package com.hit.j2ee.sshTemplate.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.j2ee.sshTemplate.common.SessionUtill;
import com.hit.j2ee.sshTemplate.pojo.User;

public class LoginCheckFilter implements Filter{

	//存放登录才能查看的地址
	private List<String> pathsNeedLogin;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//添加需要登录才能访问的地址
		pathsNeedLogin = new ArrayList<String>();
		pathsNeedLogin.add("/login_logout.do");
		pathsNeedLogin.add("/upload_init.do");	
		pathsNeedLogin.add("/upload_upload.do");	
		pathsNeedLogin.add("/player_comment.do");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String path = req.getServletPath();
		if(!pathsNeedLogin.contains(path)){
			chain.doFilter(req, res);
			return ;
		}
		/*登录才能访问*/
		User user = SessionUtill.getUserFromSession(req);
		if(user != null){
			chain.doFilter(req, res);
		}
		else{
			res.sendRedirect(req.getContextPath()+"/login_init.do");
		}
		
	}

	@Override
	public void destroy() {
		
	}

}

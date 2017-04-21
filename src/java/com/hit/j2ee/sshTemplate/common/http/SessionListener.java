package com.hit.j2ee.sshTemplate.common.http;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

/**
* 会话监听工具，可用于application范围中取出sessions集合，或获取当前活动的session数，即为“在线人数�?
* @author eagler006 email:eagler006@hotmail.com
* @version  1.1
*
*/
public class SessionListener implements HttpSessionListener {



	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		 HttpSession session = event.getSession();
         ServletContext servletContext = session.getServletContext();
         
         // 在application范围由一个HashSet集保存所有的session
         HashSet sessions = (HashSet) servletContext.getAttribute("sessions");
         if (sessions == null) {
                sessions = new HashSet();
                servletContext.setAttribute("sessions", sessions);
         }
         
         // 新创建的session均添加到HashSet集中
         sessions.add(session);
	}


	public void sessionDestroyed(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		HttpSession session = event.getSession();
        ServletContext servletContext = session.getServletContext();
        HashSet sessions = (HashSet) servletContext.getAttribute("sessions");
        
        // �?��的session均从HashSet集中移除
        sessions.remove(session);
	}

}

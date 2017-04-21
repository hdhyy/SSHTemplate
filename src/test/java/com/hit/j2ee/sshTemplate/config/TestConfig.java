package java.com.hit.j2ee.sshTemplate.config;

import java.util.Enumeration;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;

import org.apache.struts2.dispatcher.filter.FilterHostConfig;

public class TestConfig {

	public static void main(String[] args) {
		FilterConfig filterConfig = new FilterConfig() {
			
			@Override
			public ServletContext getServletContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Enumeration<?> getInitParameterNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getInitParameter(String name) {
				return "config/struts2/struts.xml";
			}
			
			@Override
			public String getFilterName() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		FilterHostConfig config = new FilterHostConfig(filterConfig);
	}

}

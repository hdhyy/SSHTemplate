package com.hit.j2ee.sshTemplate.common.http;

import javax.servlet.*;
import java.io.IOException;

/**
 * Example filter that sets the character encoding to be used in parsing the
 * incoming request
 */

/**
* 编码过滤器，目前定义为utf-8
* @author eagler006 email:eagler006@hotmail.com
* @version  1.1
*
*/
public class SetCharacterEncodingFilter implements Filter {

   
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
    FilterChain chain)throws IOException, ServletException {
    //设置编码
    request.setCharacterEncoding("utf-8");
  //  System.out.println("filter is encoding....");
    // 传�?控制到下�?��过滤�?    chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }
}

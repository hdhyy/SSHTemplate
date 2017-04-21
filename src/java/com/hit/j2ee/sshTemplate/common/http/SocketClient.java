package com.hit.j2ee.sshTemplate.common.http;

import org.apache.log4j.Logger;


import com.hit.j2ee.sshTemplate.common.utils.DetectionUtils;

import java.io.*;
import java.net.Socket;
import java.net.URLEncoder;

/**
 * Socket客户�?向服务端发�?消息
 * 
 *
 */
public class SocketClient {
 private static Logger logger = Logger.getLogger(SocketClient.class
   .getName());
 private static final int MAX_TIMEOUT = 10;
 
 private SocketClient() {
 }

 /**
  * 向服务端发�?消息
  *
  * @param host
  *            主机Host或IP
  * @param port
  *            端口
  * @param timeout
  *            超时,单位�?
  * @param content
  *            发�?内容
  */
 public static void send(String host, int port, int timeout, String content) {
  Socket s = null;
  PrintWriter out = null;
  try {
   s = new Socket(host, port);
   s
     .setSoTimeout((timeout > MAX_TIMEOUT ? MAX_TIMEOUT
       : timeout) * 1000);
   out = new PrintWriter(s.getOutputStream());
   out.write(content);
   out.flush();
  } catch (Exception e) {
   logger.error(e);
  } finally {
   if (s != null)
    try {
     s.close();
    } catch (IOException e) {
    }
   if (out != null)
    out.close();
   s = null;
   out = null;
  }
 }

 /**
  * 向SocketServer发�?通信指令并获取回复数�?
  *
  * @param host 主机名称或IP
  * @param port 端口
  * @param timeout 超时时间(�?
  * @param content 指令内容
  * @return
  */
 public static String sendAndGetReply(String host, int port, int timeout,
                                      String content, String encode) {
   Socket s = null;
  BufferedReader in = null;
  PrintWriter out = null;
  String line = null;
  try {
	  if(!DetectionUtils.isEmpty(encode))
		  content = URLEncoder.encode(content, encode);
   s = new Socket(host, port);
   s
     .setSoTimeout((timeout > MAX_TIMEOUT ? MAX_TIMEOUT
       : timeout) * 1000);
   in = new BufferedReader(new InputStreamReader(s.getInputStream()));
   out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s
     .getOutputStream())), true);
   out.println(content);
   line = in.readLine();
  } catch (Exception e) {
   logger.error(e);
  } finally {
   if (s != null)
    try {
     s.close();
    } catch (IOException e) {
    }
   if (out != null)
    out.close();
   if (in != null)
    try {
     in.close();
    } catch (IOException e) {
    }
   s = null;
   out = null;
   in = null;
  }
  try {
	  if(!DetectionUtils.isEmpty(encode))
		  line = URLEncoder.encode(line, encode);
  } catch (UnsupportedEncodingException e) {
   logger.error(e);
  }
  return line;
 }
 
 /**
  * 向SocketServer发�?通信指令,无同步回复消�?
  *
  * @param host 主机名称或IP
  * @param port 端口
  * @param timeout 超时时间(�?
  * @param content 指令内容
  * @return
  */
 public static void sendAndNoReply(String host, int port, int timeout,
                                   String content, String encode) {
  Socket s = null;
  PrintWriter out = null;
  try {
	if(!DetectionUtils.isEmpty(encode))
		content = URLEncoder.encode(content, encode);
   s = new Socket(host, port);
   s
     .setSoTimeout((timeout > MAX_TIMEOUT ? MAX_TIMEOUT
       : timeout) * 1000);
   out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s
     .getOutputStream())), true);
   out.println(content);
  } catch (Exception e) {
   logger.error(e);
  } finally {
   if (s != null)
    try {
     s.close();
    } catch (IOException e) {
    }
   if (out != null)
    out.close();
   s = null;
   out = null;
  }
 }
}
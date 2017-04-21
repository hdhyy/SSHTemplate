package com.hit.j2ee.sshTemplate.common.http;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Vector;

public class HttpRequester {
	private String defaultContentEncoding;
	 
	public HttpRequester() {
		this.defaultContentEncoding = Charset.defaultCharset().name();
	}
 
	/**
	 * <p>发送GET请求</p>
	 * 
	 * @param urlString
	 *            URL地址
	 * @return HttpRespons 响应对象
	 * @throws IOException
	 */
	public HttpRespons sendGet(String urlString) throws IOException {
		return this.send(urlString, "GET", null, null);
	}
 
	/**
	 * <p>发送GET请求</p>
	 * 
	 * @param urlString
	 *            URL地址
	 * @param params
	 *            参数集合
	 * @return HttpRespons 响应对象
	 * @throws IOException
	 */
	public HttpRespons sendGet(String urlString, Map<String, String> params)
			throws IOException {
		return this.send(urlString, "GET", params, null);
	}
 
	/**
	 *<p> 发送GET请求</p>
	 * 
	 * @param urlString
	 *            URL地址
	 * @param params
	 *            参数集合
	 * @param propertys
	 *            请求属性
	 * @return HttpRespons 响应对象
	 * @throws IOException
	 */
	public HttpRespons sendGet(String urlString, Map<String, String> params,
							   Map<String, String> propertys) throws IOException {
		return this.send(urlString, "GET", params, propertys);
	}
 
	/**
	 *<p>发送POST请求</p>
	 * 
	 * @param urlString
	 *            URL地址
	 * @return HttpRespons 响应对象
	 * @throws IOException
	 */
	public HttpRespons sendPost(String urlString) throws IOException {
		return this.send(urlString, "POST", null, null);
	}
 
	/**
	 * <p>发送POST请求</p>
	 * 
	 * @param urlString
	 *            URL地址
	 * @param params
	 *            参数集合
	 * @return HttpRespons 响应对象
	 * @throws IOException
	 */
	public HttpRespons sendPost(String urlString, Map<String, String> params)
			throws IOException {
		return this.send(urlString, "POST", params, null);
	}
 
	/**
	 * <p>发送POST请求</p>
	 * 
	 * @param urlString
	 *            URL地址
	 * @param params
	 *            参数集合
	 * @param propertys
	 *            请求属性
	 * @return HttpRespons 响应对象
	 * @throws IOException
	 */
	public HttpRespons sendPost(String urlString, Map<String, String> params,
								Map<String, String> propertys) throws IOException {
		return this.send(urlString, "POST", params, propertys);
	}
 
	/**
	 * <p>发送HTTP请求</p>
	 * 
	 * @param urlString
	 *            URL地址
	 * @param params
	 *            参数集合
	 * @param propertys
	 *            请求属性
	 * @return HttpRespons 响应对象
	 * @throws IOException
	 */
	private HttpRespons send(String urlString, String method,
							 Map<String, String> parameters, Map<String, String> propertys)
			throws IOException {
		HttpURLConnection urlConnection = null;
 
		if (method.equalsIgnoreCase("GET") && parameters != null) {
			StringBuffer param = new StringBuffer();
			int i = 0;
			for (String key : parameters.keySet()) {
				if (i == 0)
					param.append("?");
				else
					param.append("&");
				param.append(key).append("=").append(parameters.get(key));
				i++;
			}
			urlString += param;
		}
		URL url = new URL(urlString);
		urlConnection = (HttpURLConnection) url.openConnection();
 
		urlConnection.setRequestMethod(method);
		urlConnection.setDoOutput(true);
		urlConnection.setDoInput(true);
		urlConnection.setUseCaches(false);
 
		if (propertys != null)
			for (String key : propertys.keySet()) {
				urlConnection.addRequestProperty(key, propertys.get(key));
			}
 
		if (method.equalsIgnoreCase("POST") && parameters != null) {
			StringBuffer param = new StringBuffer();
			for (String key : parameters.keySet()) {
				param.append("&");
				param.append(key).append("=").append(parameters.get(key));
			}
			urlConnection.getOutputStream().write(param.toString().getBytes(this.defaultContentEncoding));
			urlConnection.getOutputStream().flush();
			urlConnection.getOutputStream().close();
		}
 
		return this.makeContent(urlString, urlConnection);
	}
 
	/**
	 * <p>得到响应对象</p>
	 * @param urlString URL地址
	 * @param urlConnection HttpURLConnection
	 * @return HttpRespons 响应对象
	 * @throws IOException
	 */
	private HttpRespons makeContent(String urlString,
			HttpURLConnection urlConnection) throws IOException {
		HttpRespons httpResponser = new HttpRespons();
		try {
			InputStream in = urlConnection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(in));
			httpResponser.contentCollection = new Vector<String>();
			StringBuffer temp = new StringBuffer();
			String line = bufferedReader.readLine();
			while (line != null) {
				httpResponser.contentCollection.add(line);
				temp.append(line).append("\r\n");
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
 
			String ecod = urlConnection.getContentEncoding();
			if (ecod == null)
				ecod = this.defaultContentEncoding;
 
			httpResponser.urlString = urlString;
 
			httpResponser.defaultPort = urlConnection.getURL().getDefaultPort();
			httpResponser.file = urlConnection.getURL().getFile();
			httpResponser.host = urlConnection.getURL().getHost();
			httpResponser.path = urlConnection.getURL().getPath();
			httpResponser.port = urlConnection.getURL().getPort();
			httpResponser.protocol = urlConnection.getURL().getProtocol();
			httpResponser.query = urlConnection.getURL().getQuery();
			httpResponser.ref = urlConnection.getURL().getRef();
			httpResponser.userInfo = urlConnection.getURL().getUserInfo();
 
			httpResponser.content = new String(temp.toString().getBytes(), ecod);
			httpResponser.contentEncoding = ecod;
			httpResponser.code = urlConnection.getResponseCode();
			httpResponser.message = urlConnection.getResponseMessage();
			httpResponser.contentType = urlConnection.getContentType();
			httpResponser.method = urlConnection.getRequestMethod();
			httpResponser.connectTimeout = urlConnection.getConnectTimeout();
			httpResponser.readTimeout = urlConnection.getReadTimeout();
 
			return httpResponser;
		} catch (IOException e) {
			throw e;
		} finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}
	}
 
	/**
	 * <p>默认的响应字符集</p>
	 */
	public String getDefaultContentEncoding() {
		return this.defaultContentEncoding;
	}
 
	/**
	* <p>设置默认的响应字符集</p>
	* @param defaultContentEncoding
	* void
	*/
	public void setDefaultContentEncoding(String defaultContentEncoding) {
		this.defaultContentEncoding = defaultContentEncoding;
	}
	
	  public String getErrorUrl(HttpServletRequest request)
	  {
	    String str = (String)request.getAttribute("javax.servlet.error.request_uri");
	    if (str == null)
	      str = (String)request.getAttribute("javax.servlet.forward.request_uri");
	    if (str == null)
	      str = (String)request.getAttribute("javax.servlet.include.request_uri");
	    if (str == null)
	      str = request.getRequestURL().toString();
	    return str;
	  }
}

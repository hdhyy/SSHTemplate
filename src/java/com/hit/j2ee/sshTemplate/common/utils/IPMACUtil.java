package com.hit.j2ee.sshTemplate.common.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * @ClassName: IPMACUtil
 * @ClassNameExplain: 类名说明
 * @Description: TODO(这里描述这个类的作用)
 * @author duhw
 * @date 2016年4月12日 下午2:54:34
 */
public class IPMACUtil {
	public static String getMAC(String ip) {
		String str = null;
		String macAddress = null;
		try { 
			Process p = Runtime.getRuntime().exec("arp -a " + ip);
			InputStreamReader ir = new InputStreamReader(p.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i=1 ; i<200000000; i++) { 
				str = input.readLine(); 
				if (str != null) { 
					if (str.indexOf(ip) > 1) { 
						Integer index = str.indexOf(ip) + ip.length() + 2;
						while (str.charAt(index) == ' ') index ++;
						System.out.println(str);
						System.out.println(str.indexOf(ip));
						macAddress = str 
						.substring(index , index + 17 ); 
						break;
					} 
				} 
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
			return null; 
		} 
		return macAddress; 
	} 
}

package com.hit.j2ee.sshTemplate.common.encrypt;

import javax.crypto.Cipher;
import java.security.Key;

public class DESUtil {  
	private static String strDefaultKey = "national";
	private Cipher encryptCipher = null;
	private Cipher decryptCipher = null;
	/**   
	 * * 将byte数组转换为表示6进制值的字符串， 如：byte[]{8,18}转换为：0813�?和public static byte[]   
	 * * hexStr2ByteArr(String strIn) 互为可�?的转换过�?  *   
	 * * @param arrB   *            �?��转换的byte数组   
	 * * @return 转换后的字符串  * @throws Exception   *             
	 * 本方法不处理任何异常，所有异常全部抛�?  */ 
	public static String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;   // 每个byte用两个字符才能表示，�?��字符串的长度是数组长度的两�?  
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {    
			int intTmp = arrB[i];    // 把负数转换为正数   
			while (intTmp < 0) {     intTmp = intTmp + 256;    }    
			// 小于0F的数�?��在前面补0    
			if (intTmp < 16) {     
				sb.append("0");   
				}    
			sb.append(Integer.toString(intTmp, 16));
			}   return sb.toString();  }   
	/**   
	 * * 将表�?6进制值的字符串转换为byte数组�?和public static String byteArr2HexStr(byte[] arrB)   
	 * * 互为可�?的转换过�?  *   * @param strIn   *            
	 * �?��转换的字符串   * 
	 * @return 转换后的byte数组   * @throws Exception   *             
	 * 本方法不处理任何异常，所有异常全部抛�?  * 
	 * 
	 * */ 
	public static byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();   
		int iLen = arrB.length;    
		// 两个字符表示�?��字节，所以字节数组长度是字符串长度除�?   
		byte[] arrOut = new byte[iLen / 2];  
		for (int i = 0; i < iLen; i = i + 2) {    
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
			}   
		return arrOut;  }   
	/**   * 默认构�?方法，使用默认密�?  *   
	 * * @throws Exception   
	 * */
	public DESUtil() throws Exception {
		this(strDefaultKey);  
		}    
	/**   * 指定密钥构�?方法   *   
	 * * @param strKey   *            
	 * 指定的密�?  * 
	 * @throws Exception
	 * */
	public DESUtil(String strKey) throws Exception {
//		Security.addProvider(new com.sun.crypto.provider.SunJCE());  
		Key key = getKey(strKey.getBytes());
		encryptCipher = Cipher.getInstance("DES");
		encryptCipher.init(Cipher.ENCRYPT_MODE, key);
		decryptCipher = Cipher.getInstance("DES");
		decryptCipher.init(Cipher.DECRYPT_MODE, key);
		}  
	/**  
	 *  * 加密字节数组   *   
	 *  * @param arrB   *            �?��密的字节数组  
	 *   * @return 加密后的字节数组  
	 *    * @throws Exception   
	 *    */ 
	public byte[] encrypt(byte[] arrB) throws Exception {
		return encryptCipher.doFinal(arrB);  
		}    
	/**   * 加密字符�?  *   
	 * * @param strIn   *            
	 * �?��密的字符�?  *
	 *  @return 加密后的字符�?  * 
	 *  @throws Exception
	 *  */ 
	public String encrypt(String strIn) throws Exception {
		return byteArr2HexStr(encrypt(strIn.getBytes()));
		}   
	/**   
	 * * 解密字节数组   *  
	 *  * @param arrB   *           
	 *   �?��密的字节数组   * 
	 *   @return 解密后的字节数组   * 
	 *   @throws Exception
	 *   */ 
	public byte[] decrypt(byte[] arrB) throws Exception {
		return decryptCipher.doFinal(arrB);  
		}   
	/**  
	 *  * 解密字符�?  *   
	 *  * @param strIn   *            
	 *  �?��密的字符�?  * 
	 *  @return 解密后的字符�?  * 
	 *  @throws Exception   */
	public String decrypt(String strIn) throws Exception {
		return new String(decrypt(hexStr2ByteArr(strIn)));  }
	/**   * 从指定字符串生成密钥，密钥所�?��字节数组长度�?�?不足8位时后面�?，超�?位只取前8�?  *  
	 *  * @param arrBTmp   *            
	 *  构成该字符串的字节数�?  * 
	 *  @return 生成的密�?  * 
	 *  @throws Exception
	 *   */
	private Key getKey(byte[] arrBTmp) throws Exception {
		// 创建�?��空的8位字节数组（默认值为0�? 
		byte[] arrB = new byte[8];     
		// 将原始字节数组转换为8�?  
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {   
			arrB[i] = arrBTmp[i];  
			}    
		// 生成密钥  
		  Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
		  return key;  
		} 
 

	} 

package com.hit.j2ee.sshTemplate.common.encrypt;

import java.security.MessageDigest;

//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

public class SimpleEncrypt {

	//异或操作，用于传输加�?
	public static String encrypt(String strOld, String strKey) {
		byte[] data = strOld.getBytes();
		byte[] keyData = strKey.getBytes();
		int keyIndex = 0 ;
		for(int x = 0 ; x < strOld.length() ; x++) {
		data[x] = (byte)(data[x] ^ keyData[keyIndex]);
		if (++keyIndex == keyData.length){
		keyIndex = 0;
		}
		}
		return new String(data);
		} 
	
	public static final String KEY_SHA = "SHA";
	public static final String KEY_MD5 = "MD5";

	/**
	 * MAC算法可�?以下多种算法
	 * 
	 * <pre>
	 * HmacMD5 
	 * HmacSHA1 
	 * HmacSHA256 
	 * HmacSHA384 
	 * HmacSHA512
	 * </pre>
	 */
	public static final String KEY_MAC = "HmacMD5";

	/**
	 * BASE64解密
	 * 
	 * @param key
	 * @return byte[]
	 * @throws Exception
	 */
//	public static byte[] decryptBASE64(String key) throws Exception {
//		return (new BASE64Decoder()).decodeBuffer(key);
//	}

	/**
	 * BASE64加密
	 * 
	 * @param key
	 * @return String
	 * @throws Exception
	 */
//	public static String encryptBASE64(byte[] key) throws Exception {
//		return (new BASE64Encoder()).encodeBuffer(key);
//	}

	/**
	 * MD5加密
	 * 
	 * @param data
	 * @return byte[]
	 * @throws Exception
	 */
	public static byte[] encryptMD5(byte[] data) throws Exception {

		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);

		return md5.digest();

	}

	/**
	 * SHA加密
	 * 
	 * @param data
	 * @return byte[]
	 * @throws Exception
	 */
	public static byte[] encryptSHA(byte[] data) throws Exception {

		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);

		return sha.digest();

	}

	/**
	 * 初始化HMAC密钥
	 * 
	 * @return String
	 * @throws Exception
	 */
//	public static String initMacKey() throws Exception {
//		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);
//
//		SecretKey secretKey = keyGenerator.generateKey();
//		return encryptBASE64(secretKey.getEncoded());
//	}

	/**
	 * HMAC加密
	 * 
	 * @param data
	 * @param key
	 * @return byte[]
	 * @throws Exception
	 */
//	public static byte[] encryptHMAC(byte[] data, String key) throws Exception {
//
//		SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), KEY_MAC);
//		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
//		mac.init(secretKey);
//
//		return mac.doFinal(data);
//
//	}
}

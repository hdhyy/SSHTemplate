package com.hit.j2ee.sshTemplate.common.utils;
/**  
 * <p>Copyright 2012 Beijing HuaChuang Network Security Technology Co.,Ltd</p>
 * All right reserved
 */
/**
 *功能/模块�?
 * @Description：�?信格式转�?
 * Java和一些windows编程语言如c、c++、delphi�?��的网络程序进行�?讯时，需要进行相应的转换 
 * 高�?低字节之间的转换 
 * windows的字节序为低字节�?�� 
 * linux,unix的字节序为高字节�?�� 
 * java则无论平台变化，都是高字节开�? 
 * @author: steve.shiyz  eagler006@hotmail.com
 * @date 2012-8-20 下午12:04:01
 * @version 2.0
 * 修订历史:   
 * 修改人：Administrator    
 * 修改时间�?012-8-20 下午12:04:01    
 * 修改备注：TODO
 *@see
 *
 */
public class CommunicationTransUtil {
    /** 
      * 将int转为低字节在前，高字节在后的byte数组 
      * @param n int 
      * @return byte[] 
      */  
    public static byte[] toLH(int n) {  
      byte[] b = new byte[4];  
      b[0] = (byte) (n & 0xff);  
      b[1] = (byte) (n >> 8 & 0xff);  
      b[2] = (byte) (n >> 16 & 0xff);  
      b[3] = (byte) (n >> 24 & 0xff);  
      return b;  
    }   
      
    /** 
      * 将int转为高字节在前，低字节在后的byte数组 
      * @param n int 
      * @return byte[] 
      */  
    public static byte[] toHH(int n) {  
      byte[] b = new byte[4];  
      b[3] = (byte) (n & 0xff);  
      b[2] = (byte) (n >> 8 & 0xff);  
      b[1] = (byte) (n >> 16 & 0xff);  
      b[0] = (byte) (n >> 24 & 0xff);  
      return b;  
    }   
      
    /** 
      * 将short转为低字节在前，高字节在后的byte数组 
      * @param n short 
      * @return byte[] 
      */  
    public static byte[] toLH(short n) {  
      byte[] b = new byte[2];  
      b[0] = (byte) (n & 0xff);  
      b[1] = (byte) (n >> 8 & 0xff);  
      return b;  
    }   
      
    /** 
      * 将short转为高字节在前，低字节在后的byte数组 
      * @param n short 
      * @return byte[] 
      */  
    public static byte[] toHH(short n) {  
      byte[] b = new byte[2];  
      b[1] = (byte) (n & 0xff);  
      b[0] = (byte) (n >> 8 & 0xff);  
      return b;  
    }  
      
    /** 
      * 将float转为低字节在前，高字节在后的byte数组 
      */  
    public static byte[] toLH(float f) {  
      return toLH(Float.floatToRawIntBits(f));
    }   
      
    /** 
      * 将float转为高字节在前，低字节在后的byte数组 
      */  
    public static byte[] toHH(float f) {  
      return toHH(Float.floatToRawIntBits(f));
    }   
      
    /** 
      * 将String转为byte数组 
      */  
    public static byte[] stringToBytes(String s, int length) {
      while (s.getBytes().length < length) {  
        s += " ";  
      }  
      return s.getBytes();  
    }   
      
      
    /** 
      * 将字节数组转换为String 
      * @param b byte[] 
      * @return String 
      */  
    public static String bytesToString(byte[] b) {
      StringBuffer result = new StringBuffer("");
      int length = b.length;  
      for (int i=0; i<length; i++) {  
        result.append((char)(b[i] & 0xff));  
      }  
      return result.toString();  
    }   
      
    /** 
      * 将字符串转换为byte数组 
      * @param s String 
      * @return byte[] 
      */  
    public static byte[] stringToBytes(String s) {
      return s.getBytes();  
    }   
      
    /** 
      * 将高字节数组转换为int 
      * @param b byte[] 
      * @return int 
      */  
    public static int hBytesToInt(byte[] b) {  
      int s = 0;  
      for (int i = 0; i < 3; i++) {  
        if (b[i] >= 0) {  
        s = s + b[i];  
        } else {  
        s = s + 256 + b[i];  
        }  
        s = s * 256;  
      }  
      if (b[3] >= 0) {  
        s = s + b[3];  
      } else {  
        s = s + 256 + b[3];  
      }  
      return s;  
    }   
      
    /** 
      * 将低字节数组转换为int 
      * @param b byte[] 
      * @return int 
      */  
    public static int lBytesToInt(byte[] b) {  
      int s = 0;  
      for (int i = 0; i < 3; i++) {  
        if (b[3-i] >= 0) {  
        s = s + b[3-i];  
        } else {  
        s = s + 256 + b[3-i];  
        }  
        s = s * 256;  
      }  
      if (b[0] >= 0) {  
        s = s + b[0];  
      } else {  
        s = s + 256 + b[0];  
      }  
      return s;  
    }   
      
      
    /** 
      * 高字节数组到short的转�?
      * @param b byte[] 
      * @return short 
      */  
    public static short hBytesToShort(byte[] b) {  
      int s = 0;  
      if (b[0] >= 0) {  
        s = s + b[0];  
        } else {  
        s = s + 256 + b[0];  
        }  
        s = s * 256;  
      if (b[1] >= 0) {  
        s = s + b[1];  
      } else {  
        s = s + 256 + b[1];  
      }  
      short result = (short)s;  
      return result;  
    }   
      
    /** 
      * 低字节数组到short的转�?
      * @param b byte[] 
      * @return short 
      */  
    public static short lBytesToShort(byte[] b) {  
      int s = 0;  
      if (b[1] >= 0) {  
        s = s + b[1];  
        } else {  
        s = s + 256 + b[1];  
        }  
        s = s * 256;  
      if (b[0] >= 0) {  
        s = s + b[0];  
      } else {  
        s = s + 256 + b[0];  
      }  
      short result = (short)s;  
      return result;  
    }   
      
    /** 
      * 高字节数组转换为float 
      * @param b byte[] 
      * @return float 
      */  
    public static float hBytesToFloat(byte[] b) {  
      int i = 0;  
      i = ((((b[0]&0xff)<<8 | (b[1]&0xff))<<8) | (b[2]&0xff))<<8 | (b[3]&0xff);  
      return Float.intBitsToFloat(i);
    }   
      
    /** 
      * 低字节数组转换为float 
      * @param b byte[] 
      * @return float 
      */  
    public static float lBytesToFloat(byte[] b) {  
      int i = 0;  
      i = ((((b[3]&0xff)<<8 | (b[2]&0xff))<<8) | (b[1]&0xff))<<8 | (b[0]&0xff);  
      return Float.intBitsToFloat(i);
    }   
      
    /** 
      * 将byte数组中的元素倒序排列 
      */  
    public static byte[] bytesReverseOrder(byte[] b) {  
      int length = b.length;  
      byte[] result = new byte[length];  
      for(int i=0; i<length; i++) {  
        result[length-i-1] = b[i];  
      }  
      return result;  
    }   
      
    /** 
      * 打印byte数组 
      */  
    public static void printBytes(byte[] bb) {  
      int length = bb.length;  
      for (int i=0; i<length; i++) {  
        System.out.print(bb[i] + " ");
      }  
      System.out.println("");
    }   
      
    public static void logBytes(byte[] bb) {  
      int length = bb.length;  
      String out = "";
      for (int i=0; i<length; i++) {  
        out = out + bb[i] + " ";  
      }   
      
    }   
      
    /** 
      * 将int类型的�?转换为字节序颠�?过来对应的int�?
      * @param i int 
      * @return int 
      */  
    public static int reverseInt(int i) {  
      int result = CommunicationTransUtil.hBytesToInt(CommunicationTransUtil.toLH(i));  
      return result;  
    }   
      
    /** 
      * 将short类型的�?转换为字节序颠�?过来对应的short�?
      * @param s short 
      * @return short 
      */  
    public static short reverseShort(short s) {  
      short result = CommunicationTransUtil.hBytesToShort(CommunicationTransUtil.toLH(s));  
      return result;  
    }   
      
    /** 
      * 将float类型的�?转换为字节序颠�?过来对应的float�?
      * @param f float 
      * @return float 
      */  
    public static float reverseFloat(float f) {  
      float result = CommunicationTransUtil.hBytesToFloat(CommunicationTransUtil.toLH(f));  
      return result;  
    }   
}
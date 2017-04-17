package com.hit.j2ee.sshTemplate.common.utils;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;


public class PidUtils {


    public   static String getPID() {

        String pid = System.getProperty("pid" );

        if  (pid ==  null ) {   
        
            RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

            String processName = runtimeMXBean.getName();

            if  (processName.indexOf( '@' ) != - 1 ) {   

                pid = processName.substring(0 , processName.indexOf( '@' ));   

            } else  {   

                try {
					pid = getPIDFromOS();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   

            }   

            System.setProperty("pid" , pid);

        }   

        return  pid;   

    }   

   

    /**   

     * 从操作系统获得pid   

     * <p>     

     * @return   
     * @throws IOException

     */    

    private   static String getPIDFromOS() throws IOException {

   

        String pid = null ;

   

        String[] cmd = null ;

   

        File tempFile = null ;

   

        String osName = System.getProperty("os.name");

        // 处理windows    

        if  (osName.toLowerCase().contains( "windows" )) {   

            FileInputStream fis = null ;

            FileOutputStream fos = null ;

   

            try  {   

                // 创建临时getpids.exe文件    

                tempFile = File.createTempFile("getpids" ,  ".exe" );
              
                File getpids = new File(PidUtils.class.getResource("/")+"getpids.exe" );

                fis = new FileInputStream(getpids);

                fos = new FileOutputStream(tempFile);

                byte [] buf =  new   byte [ 1024 ];   

                while  (fis.read(buf) != - 1 ) {   

                    fos.write(buf);   

                }   

                // 获得临时getpids.exe文件路径作为命令    

                cmd = new String[] { tempFile.getAbsolutePath() };

            } catch  (FileNotFoundException e) {

            

            } catch  (IOException e) {

                

            } finally  {   

                if  (tempFile !=  null ) {   

                    tempFile.deleteOnExit();   

                } 
                if(fis!=null)
                	fis.close();
                if(fos!=null)
                	fos.close();

            }   

        }   

        // 处理非windows    

        else  {   

            cmd = new String[] {  "/bin/sh" ,  "-c" ,  "echo $ $PPID"  };

        }   

        InputStream is = null ;

        ByteArrayOutputStream baos = null ;

        try  {   

            byte [] buf =  new   byte [ 1024 ];   

            Process exec = Runtime.getRuntime().exec(cmd);

            is = exec.getInputStream();   

            baos = new ByteArrayOutputStream();

            while  (is.read(buf) != - 1 ) {   

                baos.write(buf);   

            }   

            String ppids = baos.toString();

            // 对于windows参�?：http://www.scheibli.com/projects/getpids/index.html    

            pid = ppids.split(" " )[ 1 ];   

        } catch  (Exception e) {

          

        } finally  {   

            if  (tempFile !=  null ) {   

                tempFile.deleteOnExit();   

            }   

            if(is!=null)
            	is.close();
            if(baos!=null)
            	baos.close();

        }   

        return  pid;   

    }   


}

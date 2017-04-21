package com.hit.j2ee.sshTemplate.common.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 * @author eagler006 email:eagler006@hotmail.com
 * @version  1.1
 *
 */
public class MultiThreadServer {
	
	private int port=8821;
    private ServerSocket serverSocket;
    private ExecutorService executorService;
    private final int POOL_SIZE=10;
    
    
    public MultiThreadServer() throws IOException {
        serverSocket=new ServerSocket(port);
        //Runtime的availableProcessor()方法返回当前系统的CPU数目.
        executorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);
    }
    
    public void service(SocketHandler sh){
        while(true){
            Socket socket=null;
            try {
                //接收客户连接,只要客户进行了连接就会触发accept();从而建立连接
                socket=serverSocket.accept();
                
                executorService.execute(sh);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
}

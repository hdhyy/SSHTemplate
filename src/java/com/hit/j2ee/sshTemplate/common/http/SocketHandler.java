package com.hit.j2ee.sshTemplate.common.http;

import java.io.*;
import java.net.Socket;

/**
 * TODO
 * @author eagler006 email:eagler006@hotmail.com
 * @version  1.1
 *
 */
public abstract class SocketHandler  implements Runnable {
	private Socket socket;
    public SocketHandler(Socket socket){
        this.socket=socket;
    }
    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketOut=socket.getOutputStream();
        return new PrintWriter(socketOut,true);
    }
    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn=socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

    public abstract void run();
}

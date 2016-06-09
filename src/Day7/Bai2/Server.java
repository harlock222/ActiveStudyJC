/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day7.Bai2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Harlock
 */
public class Server {
    public static void main(String args[]) throws IOException {
//        InputStream  clientin = null;
//        OutputStream  clientout = null;
        BufferedInputStream  clientin = null;
        BufferedOutputStream clientout = null;
        Socket socket = null;
        String fileName = "D:\\Jav\\ActiveStudyJC\\src\\Day7\\Bai2\\test2.txt";
        try {
            System.out.println("waiting..... !");
            ServerSocket serversocket = new ServerSocket(1150);
            socket = serversocket.accept();
            clientin = new BufferedInputStream(new FileInputStream(new File(fileName))) ;
            clientout = new BufferedOutputStream(socket.getOutputStream());
            byte[] bytes = new byte[16*1024];
            int count;
            while ((count = clientin.read(bytes)) !=-1) {
                clientout.write(bytes, 0, count);
            }
            System.out.println("Received complete !");
        } catch (IOException e) {
        }finally {
             if (clientin != null) {
                clientin.close();
            }
            if (clientout != null) {
                clientout.close();
            }
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
        
    }
}

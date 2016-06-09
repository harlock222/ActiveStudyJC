/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day7.Bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Harlock
 */
public class Server {
    public static void main(String args[]) throws IOException {
        
        DataInputStream clientin;
        DataOutputStream clientout;
        Socket socket = null;
        try {
            ServerSocket serversocket = new ServerSocket(1150);
            socket = serversocket.accept();
            clientin = new DataInputStream(socket.getInputStream());
            clientout = new DataOutputStream(socket.getOutputStream());
            boolean stop = false;
            while (!stop) {
                double sentence = clientin.readDouble();
                if(sentence<0){
                    stop=true;
                }else{
                     System.out.printf("ban kinh : %s", sentence);
                System.out.println(""); 
                double s = sentence*sentence*(3.14);
                System.out.println("Dien tich :"+s); 
                clientout.writeDouble(s);
                }  
            }
          
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
}

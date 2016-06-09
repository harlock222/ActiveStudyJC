/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day7.Bai3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Harlock
 */
public class Server {
    public static void main(String args[])  {
        
        ObjectInputStream  clientin = null;
        ObjectOutputStream clientout = null;
        Socket socket = null;
        try {
            System.out.println("waiting..... !");
            ServerSocket serversocket = new ServerSocket(1151);
            socket = serversocket.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            clientin = new ObjectInputStream(is);
            clientout = new ObjectOutputStream(os);
            Dog dog = (Dog)clientin.readObject();
           if(dog!=null){
            System.out.println("Received complete !");
            System.out.println(dog.getName()+" "+dog.getHieght()+"Kg"); 
           }
            clientout.writeObject(dog);
        } catch (IOException |ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (clientin != null) {
                try {
                    clientin.close();
                } catch (IOException e) {
                    
                }
            }
            if (clientout != null) {
                try {
                    clientout.close();
                } catch (IOException e) {
                   e.printStackTrace();
                }
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
}

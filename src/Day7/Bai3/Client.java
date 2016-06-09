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
import java.net.Socket;
import java.io.*;
/**
 *
 * @author Harlock
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket =null;
        ObjectInputStream input = null;
        ObjectOutputStream output= null ;
        try {
            System.out.println("Client Readly !");
            socket = new Socket("localhost", 1151);
            OutputStream os = socket.getOutputStream();
            output = new ObjectOutputStream(os);
            Dog dog = new Dog("Nataxa", 15);
            output.writeObject(dog);
            System.out.println("Sent complete !");
            
            
            
            
            
            
            
            InputStream is = socket.getInputStream();
            input = new ObjectInputStream(is);
            Dog dogR = (Dog)input.readObject();
            if(dogR!=null){
            System.out.println(dogR.getName()+" "+dogR.getHieght()+"Kg");
            System.out.println("Received complete !");
           }
        } catch (Exception e) {
        }finally {
           
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}

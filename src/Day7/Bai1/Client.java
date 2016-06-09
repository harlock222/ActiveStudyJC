/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day7.Bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Harlock
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket socket= null;
        DataInputStream input = null;
        DataOutputStream output = null;
        try {
            boolean stop = false;
        while (!stop) {
            socket = new Socket("localhost", 1150);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            System.out.println("Ban kinh :");
            double a =Double.valueOf(sc.nextLine()) ;
            if(a>0){
                output.writeDouble(a);
                System.out.println("waiting...");
                System.out.printf("Dien tich: %s\n", input.readDouble());
            }else{
            stop=true;
            }
        }
        } catch (Exception e) {
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

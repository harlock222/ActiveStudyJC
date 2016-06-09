/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day7.Bai2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Harlock
 */
public class Client {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\Jav\\ActiveStudyJC\\src\\Day7\\Bai2\\test.txt";
        Socket socket = new Socket("localhost", 1150);
        InputStream  input = null;
        OutputStream  output = null;
        try {input = new BufferedInputStream(new 
        FileInputStream(new File(fileName)));
        output = socket.getOutputStream();
        byte[] b = new byte[16*1024];
        int c;
        while((c= input.read(b))!=-1){
            output.write(b,0,c);
        }
            System.out.println("Sent complete !");
        } catch (Exception e) {
            e.printStackTrace();
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

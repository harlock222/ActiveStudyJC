/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Harlock
 */
public class FileEncrypter {
    
    public static void main(String[] args) throws IOException,FileNotFoundException {
        String fileName;
        int  doCrypto = 0;
        Scanner sc = new Scanner(System.in);
        fileName= sc.next();
        doCrypto= sc.nextInt();
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
           in = new FileInputStream(fileName);
           out = new FileOutputStream("example_encrypted.txt");
           byte[] a = new byte[2048];
           int c,b = 0;
            while ((c=(byte)in.read(a))!=-1) {
               if(doCrypto==1){
                   b=(byte) (c+5);
               }else if(doCrypto==2){
                   b=(byte) (c-5);  
               }
                out.write(b);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
   
}

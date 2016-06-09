/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day8;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author harlock
 */
public class Test {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("text.txt")){
            System.out.println(" bat dau ");
          Thread   t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                     System.out.println(" 1");
//                    try {
//                        fos.write(("Anh").getBytes());
//                        System.out.println(" 1");
//                    } catch (IOException ex) {
//                    }
                }
            });
           Thread   t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(" 2");
                }
            });
           Thread   t3 = new Thread(new Runnable() {
                @Override
                public void run() {
                     System.out.println(" 3");
                }
            });
          
          
          
           t2.start();
          t1.start();
           t3.start();
           
           
        } catch ( IOException ex) {
            
        }
        System.out.println(" Ket thuc ");
    }
   
    
}
 

 
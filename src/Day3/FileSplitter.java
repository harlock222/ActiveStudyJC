/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Harlock
 */
public class FileSplitter {
   
   public static void main(String[] args) throws FileNotFoundException, 
       IOException {
    Scanner sc = new Scanner(System.in);
    String fileName = sc.next(); 
    String numberOfFiles = sc.next();
       try (BufferedInputStream input = new BufferedInputStream(
           new FileInputStream(new File(fileName)))) {
           int numberOfPieces = Integer.parseInt(numberOfFiles);
           long fileSize = input.available();
           int splitFileSize = (int) Math.ceil(1.0 * fileSize / numberOfPieces);
           for (int i = 1; i <= numberOfPieces; i++) {
               try (BufferedOutputStream output = new BufferedOutputStream(
                   new FileOutputStream(new File(fileName + "." + i)))) {
                   int temp ;
                   int count = 0;
                   while (count++ < splitFileSize && (temp =  input.read()) != -1) {
                       output.write(temp);
                   }
               }
              
           }
       }
}
}
    

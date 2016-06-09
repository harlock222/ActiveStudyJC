/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author Harlock
 */
public class ByteStream {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("C:\\Users\\Harlock\\Documents\\NetBeansProjects\\ActiveStudyJC\\src\\Day2\\ajnomoto.txt");
            out = new FileOutputStream("C:\\Users\\Harlock\\Documents\\NetBeansProjects\\ActiveStudyJC\\src\\Day2\\vedal.txt");
            byte c;
            while ((c = (byte) in.read()) != -1) {
                out.write(c);
                
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

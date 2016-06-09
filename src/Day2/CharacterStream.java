/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author Harlock
 */
public class CharacterStream {
      public static void main(String[] args) throws IOException {

        BufferedReader  inputStream = null;
        PrintWriter  outputStream = null;
        try {
            inputStream =new BufferedReader(new FileReader("C:\\Users\\Harlock\\Documents\\NetBeansProjects\\ActiveStudyJC\\src\\Day2\\ajnomoto.txt"));
            outputStream =new PrintWriter(new FileWriter("C:\\Users\\Harlock\\Documents\\NetBeansProjects\\ActiveStudyJC\\src\\Day2\\character.txt"));

            String c;
            while ((c = inputStream.readLine()) != null) {
                outputStream.println(c);
                System.out.println(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Harlock
 */
public class BufferredStream {
    public static void main(String[] args) throws IOException {

        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;

        try {
            inputStream = new BufferedInputStream((new FileInputStream("C:\\Users\\Harlock\\Documents\\NetBeansProjects\\ActiveStudyJC\\src\\Day2\\ajnomoto.txt")));
            outputStream = new BufferedOutputStream((new FileOutputStream("C:\\Users\\Harlock\\Documents\\NetBeansProjects\\ActiveStudyJC\\src\\Day2\\characteroutput.txt")));

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
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

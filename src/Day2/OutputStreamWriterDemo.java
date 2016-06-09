/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
/**
 *
 * @author Harlock
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {

        String s = "C:\\Users\\Harlock\\Documents\\NetBeansProjects\\ActiveStudyJC\\src\\Day2\\ajnomoto.txt";
        String arr="Có khi bước trên đường hun hút.";
        Writer writer;
        OutputStream out;
        try {
        out = new FileOutputStream(s);
        writer = new OutputStreamWriter(out);
        writer.write(arr);
        writer.flush();
        } catch (Exception ex) {
        }
 
}

}

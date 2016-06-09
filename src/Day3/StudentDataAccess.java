/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;
import java.util.List;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Harlock
 */
public class StudentDataAccess {
    String fileWriteBinary = "C:\\Users\\Harlock\\Documents\\NetBeansProjects\\ActiveStudyJC\\src\\Day3\\Day3.dat";
    String  fileWriteText = "C:\\Users\\Harlock\\Documents\\NetBeansProjects\\ActiveStudyJC\\src\\Day3\\Day3.txt";
    FileOutputStream outFile;
    FileInputStream inFile;
    ObjectOutputStream outStream;
    ObjectInputStream inStream;
    Writer writer;
    OutputStreamWriter outWrite;
    DataOutputStream  Out;
    PrintWriter in;
   
      //Ghi file Txt
     public void writeTextFile(List<Student> listStudent) throws ClassNotFoundException, IOException{
        try {
            outFile = new FileOutputStream(fileWriteText,false);// false : ghi đè file mới
            writer = new OutputStreamWriter(outFile,"UTF8");
            for (Student student : listStudent) {
                writer.write(student.toString()+System.lineSeparator());
            }
            }
        finally{
            if(outFile!=null)
            outFile.close();
            writer.close();
        }
    }

   // Doc file txt
     public static List<Student> readToTextFile(String path) 
        throws ClassNotFoundException,FileNotFoundException{
        List<Student> list =  new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(path))) {
        while (fileScanner.hasNext()){
            list.add(new Student(fileScanner.next(),
            fileScanner.next(), fileScanner.nextInt()));
        }
        }
        return list;
    }
    //Ghi file Dat
    public void writeToBinaryFile(List<Student> listStudent)
        throws ClassNotFoundException, IOException{
        try {
            outStream = new ObjectOutputStream(new FileOutputStream(fileWriteBinary,false));
            outStream.writeObject(listStudent);
            }
        finally{
            if(outFile==null){
            outFile.close();
            outStream.close();
            }
        }
    }
    //Doc file Dat
      public List<Student> readToBinaryFile(String path) 
          throws ClassNotFoundException,FileNotFoundException,IOException{
        List<Student> list = null;
        try {
            inFile = new FileInputStream(path);
            inStream = new ObjectInputStream(inFile);
            list=(List<Student>) inStream.readObject();
            }
        finally{
            if(inFile!=null)
            inFile.close();
            inStream.close();
        }
        return list;
    }
    
}

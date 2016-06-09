/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day5;

import Day3.Student;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Harlock
 */
public class Bai1 {
    public static void main(String[] args) throws IOException {
        String file ="D:\\Jav\\ActiveStudyJC\\src\\Day5\\a.txt";
        Set set = readFile(file).entrySet(); 
        Iterator i = set.iterator();
        while(i.hasNext()) {
        Map.Entry me = (Map.Entry)i.next();
       // System.out.println(me.getKey() + ": ");
        System.out.println(me.getValue());
      }
    }
    public static HashMap<Integer, String[]> readFile(String filePach)
        throws FileNotFoundException, IOException{
        HashMap<Integer, String[]> characterList = new HashMap<> ();
        String[] crt;
//BufferedReader in = new BufferedReader(new FileReader(filePach));
        int keys = 0;
       try (DataInputStream in =new DataInputStream(
           new FileInputStream(filePach)) ) {
           int a;
        while ((a=in.read())!=-1){
            
       // characterList.put(keys,String.valueOf(a));
        keys++;
        }
        return characterList;
    }}
}

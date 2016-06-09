/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Harlock
 */
public class FileJoiner {
    public static void main(String[] args) 
        throws FileNotFoundException, IOException {
        List<String> listFile = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int b;
        String nameFileList = sc.next();
        listFile.addAll(Arrays.asList(nameFileList.split(",")));
        String nameFile;
        nameFile = listFile.get(0).substring(0, listFile.get(0).length()-1);
        try (BufferedOutputStream output = new BufferedOutputStream(
            new FileOutputStream(nameFile))) {
            for(int i=1;i<=listFile.size();i++){
                try (BufferedInputStream input = new BufferedInputStream(
                    new FileInputStream(nameFile+i))) {
                   // byte[] valu = new byte[2048];
                    while (( b=input.read())!=-1) {
                        output.write(b);
                    }
                    //JC-Day3.pdf.1,JC-Day3.pdf.2,JC-Day3.pdf.3
                }
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harlock
 */
public class SplitTest {
   
    public static void main(String[] args) {
        try {
            new SplitTest();
                } catch (Exception ex) {
            Logger.getLogger(SplitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public SplitTest() throws Exception {
       
        fin= new RandomAccessFile(f, "r");
        doPart();
        
       
    }
     File f=new File("tutorial.zip");
        int readInt;
        RandomAccessFile fin,fout;
        byte b[]= new byte[2048];
        long e=0L;
        int j=0;
    public void doPart() throws Exception{
        fout=new RandomAccessFile(f.getPath()+"Part"+j++,"rw");
        while((readInt=fin.read(b))!=-1){
            fout.write(b, 0, readInt);
            e+=readInt;
            if(e==1024*1024*16){
            e=0L;
            fout.close();
            doPart();
        }
    }
    fout.close();
    fin.close();
    }
}

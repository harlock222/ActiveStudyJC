/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day11;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Harlock
 */
public class ReadThread implements Runnable{
// private BlockingQueue bQ = null;
    private BlockingQueue bQ = null;
    private BlockingQueue bQF = null;
    private static  Logger  log = Logger.getLogger(ReadThread.class);
    @Override
    public void run() {
        String pathfile=null;
        Path p =null;
        BufferedReader read=null;
            try {
                while (true) { 
                pathfile= bQF.take().toString();
                log.info(pathfile);
                read = Files.newBufferedReader(Paths.get(pathfile));
                String arr = null;
                while ((arr=read.readLine()) != null) {
                    log.info("put String :"+arr);
                    bQ.put(arr);
                }
                }
            } catch (InterruptedException |IOException ex) {
                log.info(ex);
            }          
} 
    public ReadThread(BlockingQueue bqq,BlockingQueue bQF) {
        this.bQ=bqq;
        this.bQF=bQF;
    } 
}

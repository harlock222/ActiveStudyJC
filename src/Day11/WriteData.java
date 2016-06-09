/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day11;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

/**
 *
 * @author Harlock
 */
public class WriteData implements Runnable {
    private BlockingQueue bq ;
    private final String pathfile;
    private static Logger  log = Logger.getLogger(WriteData.class);

    public WriteData(BlockingQueue bq, String pathfile) {
        this.bq = bq;
        this.pathfile = pathfile;
    }

   
    @Override
    public void run() {
        Path p = Paths.get(pathfile);
        try( BufferedWriter writer =Files.newBufferedWriter(p)) {
            log.info("Write ...");
            
            while (true) {
                String arr = (String) bq.poll(120,TimeUnit.MICROSECONDS);
                if(arr!=null){
                    writer.write(arr+"\n");
                    writer.flush();
                }
            }
        } catch (Exception e) {
            log.error("Thread Interrupted :",e);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.BlockingQueue;
import org.apache.log4j.Logger;

/**
 *
 * @author Harlock
 */
public class CheckFile implements Runnable{
private Path pathFlie = null;
private BlockingQueue bQF = null;
private static  Logger  log = Logger.getLogger(CheckFile.class);
    public CheckFile(Path pathFlie,BlockingQueue bQF) {
        this.bQF=bQF;
        this.pathFlie=pathFlie;
    }
    @Override
    public void run() {
        File file = pathFlie.toFile();
        while (true) {            
            if(file.isDirectory()){
            for (String path : file.list()) {
                 bQF.add(path);
            log.info(file);
            }
            log.info("Now watching the current directory ...");
            try {

                WatchService ws = pathFlie.getFileSystem().newWatchService();
                pathFlie.register(ws, ENTRY_CREATE);
                WatchKey wk = ws.take();
                while (wk!=null) {            
                    for (WatchEvent<?> we : wk.pollEvents()) {
                      String arr= we.context().toString();
                      log.info(we.kind().name()+"   "+arr);
                      bQF.put(arr);
                      wk.reset();
                      wk= ws.take();
                    }
                }
            } catch (IOException |InterruptedException ex) {
                log.info(ex);
            } 
        }
        }
        
   
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day11;

import java.util.concurrent.BlockingQueue;
import org.apache.log4j.Logger;

/**
 *
 * @author Harlock
 */
public class CheckData implements Runnable{
 private static Logger  log= Logger.getLogger(CheckData.class);;
 //private BlockingQueue bq ;
 private BlockingQueue bq ;
 //private BlockingQueue dung ;
 private BlockingQueue dung ;
 //private BlockingQueue sai ;
 private BlockingQueue sai ;

    public CheckData(BlockingQueue bq, BlockingQueue dung, BlockingQueue sai) {
        
        this.bq = bq;
        this.dung = dung;
        this.sai = sai;
    }

public boolean check(String b) throws InterruptedException{
    String[]  fuck =b.split("[|]");
    String num =fuck[0];
    String body =fuck[1];
    if(num.startsWith("84")){
      if(((num.length())>10)&&((num.length())<12)){
        return !((body.contains("fuck"))
            ||(body.contains("shit"))||(body.contains("DCM")));
    }  
    }
    return false;
}
   

    
    @Override
    public void run() {
     try { 
         log.info("Thread start ....");
         while (true) { 
            String arr = (String) bq.take();
            log.debug("Take arr :"+arr);
            if(check(arr)){
               dung.put(arr);
               log.info("Take arr :"+arr);
            }else{
               log.info("Take arr :"+arr);
                sai.put(arr);
            }
         }
         
     } catch (InterruptedException ex) {
        log.error("Thread Interrupted",ex);
     }
    }

   
    
}

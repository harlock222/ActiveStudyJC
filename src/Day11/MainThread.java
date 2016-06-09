/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day11;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.apache.log4j.xml.DOMConfigurator;

/**
 *
 * @author Harlock
 */
public class MainThread {
    public static void main(String[] args) throws InterruptedException 
    {
         String pathO ="./output/";
         String pathI ="./input/";
        DOMConfigurator.configureAndWatch("./config/log4j.xml");
        BlockingQueue bq = new ArrayBlockingQueue(1024);
        BlockingQueue bQF = new ArrayBlockingQueue(1024);
        BlockingQueue dung = new ArrayBlockingQueue(1024);
        BlockingQueue sai = new ArrayBlockingQueue(1024);
        ReadThread rt = new ReadThread(bq,bQF);
        CheckData cd = new CheckData(bq,dung,sai);
        WriteData wdd = new WriteData(dung,pathO+ "dung.txt");
        WriteData wds = new WriteData(sai,pathO+ "sai.txt");
        new Thread(rt).start();
        new Thread(cd).start();
        new Thread(wds).start();
        new Thread(wdd).start();
        Path p = Paths.get(pathI);
        CheckFile cf = new CheckFile(p,bQF);
        new Thread(cf).start();
    }
}

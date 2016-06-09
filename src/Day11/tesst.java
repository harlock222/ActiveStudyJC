/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day11;

import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 *
 * @author Harlock
 */
public class tesst {
    private static final MyQueue mq = new MyQueue(12);
    public static void main(String[] args) {
        
            Path this_dir = Paths.get("./input/");
        System.out.println("Now watching the current directory ...");

        try {
            WatchService watcher = this_dir.getFileSystem().newWatchService();
            this_dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
            WatchKey watckKey = watcher.take();
            while (watckKey != null) {                
                for (WatchEvent<?> event : watckKey.pollEvents()) {
                System.out.println(event.kind().name() +"\t" + event.context().toString());
                watckKey.reset();
                watckKey = watcher.take();
            }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}

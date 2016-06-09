/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day11;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Harlock
 */
public class MyQueue {
    private final Queue<String> queue = new LinkedList<>();
    private int capacity;
    Object obj = new Object();

    public MyQueue(int capacity) {
        this.capacity = capacity;
    }
    
    public  void addd(String e) throws InterruptedException{
            synchronized(obj){
                while(queue.size()==capacity){
                    obj. wait();
                }
                queue.offer(e);
                obj. notify();  
            }   
    }
    
    public  String getString() throws InterruptedException{
        synchronized(obj){
            while (queue.size()==0) {
             obj.wait();
            }
            String a =queue.poll();
            obj.notify();
            return a;
        }
        }
    
            
       
    
}

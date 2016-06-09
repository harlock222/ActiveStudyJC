/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day10;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.SendingContext.RunTime;

/**
 *
 * @author Harlock
 */
public class Test {
  static final ArrayList<Integer> liss = new ArrayList<>();
  int a=0;
  public  void add(){
   a++;
   liss.add(a);
  }
    public static void main(String[] args) throws InterruptedException {
       final Test t = new Test();
        for (int i = 0; i < 10; i++) {
        new Thread(new Runnable() {
        @Override
        public void run() {
        t.add();
        }
        }).start();
        }
        Thread.sleep(100);
        System.out.println(liss);
    }
    
}

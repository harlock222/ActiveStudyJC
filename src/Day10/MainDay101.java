package Day10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harlock
 */
public class MainDay101 {
    public static void main(String[] args) {
        final Account1 ac = new Account1();
       // final Object obj = new Object();
        for(int i=0;i<100;i++){
            
                new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(ac.tangBalance());
                }
            }).start();
            }
           
        }
    
}
class Account1 {
  private int balance;
  public synchronized int tangBalance(){
      return balance++;
  }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day10;

/**
 *
 * @author Harlock
 */
public class MainDay10 {
    public static void main(String[] args) {
        final Account ac = new Account();
        final Object obj = new Object();
        for(int i=0;i<100;i++){
            synchronized(obj){
                 new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(ac.tangBalance());
                }
            }).start();
            }
           
        }
    }
}

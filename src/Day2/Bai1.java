/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import java.util.Scanner;

/**
 *
 * @author Harlock
 */
public class Bai1 {
   
   
    public void Bai1(){
        
       
        
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continuteinput;
        System.out.println("------------------------");
        System.out.println("-------Bài 1---------");
            Ex1 ex;    
        do {            
          try {  
            System.out.print("Nhập số nguyên :");
             ex= new Ex1(input.nextInt());
            System.out.println(ex.toString());
            continuteinput=true;
            } catch (Exception e) {
                System.out.println(e.toString());
                ex = new Ex1(input.nextInt());
            }  
        } while (continuteinput=false);
            
        
    }
}

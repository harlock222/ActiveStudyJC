/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day4;
import java.util.Stack; 
/**
 *
 * @author Harlock
 */
public class DemoStack {
    public static void main(String[] agrs){ 
        Stack<Integer> s = new Stack<>(); 
        for(int i = 1; i < 10 ; i++){ 
             // them phan tu vao dau stack 
            s.push(i);
            } 
        //tra ve phan tu dau stack va ko loai bo no ra khoi stack 
        System.out.println("Peek:= "+s.peek());
        //tra ve vi tri trong stack tinh tu dau stack neu ko co tra ve -1  
        System.out.println("Search "+s.search(16));
        while(!s.empty()){       
            // loai bo phan tu dau ra khoi stack 
            System.out.println(s.pop());
                     
        } 
    } 
}

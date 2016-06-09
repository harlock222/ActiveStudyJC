/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day4;

import java.util.LinkedList;

/**
 *
 * @author Harlock
 */
public class DemoLinkedList {
    public static void main(String[] args){
LinkedList link=new LinkedList();
link.add("a");
link.add("b");
link.add(new Integer(10));
link.addFirst(new Integer(20));
link.addLast("c");
link.add(2,"j");
link.add(1,"t");
link.remove(3);
System.out.println("Phan tu dau tien :"+link.getFirst());
System.out.println("Phan tu cuoi :"+link.getLast());
System.out.println("so phan tu:"+link.size());
}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day7.Bai3;

import java.io.Serializable;

/**
 *
 * @author Harlock
 */
public class Dog implements Serializable {
    private String  name;
    private int hieght;

    public String getName() {
        return name;
    }

    public Dog(String name, int hieght) {
        this.name = name;
        this.hieght = hieght;
    }

    public int getHieght() {
        return hieght;
    }

  
}

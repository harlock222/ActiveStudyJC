/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day7.Bai4;

import java.io.Serializable;

/**
 *
 * @author Harlock
 */
public class Person implements Serializable {
    private String  name;
    private  String chat;

    public String getName() {
        return name;
    }

    public Person(String name, String chat) {
        this.name = name;
        this.chat = chat;
    }

    @Override
    public String toString() {
        return   name + "_:" + chat ;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

  
}

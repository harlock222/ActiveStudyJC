/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day7.Bai4;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harlock
 */
public class Client {

    public static void main(String[] args)  throws EOFException{
        try {

            final Socket soc = new Socket("localhost", 1150);
            final Scanner sc = new Scanner(System.in);

            System.out.println("Nhap ten :");
            final String name = sc.nextLine();
            System.out.println("Start .... chat !");

            new Thread(new Runnable() {

                String msg = "Chattting";
                Person ps = new Person(name, msg);

                @Override
                public void run() {
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
                        do {
                            ps.setChat(sc.nextLine());
                            oos.writeObject(ps);
                            oos.flush();
                            oos.reset();
                        } while (true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        ObjectInputStream ois = null;
                        try {
                            ois = new ObjectInputStream(
                                soc.getInputStream());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        Person ps = null;
                        
                        try {
                            ps = (Person) ois.readObject();
                        } catch (IOException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        if (ps != null) {
                            System.out.println(ps.toString());
                        }
                    }
                }
            }).start();

        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
}

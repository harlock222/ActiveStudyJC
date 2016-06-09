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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Harlock
 */
public class Server {

    private static String message = "";
    private static Socket soc;

    public static void main(String args[]) throws EOFException{
        try {
            final ServerSocket sk = new ServerSocket(1150);
            System.out.println("Chatroom  starting...");
            final ArrayList<Socket> listSoc = new ArrayList<>();
            while (true) {
                soc = sk.accept();
                listSoc.add(soc);
                System.out.println("number of client is " + listSoc.size());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ObjectInputStream ois = new ObjectInputStream(
                                soc.getInputStream());;
                            while (true) {
                                
                                Person ps = (Person) ois.readObject();
                                for (Socket s : listSoc) {
                                    
                                        ObjectOutputStream oos = new ObjectOutputStream(
                                        s.getOutputStream());
                                    oos.writeObject(ps);
                                    oos.flush();
                                    
                                }
                            }
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class nhan {

}

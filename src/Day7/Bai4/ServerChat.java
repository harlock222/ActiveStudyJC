package Day7.Bai4;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nam
 */
public class ServerChat {

    static List<Socket> list;

    public static void main(String[] args) throws IOException {

        ServerSocket svsk = new ServerSocket(1111);
        list = new LinkedList<>();
        System.out.println("Connecting...");
        try {
            while (true) {
                final Socket sk = svsk.accept();
                System.out.println("Client connected");
                list.add(sk);

                Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        receive(sk);
                    }
                });
                thread1.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void receive(Socket sk) {
        ObjectInputStream in = null;
        try {
            while (true) {
                in = new ObjectInputStream(sk.getInputStream());
                //BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                String message = (String) in.readObject();
                //String message = in.readLine();
                send(message);
            }

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void send(String message) {
        for (Socket socket : list) {
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(socket.getOutputStream());
                //PrintWriter out = new PrintWriter(socket.getOutputStream());
                oos.writeObject(message);
                oos.flush();
                //out.println(message);
                //out.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

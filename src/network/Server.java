package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private ObjectInputStream inStream = null;

    public Server() {

    }

    public void communicate() {
        try {
            serverSocket = new ServerSocket(7777);
            socket = serverSocket.accept();
            System.out.println("Connected");
            inStream = new ObjectInputStream(socket.getInputStream());

            testobject to = (testobject) inStream.readObject();
            System.out.println("Object received = " + to);
            System.out.println(to.id);
            System.out.println(to.value);
            socket.close();

        } catch (SocketException se) {
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        }
    }

}
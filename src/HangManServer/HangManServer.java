package HangManServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HangManServer {

    private static final int port = 6910;
    private ServerSocket serverSocket = null;
    private Socket socket;

    public HangManServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("I'm working");
        } catch (IOException ex) {
            Logger.getLogger(HangManServer.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }

    public void work() {
        while (true) {
            if (serverSocket == null) {
                break;
            }

            try {
                socket = serverSocket.accept();
                System.out.println("New client");

                ClientHandler handler = new ClientHandler(socket);
                handler.start();
            } catch (IOException ex) {
                Logger.getLogger(HangManServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HangManServer server = new HangManServer();
        server.work();
    }

}

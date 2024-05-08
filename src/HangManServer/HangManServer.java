package HangManServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HangManServer {

    private static final int port = 6899;
    private ServerSocket serverSocket;

    public HangManServer() {

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running");
        } catch (IOException e) {
            System.out.println("Server can't be initialized");
            System.exit(0);
        }
    }

    public void work() {
        Socket socket;

        while (true) {

            if (serverSocket == null) {
                return;
            }

            try {
                socket = serverSocket.accept();
                System.out.println("Client comes: I sent a message");

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Działa działa");

                out.close();
                socket.close();
                System.out.println("Client left");
            } catch (IOException e) {
                System.out.println("issue");
                System.exit(0);
            }

        }
    }

    public static void main(String[] args) {
            HangManServer server = new HangManServer();
            server.work();
    }

}

package HangManClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JFrame;

public class HangMan extends JFrame {

    public HangMan() {
        setTitle("HangMan Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public void connectWithServer() {
        int port = 6899;
        String adress = "127.0.0.1";
        Socket socket = null;

        try {
            System.out.println("I'm connecting to the server");
            socket = new Socket(adress, port);
        } catch (IOException e) {
            System.out.println("I can't connect to the server");
        }

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String info = in.readLine();
            System.out.println("I got from server: " + info);
            socket.close();
            in.close();

        } catch (IOException e) {

        }
    }


}

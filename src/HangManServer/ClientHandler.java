package HangManServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.socket = socket;

    }

    @Override
  public void run() {
    try {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello client");
            
        String info;
        while ((info = in.readLine()) != null) {
            if (info.equals("end")) {
                System.out.println("I get message - " + info);
                break;
            }
             if (info.equals("Hello")) {
                System.out.println("I get message - " + info);
               
            }
              if (info.equals("Hello again")) {
                System.out.println("I get message - " + info);
               
            }

            
            
            

           
        }
        System.out.println("Client leaves");
        in.close();
        out.close();
        socket.close();
    } catch (IOException ex) {
        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


}

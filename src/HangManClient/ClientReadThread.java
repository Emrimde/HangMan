
package HangManClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientReadThread extends Thread {

    
    BufferedReader in;
    
    public ClientReadThread(Socket socket) {
        
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ClientReadThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
   public void run() {
    String info;
    try {
        while ((info = in.readLine()) != null) {
            System.out.println("Server sends: " + info);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    
    
}


package HangManClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Main {
    public static void main(String[] args) {
        HangMan hangMan = new HangMan();
        hangMan.connectWithServer();
 
    }
}

package HangManServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HangManServer {

    private ArrayList<Word> words;
    private static final int port = 6910;
    static ServerSocket serverSocket = null;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    

    public HangManServer() {
        words = new ArrayList<>();
        getWords();
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
            System.out.println("new client");

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



    public void getWords() {
        Word word1 = new Word("elephant");
        Word word2 = new Word("computer");
        Word word3 = new Word("sunshine");
        Word word4 = new Word("Necklace");
        Word word5 = new Word("Scissors");
        Word word6 = new Word("Hospital");
        Word word7 = new Word("Rainbow");
        Word word8 = new Word("Diamond");
        Word word9 = new Word("Keyboard");
        Word word10 = new Word("Mountain");
        Word word11 = new Word("Sandwich");
        Word word12 = new Word("Painting");
        Word word13 = new Word("Internet");
        Word word14 = new Word("Firework");
        Word word15 = new Word("Umbrella");
        Word word16 = new Word("Airplane");
        Word word17 = new Word("Football");
        Word word18 = new Word("Necklace");
        Word word19 = new Word("Birthday");
        Word word20 = new Word("Medicine");
        Word word21 = new Word("Triangle");
        Word word22 = new Word("Pancakes");
        Word word23 = new Word("Building");
        Word word24 = new Word("Cupboard");
        Word word25 = new Word("Daughter");
        Word word26 = new Word("Morning");
        Word word27 = new Word("Whistle");
        Word word28 = new Word("Adventure");
        Word word29 = new Word("Butterfly");
        Word word30 = new Word("Telescope");

        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);
        words.add(word5);
        words.add(word6);
        words.add(word7);
        words.add(word8);
        words.add(word9);
        words.add(word10);
        words.add(word11);
        words.add(word12);
        words.add(word13);
        words.add(word14);
        words.add(word15);
        words.add(word16);
        words.add(word17);
        words.add(word18);
        words.add(word19);
        words.add(word20);
        words.add(word21);
        words.add(word22);
        words.add(word23);
        words.add(word24);
        words.add(word25);
        words.add(word26);
        words.add(word27);
        words.add(word28);
        words.add(word29);
        words.add(word30);

    }

    public static void main(String[] args) {
        HangManServer server = new HangManServer();
        server.work();
    }

}

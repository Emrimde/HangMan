package HangManServer;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler extends Thread {

    private ArrayList<String> words;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        words = new ArrayList<>();
        addWords();
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello client");

            String info;
            String wordOfTheGame = "";
            int numberOfLettersToGuess = 0;
            int attempts = 0;
            char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

            while ((info = in.readLine()) != null) {
                if (info.equals("end")) {
                    System.out.println("I get message - " + info);
                    break;
                }
                if (info.equals("Connection has begun!")) {
                    System.out.println("I get message - " + info);
                }
                if (info.equals("word")) {
                    attempts = 0;
                    System.out.println("I get message - " + info);
                    Random randomizer = new Random();

                    int index = randomizer.nextInt(words.size());
                    String word = words.get(index);
                    wordOfTheGame = word;
                    numberOfLettersToGuess = wordOfTheGame.length();
                    System.out.println("Number of letters to guess" + numberOfLettersToGuess);
                    out.println(words.get(index));
                    out.println("LENGTH" + numberOfLettersToGuess);
                }

                
                 // ODEBRANIE OD SERWERA LITERKI 3 (GAME.JAVA)
                if (info.equals("A") || info.equals("B") || info.equals("C") || info.equals("D") || info.equals("E")
                        || info.equals("F") || info.equals("G") || info.equals("H") || info.equals("I") || info.equals("J")
                        || info.equals("K") || info.equals("L") || info.equals("M") || info.equals("N") || info.equals("O")
                        || info.equals("P") || info.equals("Q") || info.equals("R") || info.equals("S") || info.equals("T")
                        || info.equals("U") || info.equals("V") || info.equals("W") || info.equals("X") || info.equals("Y")
                        || info.equals("Z")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();
                    for(char letter : alphabet){
                        if (wordOfTheGame.contains(String.valueOf(letter))){
                             for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == letter) {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }
                             
                        }
                    }
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

    public void addWords() {
        words.add("elephant");
        words.add("computer");
        words.add("sunshine");
        words.add("necklace");
        words.add("scissors");
        words.add("hospital");
        words.add("rainbow");
        words.add("diamond");
        words.add("keyboard");
        words.add("mountain");
        words.add("sandwich");
        words.add("painting");
        words.add("internet");
        words.add("firework");
        words.add("umbrella");
        words.add("airplane");
        words.add("football");
        words.add("grandma");
        words.add("birthday");
        words.add("medicine");
        words.add("triangle");
        words.add("pancakes");
        words.add("building");
        words.add("cupboard");
        words.add("daughter");
        words.add("morning");
        words.add("whistle");
        words.add("adventure");
        words.add("butterfly");
        words.add("telescope");
    }
}

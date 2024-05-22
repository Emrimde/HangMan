package HangManClient;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class ClientReadThread extends Thread {
    BufferedReader in;
    static int lengthOfWord = 0;
    static int attempts = 0;
    static int numberOfLettersToGuess = 10;
    static String word;

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

                if (info.contains("WORD")) {
                    info = info.replace("WORD", "");
                    word = info;
                    System.out.println(word);
                    lengthOfWord = word.length();
                }
                
                if (info.contains("Position")) {
                    info = info.replace("Position", ""); // Usunięcie słowa "Position"
                    info = info.replace("[", "");
                    info = info.replace("]", ",");
                
                    String[] parts = info.split(",");
                    ArrayList<Integer> positions = new ArrayList<>();

                    for (String part : parts) {
                        if (!part.isEmpty()) {
                            positions.add(Integer.parseInt(part.trim()));
                        }
                    }

                    for (int i = 0; i < lengthOfWord; i++) {
                        for (Integer position : positions) {
                            if (i == position) {
                                String letter = Game.buttonText;
                                Game.labels.get(i).setText(letter);
                            }
                        }
                    }
                   
                    System.out.println("Pozycje: " + positions);
                }

                if (info.contains("Wrong")) {
                    info = info.replace("Wrong", "");
                    int wrongLetterAttempt = Integer.parseInt(info);
                    System.out.println("Bad letter - total number of attempts " + wrongLetterAttempt);
                    synchronized (ClientReadThread.class) {
                        attempts = wrongLetterAttempt;
                    }
                    // Repaint the Game instance after updating attempts
                    Game.gameInstance.repaint();
                }

                if (info.contains("LENGTH")) {
                    info = info.replace("LENGTH", "");
                    int lengthToWin = Integer.parseInt(info);
                    synchronized (ClientReadThread.class) {
                        numberOfLettersToGuess = lengthToWin;
                    }
                    System.out.println("LICZBA LITER DO ODGADNIECIA" + lengthToWin);
                    if (numberOfLettersToGuess == 0) {
                        SwingUtilities.invokeLater(() -> Game.gameInstance.showWinMessage(true));
                    }
                }
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

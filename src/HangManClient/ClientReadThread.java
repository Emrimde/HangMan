package HangManClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

                checkIfMessage(info);
                //4 obsluzenie position
                if (info.contains("Position")) {
                    info = info.replace("Position", ""); // Usunięcie słowa "Position"
                    info = info.replace("[", "");
                    info = info.replace("]", ",");
                    //System.out.println(info);

                    String[] parts = info.split(",");
                    ArrayList<Integer> positions = new ArrayList<>();

                    for (String part : parts) {
                        if (!part.isEmpty()) {
                            positions.add(Integer.parseInt(part.trim()));
                        }
                    }
                    
                    for(int i = 0; i < lengthOfWord; i++){
                        for(Integer position: positions){
                            if(i == position){
                                String letter = Game.buttonText;
                                Game.labels.get(i).setText(letter);
                            }
                        }
                    }
                    // Wyświetlenie zawartości listy positions
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
            
            if(info.contains("LENGTH"))
            {
                info = info.replace("LENGTH", "");
                 int lengthToWin = Integer.parseInt(info);
                synchronized(ClientReadThread.class){
                    numberOfLettersToGuess = lengthToWin;
                }
                System.out.println("LICZBA LITER DO ODGADNIECIA" + lengthToWin );
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

    private void checkIfMessage(String info) {
        if (info.equals("elephant")) {
            word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("computer")) {
            word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("sunshine")) {
            word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("necklace")) {
            word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("scissors")) {
            word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("hospital")) {
            word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("rainbow")) {
            word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("diamond")) {
            word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("keyboard")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("mountain")) {
            word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("sandwich")) {
            word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("painting")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("internet")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("firework")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("umbrella")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("airplane")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("football")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("grandma")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("birthday")) {
            word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("medicine")) {
            word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("triangle")) {
            word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("pancakes")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("building")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("cupboard")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("daughter")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("morning")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("whistle")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("adventure")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("butterfly")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("telescope")) {
             word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
      
    }

    public int getNumberOfLetters(String word) {
        return word.length();
    }
    
    
}

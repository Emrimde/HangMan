package HangManClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientReadThread extends Thread {

    BufferedReader in;
    static int lengthOfWord = 0;
    static int attempts = 0;

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
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("computer")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("sunshine")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("necklace")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("scissors")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("hospital")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("rainbow")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("diamond")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("keyboard")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("mountain")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("sandwich")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("painting")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("internet")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("firework")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("umbrella")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("airplane")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("football")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("grandma")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("birthday")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("medicine")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("triangle")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("pancakes")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("building")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("cupboard")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("daughter")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("morning")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("whistle")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("adventure")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("butterfly")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
        if (info.equals("telescope")) {
            String word = info;
            System.out.println(word);
            lengthOfWord = word.length();
        }
      
    }

    public int getNumberOfLetters(String word) {
        return word.length();
    }
    
    
}

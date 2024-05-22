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
                if (info.equals("A")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("a")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'a') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);

                        System.out.println("Ten wyraz zawiera litere a");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("B")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("b")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'b') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere B");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("C")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("c")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'c') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere C");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("D")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("d")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'd') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere D");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("E")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("e")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'e') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere E");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("F")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("f")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'f') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere F");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("G")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("g")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'g') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere G");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("H")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("h")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'h') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere H");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("I")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("i")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'i') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere I");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("J")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("j")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'j') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere J");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("K")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("k")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'k') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere K");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("L")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("l")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'l') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere L");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("M")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("m")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'm') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere M");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("N")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("n")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'n') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere N");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("O")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("o")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'o') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere O");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("P")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("p")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'p') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere P");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("Q")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("q")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'q') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere Q");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("R")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("r")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'r') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere R");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("S")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("s")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 's') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere S");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("T")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("t")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 't') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere T");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("U")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("u")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'u') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere U");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("V")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("v")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'v') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere V");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("W")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("w")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'w') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere w");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("X")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("x")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'x') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere x");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("Y")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("y")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'y') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }

                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere y");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

                    }

                }
                if (info.equals("Z")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("z")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'z') {
                                positions.add(i);
                                numberOfLettersToGuess--;
                                out.println("LENGTH" + numberOfLettersToGuess);
                            }
                        }
                        // wysyla do client read thread 4
                        out.println("Position" + positions);
                        System.out.println("Ten wyraz zawiera litere z");
                    } else {
                        System.out.println("Nie ma litery");
                        attempts++;
                        out.println("Wrong" + attempts);

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

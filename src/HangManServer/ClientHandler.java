package HangManServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler extends Thread {

    private ArrayList<Word> words;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        words = new ArrayList<>();
        getWords();

    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello client");

            String info;
            String wordOfTheGame = "";
            int lengthToWin = 0;
            int attempts = 0;
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
                if (info.equals("word")) {
                    attempts = 0;
                    System.out.println("I get message - " + info);
                    Random randomizer = new Random();

                    int index = randomizer.nextInt(words.size());
                    Word word = words.get(index);
                    wordOfTheGame = word.getWord();
                    lengthToWin = wordOfTheGame.length();
                    System.out.println("LICZBA LITEREK DO ODGADNIECIA " + lengthToWin);
                    out.println(words.get(index));
                }

                // ODEBRANIE OD SERWERA LITERKI 3 (GAME.JAVA)
                if (info.equals("A")) {
                    System.out.println("I get message - " + info + " " + wordOfTheGame);
                    ArrayList<Integer> positions = new ArrayList<>();

                    if (wordOfTheGame.contains("a")) {
                        for (int i = 0; i < wordOfTheGame.length(); i++) {
                            if (wordOfTheGame.charAt(i) == 'a') {
                                positions.add(i);
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

    public void getWords() {
        Word word1 = new Word("elephant");
        Word word2 = new Word("computer");
        Word word3 = new Word("sunshine");
        Word word4 = new Word("necklace");
        Word word5 = new Word("scissors");
        Word word6 = new Word("hospital");
        Word word7 = new Word("rainbow");
        Word word8 = new Word("diamond");
        Word word9 = new Word("keyboard");
        Word word10 = new Word("mountain");
        Word word11 = new Word("sandwich");
        Word word12 = new Word("painting");
        Word word13 = new Word("internet");
        Word word14 = new Word("firework");
        Word word15 = new Word("umbrella");
        Word word16 = new Word("airplane");
        Word word17 = new Word("football");
        Word word18 = new Word("grandma");
        Word word19 = new Word("birthday");
        Word word20 = new Word("medicine");
        Word word21 = new Word("triangle");
        Word word22 = new Word("pancakes");
        Word word23 = new Word("building");
        Word word24 = new Word("cupboard");
        Word word25 = new Word("daughter");
        Word word26 = new Word("morning");
        Word word27 = new Word("whistle");
        Word word28 = new Word("adventure");
        Word word29 = new Word("butterfly");
        Word word30 = new Word("telescope");

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

}

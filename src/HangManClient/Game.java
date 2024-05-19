package HangManClient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Game extends JFrame implements WindowListener, ActionListener {

    private String level;

    private PrintWriter out;
    private BufferedReader in;
    private Socket socket;
    static ArrayList<JLabel> labels;
    static String buttonText = "";
    static Game gameInstance;

    public Game(String level, Socket socket) {
        this.level = level;
        this.socket = socket;
        gameInstance = this;
        labels = new ArrayList<>();
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

        out.println("word");
        

        JPanel upperPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        JPanel mainBannedPanel = new JPanel();
        JPanel keyboardPanel = new JPanel();
        JPanel bannedPanel1 = new JPanel();
        JPanel bannedPanel2 = new JPanel();
        PanelForWord panel1 = new PanelForWord();

        JLabel bannedHeader = new JLabel("Banned letters");
        JLabel bannedLetters1 = new JLabel("a,b,c,d,e,f,g,h,i,j,k");
        JLabel bannedLetters2 = new JLabel("a,b,c,d,e,f,g,h,i,j,k");
        JLabel timeLabel = new JLabel("Time 2:00");

        // Tworzenie przycisków z literami alfabetu
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (char letter : alphabet) {
            JButton button = new JButton(String.valueOf(letter));
            button.setForeground(Color.yellow);
            button.setFont(new Font("MV Boli", Font.PLAIN, 18));
            button.setBackground(new Color(21, 194, 82));
            button.setBorder(BorderFactory.createLineBorder(Color.yellow, 2, true));
            button.setPreferredSize(new Dimension(35, 35));
            button.setFocusable(false);
            //button.addActionListener(this); // Dodanie nasłuchiwacza zdarzeń
            keyboardPanel.add(button); // Dodanie przycisku do ramki

            button.addActionListener(e -> {
                JButton clickedButton = (JButton) e.getSource();
                buttonText = clickedButton.getText();
                System.out.println("Kliknięto przycisk: " + buttonText);
                // WYSLANIE DO SERWERA LITERKI 3
                out.println(buttonText);
                clickedButton.setEnabled(false);
                // Tutaj dodaj odpowiednie działania, które mają być wykonane po kliknięciu przycisku
               
            });
        }

        
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        upperPanel.setLayout(null);
        upperPanel.setPreferredSize(new Dimension(700, 400));
        upperPanel.setBackground(new Color(24, 179, 240));

        bottomPanel.setBackground(new Color(21, 194, 82));
        bottomPanel.setPreferredSize(new Dimension(700, 300));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));


        keyboardPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        keyboardPanel.setPreferredSize(new Dimension(400, 200));
        keyboardPanel.setBackground(new Color(21, 194, 82));

        panel1.setBounds(125, 50, 450, 100);
        panel1.setBackground(new Color(24, 179, 240));

        panel1.setLayout(null);

        JLabel labelForletter1 = new JLabel("");
        JLabel labelForletter2 = new JLabel("");
        JLabel labelForletter3 = new JLabel("");
        JLabel labelForletter4 = new JLabel("");
        JLabel labelForletter5 = new JLabel("");
        JLabel labelForletter6 = new JLabel("");
        JLabel labelForletter7 = new JLabel("");
        JLabel labelForletter8 = new JLabel("");
        JLabel labelForletter9 = new JLabel("");
        JLabel labelForletter10 = new JLabel("");

        labels.add(labelForletter1);
        labels.add(labelForletter2);
        labels.add(labelForletter3);
        labels.add(labelForletter4);
        labels.add(labelForletter5);
        labels.add(labelForletter6);
        labels.add(labelForletter7);
        labels.add(labelForletter8);
        labels.add(labelForletter9);
        labels.add(labelForletter10);

        for (JLabel label : labels) {
            label.setForeground(Color.yellow);
            label.setFont(new Font("MV Boli", Font.PLAIN, 18));
        }
        labelForletter1.setBounds(17, 25, 50, 20);
        labelForletter2.setBounds(62, 25, 50, 20);
        labelForletter3.setBounds(107, 25, 50, 20);
        labelForletter4.setBounds(152, 25, 50, 20);
        labelForletter5.setBounds(197, 25, 50, 20);
        labelForletter6.setBounds(242, 25, 50, 20);
        labelForletter7.setBounds(287, 25, 50, 20);
        labelForletter8.setBounds(332, 25, 50, 20);
        labelForletter9.setBounds(377, 25, 50, 20);
        labelForletter10.setBounds(422, 25, 50, 20);
        panel1.add(labelForletter1);
        panel1.add(labelForletter2);
        panel1.add(labelForletter3);
        panel1.add(labelForletter4);
        panel1.add(labelForletter5);
        panel1.add(labelForletter6);
        panel1.add(labelForletter7);
        panel1.add(labelForletter8);
        panel1.add(labelForletter9);
        panel1.add(labelForletter10);

        bannedPanel1.setPreferredSize(new Dimension(200, 30));
        bannedPanel1.setBackground(new Color(24, 179, 240));

        bannedPanel2.setPreferredSize(new Dimension(200, 30));
        bannedPanel2.setBackground(new Color(24, 179, 240));

        bannedHeader.setForeground(Color.yellow);
        bannedHeader.setFont(new Font("MV Boli", Font.PLAIN, 18));
        mainBannedPanel.add(bannedHeader);

        bannedLetters1.setForeground(Color.yellow);
        bannedLetters1.setFont(new Font(null, Font.PLAIN, 15));
        bannedPanel1.add(bannedLetters1);

        bannedLetters2.setForeground(Color.yellow);
        bannedLetters2.setFont(new Font(null, Font.PLAIN, 15));
        bannedPanel2.add(bannedLetters2);


        timeLabel.setBounds(600, 0, 100, 40);
        timeLabel.setForeground(Color.yellow);
        timeLabel.setFont(new Font(null, Font.PLAIN, 20));

        bottomPanel.add(keyboardPanel);
        upperPanel.add(panel1);
        upperPanel.add(mainBannedPanel);

        upperPanel.add(timeLabel);

        addWindowListener(this);
        add(upperPanel);
        add(bottomPanel);

        setResizable(false);
        setTitle("HangMan Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);

        System.out.println(ClientReadThread.lengthOfWord);
    }

public void showWinMessage() {
    Object[] options = {"Exit", "Try again"};
    int result = JOptionPane.showOptionDialog(
            this,
            "Congratulations! You won!",
            "Win!",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[1] // domyślnie zaznaczona opcja
    );
    if (result == JOptionPane.YES_OPTION) {
        System.out.println("Exit selected");
        // Kod do zakończenia aplikacji
        dispose();
        System.exit(0);
    } else if (result == JOptionPane.NO_OPTION) {
        System.out.println("Try again selected");
        // Uruchom nową grę
        dispose();
        new Game("easy", socket).setVisible(true);
    } else {
        System.out.println("Cancelled");
        // Obsługa anulowania (np. gdy użytkownik zamknie okno dialogowe bez wyboru)
        dispose();
        System.exit(0);
    }
}
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        Stroke oldStroke = g2D.getStroke();
        g2D.setStroke(new BasicStroke(10));
        g2D.setColor(new Color(133, 82, 12));
        int choice;
        synchronized (ClientReadThread.class) {
            choice = ClientReadThread.attempts;
        }
        switch (choice) {
            //case 0: System.out.println("Nothing happens"); break;
            case 1:
                g2D.drawLine(50, 450, 75, 400);
                break;
            case 2:
                g2D.drawLine(50, 450, 75, 400);
                g2D.drawLine(100, 450, 75, 400);
                break;
            case 3:
                g2D.drawLine(50, 450, 75, 400);
                g2D.drawLine(100, 450, 75, 400);
                g2D.drawLine(75, 400, 75, 250);
                break;
            case 4:
                g2D.drawLine(50, 450, 75, 400);
                g2D.drawLine(100, 450, 75, 400);
                g2D.drawLine(75, 400, 75, 250);
                g2D.drawLine(75, 250, 150, 250);
                break;
            case 5:
                g2D.drawLine(50, 450, 75, 400);
                g2D.drawLine(100, 450, 75, 400);
                g2D.drawLine(75, 400, 75, 250);
                g2D.drawLine(75, 250, 150, 250);
                g2D.setStroke(new BasicStroke(2));
                g2D.setColor(Color.gray);
                g2D.drawLine(150, 250, 150, 300);
                break;
            case 6:
                g2D.drawLine(50, 450, 75, 400);
                g2D.drawLine(100, 450, 75, 400);
                g2D.drawLine(75, 400, 75, 250);
                g2D.drawLine(75, 250, 150, 250);
                g2D.setStroke(new BasicStroke(2));
                g2D.setColor(Color.gray);
                g2D.drawLine(150, 250, 150, 300);
                g2D.setColor(Color.black);
                g2D.fillOval(137, 300, 25, 25);
                break;
            case 7:
                g2D.drawLine(50, 450, 75, 400);
                g2D.drawLine(100, 450, 75, 400);
                g2D.drawLine(75, 400, 75, 250);
                g2D.drawLine(75, 250, 150, 250);
                g2D.setStroke(new BasicStroke(2));
                g2D.setColor(Color.gray);
                g2D.drawLine(150, 250, 150, 300);
                g2D.setColor(Color.black);
                g2D.fillOval(137, 300, 25, 25);
                g2D.drawLine(150, 325, 150, 350);
                break;
            case 8:
                g2D.drawLine(50, 450, 75, 400);
                g2D.drawLine(100, 450, 75, 400);
                g2D.drawLine(75, 400, 75, 250);
                g2D.drawLine(75, 250, 150, 250);
                g2D.setStroke(new BasicStroke(2));
                g2D.setColor(Color.gray);
                g2D.drawLine(150, 250, 150, 300);
                g2D.setColor(Color.black);
                g2D.fillOval(137, 300, 25, 25);
                g2D.drawLine(150, 325, 150, 350);
                g2D.drawLine(150, 335, 165, 325);
                break;
            case 9:
                g2D.drawLine(50, 450, 75, 400);
                g2D.drawLine(100, 450, 75, 400);
                g2D.drawLine(75, 400, 75, 250);
                g2D.drawLine(75, 250, 150, 250);
                g2D.setStroke(new BasicStroke(2));
                g2D.setColor(Color.gray);
                g2D.drawLine(150, 250, 150, 300);
                g2D.setColor(Color.black);
                g2D.fillOval(137, 300, 25, 25);
                g2D.drawLine(150, 325, 150, 350);
                g2D.drawLine(150, 335, 165, 325);
                g2D.drawLine(150, 335, 135, 325);
                break;
            case 10:
                g2D.drawLine(50, 450, 75, 400);
                g2D.drawLine(100, 450, 75, 400);
                g2D.drawLine(75, 400, 75, 250);
                g2D.drawLine(75, 250, 150, 250);
                g2D.setStroke(new BasicStroke(2));
                g2D.setColor(Color.gray);
                g2D.drawLine(150, 250, 150, 300);
                g2D.setColor(Color.black);
                g2D.fillOval(137, 300, 25, 25);
                g2D.drawLine(150, 325, 150, 350);
                g2D.drawLine(150, 335, 165, 325);
                g2D.drawLine(150, 335, 135, 325);
                g2D.drawLine(150, 350, 165, 375);
                break;
            case 11:
                g2D.drawLine(50, 450, 75, 400);
                g2D.drawLine(100, 450, 75, 400);
                g2D.drawLine(75, 400, 75, 250);
                g2D.drawLine(75, 250, 150, 250);
                g2D.setStroke(new BasicStroke(2));
                g2D.setColor(Color.gray);
                g2D.drawLine(150, 250, 150, 300);
                g2D.setColor(Color.black);
                g2D.fillOval(137, 300, 25, 25);
                g2D.drawLine(150, 325, 150, 350);
                g2D.drawLine(150, 335, 165, 325);
                g2D.drawLine(150, 335, 135, 325);
                g2D.drawLine(150, 350, 165, 375);
                g2D.drawLine(150, 350, 135, 375);

                Object[] options = {"Exit", "Try again"};
                int result = JOptionPane.showOptionDialog(
                        null,
                        "Defeat",
                        "Try again!",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1] // domyślnie zaznaczona opcja
                );
                if (result == JOptionPane.YES_OPTION) {
                    System.out.println("Exit selected");
                    // Kod do zakończenia aplikacji
                    ClientReadThread.attempts = 0;
                    out.println("end");
                    dispose();
                    System.exit(0);
                } else if (result == JOptionPane.NO_OPTION) {
                    System.out.println("Try again selected");
                    // Uruchom nową grę
                    ClientReadThread.attempts = 0;
                    dispose();
                    new Game("easy", socket).setVisible(true);
                } else {
                    System.out.println("Cancelled");
                    // Obsługa anulowania (np. gdy użytkownik zamknie okno dialogowe bez wyboru)
                    ClientReadThread.attempts = 0;
                    out.println("end");
                    dispose();
                    System.exit(0);
                }
                break;

        }
        g2D.setStroke(oldStroke);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        out.println("end");
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

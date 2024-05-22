package HangManClient;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Game extends JFrame implements WindowListener {

    private PrintWriter out;
    private JPanel keyboardPanel;
    private PanelForWord panel1;
    static ArrayList<JLabel> labels;
    static String buttonText = "";
    static Game gameInstance;

    public Game() {
        gameInstance = this;
        labels = new ArrayList<>();

        try {
            out = new PrintWriter(HangMan.socket.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

        out.println("word");

        init();
    }

    private void init() {
        JPanel upperPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        keyboardPanel = new JPanel();
        panel1 = new PanelForWord();

        createKeyboard();
        createYellowLines();

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

        bottomPanel.add(keyboardPanel);
        upperPanel.add(panel1);

        addWindowListener(this);
        add(upperPanel);
        add(bottomPanel);

        ImageIcon hangManIcon = new ImageIcon("hangmanIcon.png");
        setIconImage(hangManIcon.getImage());
        setResizable(false);
        setTitle("HangMan Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createKeyboard() {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (char letter : alphabet) {
            JButton button = new JButton(String.valueOf(letter));
            button.setForeground(Color.yellow);
            button.setFont(new Font("MV Boli", Font.PLAIN, 18));
            button.setBackground(new Color(21, 194, 82));
            button.setBorder(BorderFactory.createLineBorder(Color.yellow, 2, true));
            button.setPreferredSize(new Dimension(35, 35));
            button.setFocusable(false);

            keyboardPanel.add(button);

            button.addActionListener(e -> {
                JButton clickedButton = (JButton) e.getSource();
                buttonText = clickedButton.getText();
                System.out.println("Kliknięto przycisk: " + buttonText);
                out.println(buttonText);
                clickedButton.setEnabled(false);
            });
        }
    }

    private void createYellowLines() {
        int j = 0;
        for (int i = 0; i < 10; i++) {
            JLabel laberForLetter = new JLabel("");
            laberForLetter.setForeground(Color.yellow);
            laberForLetter.setFont(new Font("MV Boli", Font.PLAIN, 18));
            laberForLetter.setBounds(17 + j, 25, 50, 20);
            labels.add(laberForLetter);
            j += 45;
            panel1.add(laberForLetter);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        Stroke oldStroke = g2D.getStroke();
        g2D.setStroke(new BasicStroke(12));
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
                showWinMessage(false);
                break;

        }
        g2D.setStroke(oldStroke);
    }

    void showWinMessage(boolean isWon) {
        Object[] options = {"Exit", "Try again", "Save in history of games"};
        int result = JOptionPane.showOptionDialog(
                this,
                (isWon == true ? "Congratulations! You won" : "Defeat"),
                (isWon == true ? "Win" : "Try again"),
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[1] // default option
        );
        
        if (result == JOptionPane.YES_OPTION) { // when user clicks Exit
            out.println("end");
            dispose();
            System.exit(0);

        } 
        else if (result == JOptionPane.NO_OPTION) { // when user clicks Try again
            dispose();
            ClientReadThread.attempts = 0;
            new Game().setVisible(true);

        }
        else if (result == JOptionPane.CANCEL_OPTION) {  // when user clicks save in history
            saveGameInHistory(isWon);
            dispose();
            ClientReadThread.attempts = 0;
            new HangMan();

        } 
        else { // When user cancel without choice
            System.out.println("Cancelled");
            out.println("end");
            dispose();
            System.exit(0);
            
        }
    }

    private void saveGameInHistory(boolean isWon) {
        File file = new File("History.txt");
        BufferedWriter outToFile;

        try {
            outToFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));

            outToFile.write(ClientReadThread.word);
            outToFile.newLine();
            if (isWon) {
                outToFile.write("Win");
            } else {
                outToFile.write("Defeat");
            }
            
            outToFile.newLine();
            outToFile.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
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

}

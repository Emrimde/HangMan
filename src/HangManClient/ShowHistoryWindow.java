package HangManClient;

import static HangManClient.HangMan.out;
import static HangManClient.HangMan.socket;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ShowHistoryWindow extends JFrame implements WindowListener, ActionListener {

    private JButton returnButton;
    private Socket socket;
    private PrintWriter out;
    JPanel middlePanel;

    public ShowHistoryWindow(Socket socket) {
        ImageIcon hangManIcon = new ImageIcon("hangmanIcon.png");
        setIconImage(hangManIcon.getImage());
        this.socket = socket;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(HangMan.class.getName()).log(Level.SEVERE, null, ex);
        }
        init();
        setTitle("HangMan Game");
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void init() {

        JPanel upperPanel = new JPanel();
        middlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        returnButton = new JButton("Return");

        JLabel label = new JLabel("History");

        returnButton.setForeground(Color.yellow);
        returnButton.setFont(HangMan.mvBoli);
        returnButton.setBackground(new Color(24, 179, 240));
        returnButton.setBorder(BorderFactory.createLineBorder(Color.yellow, 2, true));
        returnButton.setPreferredSize(new Dimension(150, 50));
        returnButton.setFocusable(false);

        label.setFont(HangMan.mvBoli);
        label.setForeground(Color.yellow);
        

        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        upperPanel.setBackground(new Color(24, 179, 240));
        upperPanel.setPreferredSize(new Dimension(700, 100));
        upperPanel.add(label);
        middlePanel.setBackground(new Color(24, 179, 240));
        middlePanel.setPreferredSize(new Dimension(700, 500));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        bottomPanel.setBackground(new Color(24, 179, 240));
        bottomPanel.setPreferredSize(new Dimension(700, 100));
        bottomPanel.add(returnButton);
        
        addWindowListener(this);
        returnButton.addActionListener(this);
        loadHistory();
        
        add(upperPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

    }

    
       private void loadHistory() {
        try (BufferedReader br = new BufferedReader(new FileReader("History.txt"))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                
                String keyword = line;
                String result = br.readLine();
                if (result != null) {
                    JLabel gameLabel = new JLabel(++i + ". "+ "Keyword: " + keyword + " - Result: " + result);
                    gameLabel.setFont(new Font("MV Boli", Font.PLAIN, 22));
                    gameLabel.setForeground(Color.yellow);
                    gameLabel.setAlignmentX(CENTER_ALIGNMENT);
                    middlePanel.add(gameLabel);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        new HangMan();
        
    }
}

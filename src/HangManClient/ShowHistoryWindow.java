package HangManClient;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;

public class ShowHistoryWindow extends JFrame implements WindowListener, ActionListener {

    private JButton returnButton;
    private PrintWriter out;
    private JPanel middlePanel;

    public ShowHistoryWindow() {
        
       
        ImageIcon hangManIcon = new ImageIcon("hangmanIcon.png");
        setIconImage(hangManIcon.getImage());
        
        try {
            out = new PrintWriter(HangMan.socket.getOutputStream(), true);
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
        JScrollPane scrollPane = new JScrollPane(middlePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
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
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS)); // Ustawienie BoxLayout dla middlePanel
        
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        bottomPanel.setBackground(new Color(24, 179, 240));
        bottomPanel.setPreferredSize(new Dimension(700, 100));
        bottomPanel.add(returnButton);
        
        addWindowListener(this);
        returnButton.addActionListener(this);
        
        add(upperPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER); // Dodanie JScrollPane, a nie middlePanel
        add(bottomPanel, BorderLayout.SOUTH);

        loadHistory();
    }

    private void loadHistory() {
        try (BufferedReader br = new BufferedReader(new FileReader("History.txt"))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String keyword = line;
                String result = br.readLine();
                if (result != null) {
                    JLabel gameLabel = new JLabel(++i + ". " + "Keyword: " + keyword + " - Result: " + result);
                    gameLabel.setFont(new Font("MV Boli", Font.PLAIN, 22));
                    gameLabel.setForeground(Color.yellow);
                    gameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    middlePanel.add(gameLabel);
                }
            }
            middlePanel.revalidate(); // Odświeżenie panelu po dodaniu wszystkich etykiet
            middlePanel.repaint();
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

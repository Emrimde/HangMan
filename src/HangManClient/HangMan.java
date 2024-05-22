package HangManClient;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class HangMan extends JFrame implements ActionListener, WindowListener {
    private JButton startButton;
    private JButton showHistoryButton;
    public static Font mvBoli = new Font("MV Boli", Font.BOLD, 35);
    static int port = 6910;
    static String address = "127.0.0.1";
    static PrintWriter out = null;
    static Socket socket = null;

    public HangMan() {
        init();
        addWindowListener(this);
        setTitle("HangMan Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        ImageIcon hangManIcon = new ImageIcon("hangmanIcon.png");
        setIconImage(hangManIcon.getImage());
        ImageIcon cloud1 = new ImageIcon("cloud1.png");
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        showHistoryButton = new JButton("Show history");
        showHistoryButton.addActionListener(this);
        JPanel subPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel upperPanel = new JPanel();

        JLabel header = new JLabel("HangMan");
        JLabel cloudLabel1 = new JLabel();
        JLabel cloudLabel2 = new JLabel();
        
        startButton.setFont(mvBoli);
        startButton.setFocusable(false);
        startButton.setBackground(new Color(21, 194, 82));
        startButton.setForeground(Color.yellow);
        startButton.setBorder(BorderFactory.createLineBorder(Color.yellow, 5, true));

        showHistoryButton.setFont(mvBoli);
        showHistoryButton.setFocusable(false);
        showHistoryButton.setBackground(new Color(21, 194, 82));
        showHistoryButton.setForeground(Color.yellow);
        showHistoryButton.setBorder(BorderFactory.createLineBorder(Color.yellow, 5, true));

        cloudLabel1.setIcon(cloud1);
        cloudLabel2.setIcon(cloud1);

        header.setFont(mvBoli);
        header.setForeground(new Color(247, 240, 15));

        subPanel.setPreferredSize(new Dimension(300, 140));
        subPanel.setLayout(new BorderLayout(0, 20));
        subPanel.add(startButton, BorderLayout.CENTER);
        subPanel.add(showHistoryButton, BorderLayout.SOUTH);
        subPanel.setBackground(new Color(21, 194, 82));

        bottomPanel.setBackground(new Color(21, 194, 82));
        bottomPanel.setPreferredSize(new Dimension(500, 200));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        bottomPanel.add(subPanel);
        add(bottomPanel, BorderLayout.SOUTH);

        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 50));
        upperPanel.setPreferredSize(new Dimension(500, 300));
        upperPanel.setBackground(new Color(24, 179, 240));
        upperPanel.add(cloudLabel1);
        upperPanel.add(header);
        upperPanel.add(cloudLabel2);
        add(upperPanel, BorderLayout.NORTH);
    }

    public void connectWithServer() {
        try {
            socket = new Socket(address, port);
        } catch (IOException ex) {
            Logger.getLogger(HangMan.class.getName()).log(Level.SEVERE, null, ex);
        }

        ClientReadThread readMessages = new ClientReadThread(socket);
        readMessages.start();

        try {
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(HangMan.class.getName()).log(Level.SEVERE, null, ex);
        }

        out.println("Connection has begun!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            new Game();
            dispose();
        } 
        if (e.getSource() == showHistoryButton) {
            dispose();
            new ShowHistoryWindow();
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

package HangManClient;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.*;

public class HangMan extends JFrame implements ActionListener{
    
    private JButton startButton;
    public static Font mvBoli = new Font("MV Boli", Font.BOLD,35); ;
    
    public HangMan() {
        ImageIcon cloud1 = new ImageIcon("cloud1.png");
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        JPanel subPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel upperPanel = new JPanel();
         
        startButton.setFont(mvBoli);
        startButton.setFocusable(false);
        startButton.setBackground(new Color(21, 194, 82));
        startButton.setForeground(Color.yellow);
        startButton.setBorder(BorderFactory.createLineBorder(Color.yellow, 5, true));
        
        JLabel label = new JLabel("HangMan");
        JLabel cloudLabel1 = new JLabel();
        cloudLabel1.setIcon(cloud1);
        JLabel cloudLabel2 = new JLabel();
        cloudLabel2.setIcon(cloud1);
        label.setFont(mvBoli);
        label.setForeground(new Color(247, 240, 15));
        
        subPanel.setPreferredSize(new Dimension(200,50));
        subPanel.setLayout(new BorderLayout());
        subPanel.add(startButton, BorderLayout.CENTER);
       
        bottomPanel.setBackground(new Color(21, 194, 82));
        bottomPanel.setPreferredSize(new Dimension(500,200));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,30));
        bottomPanel.add(subPanel);
        add(bottomPanel,BorderLayout.SOUTH);
        
        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,50));
        upperPanel.setPreferredSize(new Dimension(500,300));
        upperPanel.setBackground(new Color(24, 179, 240));
        upperPanel.add(cloudLabel1);
        upperPanel.add(label);
        upperPanel.add(cloudLabel2);
        add(upperPanel, BorderLayout.NORTH);
        
        setTitle("HangMan Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public void connectWithServer() {
        int port = 6899;
        String adress = "127.0.0.1";
        Socket socket = null;

        try {
            System.out.println("I'm connecting to the server");
            socket = new Socket(adress, port);
        } catch (IOException e) {
            System.out.println("I can't connect to the server");
        }

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String info = in.readLine();
            System.out.println("I got from server: " + info);
            socket.close();
            in.close();

        } catch (IOException e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            dispose();
            new SetLevelWindow();
        }
    }


}

package HangManClient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class SetLevelWindow extends JFrame implements ActionListener, WindowListener {
   
    
    private JButton easyButton = new JButton("Easy");
    private JButton mediumButton = new JButton("Medium");
    private JButton hardButton = new JButton("Hard");
    private PrintWriter out;
    private Socket socket;
    public SetLevelWindow(Socket socket) {
        
        this.socket = socket;
        
        try {
            out = new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException ex) {
            Logger.getLogger(SetLevelWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        JPanel upperPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JLabel selectLabel = new JLabel("Select Level");

        selectLabel.setFont(HangMan.mvBoli);
        selectLabel.setForeground(Color.yellow);

        easyButton.setFont(HangMan.mvBoli);
        easyButton.setFocusable(false);
        easyButton.setBackground(new Color(24, 179, 240));
        easyButton.setForeground(Color.yellow);
        easyButton.setBorder(BorderFactory.createLineBorder(Color.yellow, 5, true));

        mediumButton.setFont(HangMan.mvBoli);
        mediumButton.setFocusable(false);
        mediumButton.setBackground(new Color(24, 179, 240));
        mediumButton.setForeground(Color.yellow);
        mediumButton.setBorder(BorderFactory.createLineBorder(Color.yellow, 5, true));

        hardButton.setFont(HangMan.mvBoli);
        hardButton.setFocusable(false);
        hardButton.setBackground(new Color(24, 179, 240));
        hardButton.setForeground(Color.yellow);
        hardButton.setBorder(BorderFactory.createLineBorder(Color.yellow, 5, true));

        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));

        upperPanel.setPreferredSize(new Dimension(500, 50));
        upperPanel.setBackground(new Color(24, 179, 240));
        upperPanel.add(selectLabel);

        bottomPanel.setPreferredSize(new Dimension(150, 450));
        bottomPanel.setBackground(new Color(24, 179, 240));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        bottomPanel.add(easyButton);
        bottomPanel.add(mediumButton);
        bottomPanel.add(hardButton);
        
        easyButton.addActionListener(this);
        mediumButton.addActionListener(this);
        hardButton.addActionListener(this);
        
        add(upperPanel);
        add(bottomPanel);
        addWindowListener(this);
        setTitle("HangMan Game");
        setSize(500, 500);
        getContentPane().setBackground(new Color(24, 179, 240));
        setLocationRelativeTo(null);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == easyButton) {
            System.out.println("Time set to 2 minutes");
            new Game("easy",socket);
            dispose();
            
            //There will be new window
        }
        else if (e.getSource() == mediumButton) {
            System.out.println("Time set to 1:30 minutes");
              new Game("medium",socket);
            dispose();
            
        }
        else if (e.getSource() == hardButton) {
            System.out.println("Time set to 1 minutes");
            new Game("hard",socket);
            dispose();
            
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

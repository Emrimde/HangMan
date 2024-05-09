package HangManClient;

import java.awt.*;
import javax.swing.*;

public class Game extends JFrame {

    private String level;

    public Game(String level) {
        this.level = level;
        
        JPanel upperPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
       
        JPanel mainBannedPanel = new JPanel();
        JPanel bannedPanel1 = new JPanel();
        JPanel bannedPanel2 = new JPanel();
        
        JLabel bannedHeader = new JLabel("Banned letters");
        JLabel bannedLetters1 = new JLabel("a,b,c,d,e,f,g,h,i,j,k");
        JLabel bannedLetters2 = new JLabel("a,b,c,d,e,f,g,h,i,j,k");
        JLabel timeLabel = new JLabel("Time 2:00");
        
        JTextField letterField = new JTextField();
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        upperPanel.setLayout(null);
        upperPanel.setPreferredSize(new Dimension(500, 300));
        upperPanel.setBackground(new Color(24, 179, 240));
        
        bottomPanel.setBackground(new Color(21, 194, 82));
        bottomPanel.setPreferredSize(new Dimension(500, 200));
        
        mainBannedPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        mainBannedPanel.setBounds(0,0,150,200);
        mainBannedPanel.setBackground(new Color(24, 179, 240));
        
        bannedPanel1.setPreferredSize(new Dimension(200,30));
        bannedPanel1.setBackground(new Color(24, 179, 240));
        
        bannedPanel2.setPreferredSize(new Dimension(200,30));
        bannedPanel2.setBackground(new Color(24, 179, 240));
        
        bannedHeader.setForeground(Color.yellow);
        bannedHeader.setFont(new Font("MV Boli",Font.PLAIN,18));
        mainBannedPanel.add(bannedHeader);
         
        bannedLetters1.setForeground(Color.yellow);
        bannedLetters1.setFont(new Font(null,Font.PLAIN,15));
        bannedPanel1.add(bannedLetters1);
        
        bannedLetters2.setForeground(Color.yellow);
        bannedLetters2.setFont(new Font(null,Font.PLAIN,15));
        bannedPanel2.add(bannedLetters2);
        
        letterField.setBounds(217,100,75,50);
        letterField.setBorder(BorderFactory.createLineBorder(Color.yellow, 5, true));
        letterField.setFont(HangMan.mvBoli);
        letterField.setForeground(Color.yellow);
        letterField.setBackground(new Color(24, 179, 240));
        letterField.setCaretColor(Color.red);
        letterField.setHorizontalAlignment(JTextField.CENTER);
        
        timeLabel.setBounds(400,0,100,40);
        timeLabel.setForeground(Color.yellow);
        timeLabel.setFont(new Font(null,Font.PLAIN,20));
        
        mainBannedPanel.add(bannedPanel1);
        mainBannedPanel.add(bannedPanel2);
        
        upperPanel.add(mainBannedPanel);
        upperPanel.add(letterField);
        upperPanel.add(timeLabel);
        
        
        add(upperPanel);
        add(bottomPanel);

        setTitle("HangMan Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        Stroke oldStroke = g2D.getStroke(); // Zapamiętaj stary Stroke
        g2D.setStroke(new BasicStroke(10)); // Ustaw nowy Stroke o grubości 3 piksele
        g2D.setColor(new Color(133, 82, 12));
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
        
        //hands
        g2D.drawLine(150, 335, 165, 325);
        g2D.drawLine(150, 335, 135, 325);
        
        // legs
        g2D.drawLine(150, 350, 165, 375);
        g2D.drawLine(150, 350, 135, 375);
       
        
        
        
    }

    

    
    
    
}

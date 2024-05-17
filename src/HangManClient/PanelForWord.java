package HangManClient;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelForWord extends JPanel {

    public PanelForWord() {

        setLayout(new FlowLayout());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = this.getHeight() / 2;
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.yellow);
        g2D.setStroke(new BasicStroke(5));
        int x = 0;
        int x2 = 0;

        int dlugoscLinii = 25; // Długość linii
        int przerwa = 20; // Szerokość przerwy między liniami

        for (int i = 0; i < ClientReadThread.lengthOfWord; i++) {
            g2D.drawLine(x + 10, this.getHeight() / 2, x + dlugoscLinii + 10, this.getHeight() / 2);
            x += dlugoscLinii + przerwa; // Dodaj szerokość linii i przerwy
        }

        
    }

}

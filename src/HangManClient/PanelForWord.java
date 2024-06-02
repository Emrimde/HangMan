package HangManClient;

import java.awt.*;
import javax.swing.JPanel;

public class PanelForWord extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.yellow);
        g2D.setStroke(new BasicStroke(5));
        int x = 0;
        int lineLength = 25; // The length of line 
        int breakBetweenLines = 20; // The width of break between lines

        for (int i = 0; i < ClientReadThread.lengthOfWord; i++) {
            g2D.drawLine(x + 10, this.getHeight() / 2, x + lineLength + 10, this.getHeight() / 2);
            x += lineLength + breakBetweenLines; // Dodaj szerokość linii i przerwy
        }
    }
}

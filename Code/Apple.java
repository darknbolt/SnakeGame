package Code;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Apple extends JPanel{
    public int x, y;
    private Graphics g;
    public Apple(){
        this.x = (int)(Math.random()*481);
        this.y = (int)(Math.random()*481);
    }
    public void paintComponent() {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(x, y, 10, 10);
    }
}

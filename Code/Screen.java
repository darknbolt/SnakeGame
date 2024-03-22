package Code;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Screen extends Frame{
    public static void main(String[] args) {new Screen();}
    public GameOBJ[] arr;
    private int figureCount;
    public Screen(){
        this.setSize(500, 500);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        arr = new GameOBJ[1000];

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                arr[figureCount++] = getObj();
                repaint();
            }
        });
        repaint();
    }
    public GameOBJ getObj(){
        return new Apple();
    }
    public void paint(Graphics g){
        for(int i = 0; i < arr.length; ++i){
            arr[i].draw(g);
        }
    }
}

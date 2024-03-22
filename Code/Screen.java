package Code;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Screen extends Frame{
    final int unit;
    public static void main(String[] args) {new Screen();}
    public Screen(){
        //Screen Setup
        this.setSize(500, 500);
        unit = (500*500)/10;
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public GameOBJ getObj(){
        return new Apple();
    }
    public GameOBJ getObjSnake(){
        return new Snake(unit);
    }
    public void paint(Graphics g){
        g.setColor(Color.RED);
        getObj().draw(g);
        getObjSnake().draw(g);
    }
}

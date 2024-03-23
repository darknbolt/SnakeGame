package Code;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;

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
        Timer test = new Timer(75, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public GameOBJ getObj(){
        return new Apple();
    }
    public GameOBJ Move(Snake snake){
        char direction = 'w';
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyChar() == 'a'){

                }
            }
        });
        return snake;
    }
    public Snake getObjSnake(){
        return new Snake(unit);
    }
    public void paint(Graphics g){
        g.setColor(Color.RED);
        getObj().draw(g);
        Snake mySnake = getObjSnake();
        mySnake.draw(g);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyChar() == 'w'){
                    mySnake.up();
                    repaint();
                }
            }
        });
    }
}

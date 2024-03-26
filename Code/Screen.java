package Code;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Screen extends Frame{
    final int unit;
    Snake mySnake;
    Apple myApple;
    Timer myTimer;
    KeyListener myButtonListener;
    public static void main(String[] args) {new Screen();}
    public Screen(){
        //Game Objects Setup
        unit = (500*500)/10;
        mySnake = new Snake(unit);
        myApple = new Apple();

        //Screen Setup
        this.setTitle("Snake Game");
        this.setSize(500, 500);
        this.setResizable(false);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //Timer Setup
        myTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(mySnake.getDirection()){
                    case "Left":
                        mySnake.left();
                        break;
                    case "Right":
                        mySnake.right();
                        break;
                    case "Up":
                        mySnake.up();
                        break;
                    case "Down":
                        mySnake.down();
                        break;
                }
                isThereAppleCollision();
                mySnake.checkDeath();
                repaint();
            }
        });

        //Button Setup
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                mySnake.setDirection(e.getKeyChar());
            }
        });
    }
    public void isThereAppleCollision(){
        if (myApple.x == mySnake.getX() && myApple.y == mySnake.getY()){
            mySnake.addBodyNumber();
            myApple = new Apple();
        }
    }
    public void paint(Graphics g){
        g.setColor(Color.RED);
        myApple.draw(g);
        mySnake.draw(g);
        myTimer.start();
    }
}

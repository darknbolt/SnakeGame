package Code;
import java.awt.*;
import java.awt.event.*;

public class Screen extends Frame{
    final int unit;
    Snake mySnake;
    Apple myApple;
    public static void main(String[] args) {new Screen();}
    public Screen(){
        unit = (500*500)/10;
        mySnake = new Snake(unit);
        myApple = new Apple();

        //Screen Setup
        this.setSize(500, 500);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g){
        g.setColor(Color.RED);
        myApple.draw(g);
        mySnake.draw(g);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyChar()){
                    case 'a':
                        mySnake.left();
                        System.out.println("Left: " + mySnake.getXCoordinates());
                        repaint();
                        break;
                    case 's':
                        mySnake.down();
                        System.out.println("Down: " + mySnake.getYCoordinates());
                        repaint();
                        break;
                    case 'w':
                        mySnake.up();
                        System.out.println("Up: " + mySnake.getYCoordinates());
                        repaint();
                        break;
                    case 'd':
                        mySnake.right();
                        System.out.println("Right: " + mySnake.getXCoordinates());
                        repaint();
                        break;
                }
            }
        });
    }
}

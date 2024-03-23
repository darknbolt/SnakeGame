package Code;
import java.awt.*;
import java.util.Arrays;

public class Snake extends GameOBJ{
    public int bodyNumber;
    public int maxBodyNumber;
    public int[] body_X_Coordinates, body_Y_Coordinates;
    public Snake(int maxBodyNumber){
        super(); bodyNumber = 6;
        this.maxBodyNumber = maxBodyNumber;
        body_X_Coordinates = new int[maxBodyNumber];
        body_Y_Coordinates = new int[maxBodyNumber];
        for(int i = 0, adder = 210; i < bodyNumber; ++i, adder += 10){
            body_X_Coordinates[i] = adder;
            body_Y_Coordinates[i] = 210;
        }
    }
    public int getBody(){
        return bodyNumber;
    }
    public void draw(Graphics g){
        for(int i = 0; i < bodyNumber; ++i){
            if(i == 0){
                g.setColor(Color.WHITE);
            }else{
                g.setColor(Color.YELLOW);
            }
            g.drawRect(body_X_Coordinates[i], body_Y_Coordinates[i], 10, 10);
        }
    }
    public String getXCoordinates(){
        String cdr = "";
        for(int i = 0; i < bodyNumber; ++i){
            cdr += body_X_Coordinates[i] + " ";
        }
        return cdr;
    }
    public String getYCoordinates(){
        String cdr = "";
        for(int i = 0; i < bodyNumber; ++i){
            cdr += body_Y_Coordinates[i] + " ";
        }
        return cdr;
    }
    public void up(){
        for(int i = 0; i < bodyNumber; ++i){
            body_Y_Coordinates[i] -= 10;
        }
    }
    public void down(){
        for(int i = 0; i < bodyNumber; ++i){
            body_Y_Coordinates[i] += 10;
        }
    }
    public void left(){
        for(int i = 0; i < bodyNumber; ++i){
            body_X_Coordinates[i] -= 10;
        }
    }
    public void right(){
        for(int i = 0; i < bodyNumber; ++i){
            body_X_Coordinates[i] += 10;
        }
    }
}
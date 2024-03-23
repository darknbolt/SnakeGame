package Code;
import java.awt.*;
import java.util.Arrays;

public class Snake extends GameOBJ{
    public int bodyNumber;
    public int maxBodyNumber;
    public int[] body_X_Coordinates, body_Y_Coordinates;
    public String direction;
    public Snake(int maxBodyNumber){
        super(); bodyNumber = 6;
        this.maxBodyNumber = maxBodyNumber;
        body_X_Coordinates = new int[maxBodyNumber];
        body_Y_Coordinates = new int[maxBodyNumber];
        for(int i = 0, adder = 210; i < bodyNumber; ++i, adder += 10){
            body_X_Coordinates[i] = adder;
            body_Y_Coordinates[i] = 210;
        }
        direction = "Left";
    }
    public String getDirection(){
        return direction;
    }
    public void setDirection(char button){
        if(button == 'a'){
            direction = "Left";
        }else if(button == 's'){
            direction = "Down";
        }else if(button == 'd'){
            direction = "Right";
        }else if(button == 'w'){
            direction = "Up";
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
        if(body_Y_Coordinates[0] == 30){
            return;
        }
        if(body_X_Coordinates[0] == body_X_Coordinates[bodyNumber-1] && body_Y_Coordinates[0] > body_Y_Coordinates[bodyNumber-1]){
            return;
        }
        for(int i = 0; i < bodyNumber; ++i){
            if(i == 0 || body_X_Coordinates[0] == body_X_Coordinates[i]) {
                body_Y_Coordinates[i] -= 10;
            }
            if(i != 0 && body_X_Coordinates[0] < body_X_Coordinates[i]){
                body_X_Coordinates[i] -= 10;
            }else if(i != 0 && body_X_Coordinates[0] > body_X_Coordinates[i]){
                body_X_Coordinates[i] += 10;
            }
        }
    }
    public void down(){
        if(body_Y_Coordinates[0] == 480){
            return;
        }
        if(body_X_Coordinates[0] == body_X_Coordinates[bodyNumber-1] && body_Y_Coordinates[0] < body_Y_Coordinates[bodyNumber-1]){
            return;
        }
        for(int i = 0; i < bodyNumber; ++i){
            if(i == 0 || body_X_Coordinates[0] == body_X_Coordinates[i]) {
                body_Y_Coordinates[i] += 10;
            }
            if(i != 0 && body_X_Coordinates[0] < body_X_Coordinates[i]){
                body_X_Coordinates[i] -= 10;
            }else if(i != 0 && body_X_Coordinates[0] > body_X_Coordinates[i]){
                body_X_Coordinates[i] += 10;
            }
        }
    }
    public void left(){
        if(body_X_Coordinates[0] == 10){
            return;
        }
        if(body_Y_Coordinates[0] == body_Y_Coordinates[bodyNumber-1] && body_X_Coordinates[0] > body_X_Coordinates[bodyNumber-1]){
            return;
        }
        for(int i = 0; i < bodyNumber; ++i){
            if(i == 0 || body_Y_Coordinates[0] == body_Y_Coordinates[i]) {
                body_X_Coordinates[i] -= 10;
            }
            if(i != 0 && body_Y_Coordinates[0] < body_Y_Coordinates[i]){
                body_Y_Coordinates[i] -= 10;
            }else if(i != 0 && body_Y_Coordinates[0] > body_Y_Coordinates[i]){
                body_Y_Coordinates[i] += 10;
            }
        }
    }
    public void right(){
        if(body_X_Coordinates[0] == 480){
            return;
        }
        if(body_Y_Coordinates[0] == body_Y_Coordinates[bodyNumber-1] && body_X_Coordinates[0] < body_X_Coordinates[bodyNumber-1]){
            return;
        }
        for(int i = 0; i < bodyNumber; ++i){
            if(i == 0 || body_Y_Coordinates[i-1] == body_Y_Coordinates[i]) {
                body_X_Coordinates[i] += 10;
            }
            if(i != 0 && body_Y_Coordinates[0] < body_Y_Coordinates[i]){
                body_Y_Coordinates[i] -= 10;
            }else if(i != 0 && body_Y_Coordinates[0] > body_Y_Coordinates[i]){
                body_Y_Coordinates[i] += 10;
            }
        }
    }
}
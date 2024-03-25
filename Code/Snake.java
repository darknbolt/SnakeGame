package Code;
import java.awt.*;
import java.util.Arrays;

public class Snake extends GameOBJ{
    private int bodyNumber;
    public int maxBodyNumber;
    private int[] body_X_Coordinates, body_Y_Coordinates;
    public String direction, previousDirection;
    public Snake(int maxBodyNumber){
        super(); bodyNumber = 6;
        this.maxBodyNumber = maxBodyNumber;
        previousDirection = " ";
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
    public void addBodyNumber(){
        bodyNumber += 1;
        body_X_Coordinates[bodyNumber-1] = body_X_Coordinates[bodyNumber-3] > body_X_Coordinates[bodyNumber-2] ? body_X_Coordinates[bodyNumber-3] + 10 : body_X_Coordinates[bodyNumber-2] - 10;
        body_Y_Coordinates[bodyNumber-1] = body_Y_Coordinates[bodyNumber-3] > body_Y_Coordinates[bodyNumber-2] ? body_Y_Coordinates[bodyNumber-3] - 10 : body_Y_Coordinates[bodyNumber-2] + 10;
    }
    public void setDirection(char button){
        if(button == 'a'){
            previousDirection = direction;
            direction = "Left";
        }else if(button == 's'){
            previousDirection = direction;
            direction = "Down";
        }else if(button == 'd'){
            previousDirection = direction;
            direction = "Right";
        }else if(button == 'w'){
            previousDirection = direction;
            direction = "Up";
        }
    }
    public int getBodyNumber(){
        return bodyNumber;
    }
    public int getX(){
        return body_X_Coordinates[0];
    }
    public int getY(){
        return body_Y_Coordinates[0];
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
    public void checkDeath(){
        if((body_X_Coordinates[0] == 0 || body_X_Coordinates[0] == 490 ||
                (body_Y_Coordinates[0] == 20 || body_Y_Coordinates[0] == 490))){
            bodyNumber = 3;
            body_X_Coordinates[0] = 200;
            body_Y_Coordinates[0] = 200;
            direction = "Left";
        }
    }
    public void up(){
        if(body_Y_Coordinates[0] == 10){
            return;
        }
        if(previousDirection.equals("Down")){
            this.down();
            return;
        }
        for(int i = bodyNumber; i >= 0; --i){
            if(i == 0) {
                body_Y_Coordinates[i] -= 10;
            }else {
                body_Y_Coordinates[i] = body_Y_Coordinates[i - 1];
                body_X_Coordinates[i] = body_X_Coordinates[i - 1];
            }
        }
    }
    public void down(){
        if(body_Y_Coordinates[0] == 500){
            return;
        }
        if(previousDirection.equals("Up")){
            this.up();
            return;
        }
        for(int i = bodyNumber; i >= 0; --i){
            if(i == 0) {
                body_Y_Coordinates[i] += 10;
            }else{
                body_Y_Coordinates[i] = body_Y_Coordinates[i-1];
                body_X_Coordinates[i] = body_X_Coordinates[i-1];
            }
        }
    }
    public void left(){
        if(body_X_Coordinates[0] == -10){
            return;
        }
        if(previousDirection.equals("Right")){
            this.right();
            return;
        }
        for(int i = bodyNumber; i >= 0; --i){
            if(i == 0) {
                body_X_Coordinates[i] -= 10;
            }else{
                body_X_Coordinates[i] = body_X_Coordinates[i-1];
                body_Y_Coordinates[i] = body_Y_Coordinates[i-1];
            }
        }
    }
    public void right(){
        if(body_X_Coordinates[0] == 500){
            return;
        }
        if(previousDirection.equals("Left")){
            this.left();
            return;
        }
        for(int i = bodyNumber; i >= 0; --i){
            if(i == 0) {
                body_X_Coordinates[i] += 10;
            }else{
                body_Y_Coordinates[i] = body_Y_Coordinates[i-1];
                body_X_Coordinates[i] = body_X_Coordinates[i-1];
            }
        }
    }
}
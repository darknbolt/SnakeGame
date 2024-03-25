package Code;
import java.awt.*;
public abstract class GameOBJ{
    protected int x, y;
    protected Color color;
    public GameOBJ(){
        this.x = 10 + (10 * (int)(Math.random()*47));
        this.y = 30 + (10 * (int)(Math.random()*46));
        this.color = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
    }
    public abstract void draw (Graphics g);
}

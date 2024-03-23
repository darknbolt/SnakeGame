package Code;
import java.awt.*;
public abstract class GameOBJ{
    protected int x, y;
    protected Color color;
    public GameOBJ(){
        this.x = (int)((Math.random()*470)+10);
        this.y = (int)((Math.random()*460)+30);
        this.color = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
    }
    public abstract void draw (Graphics g);
}

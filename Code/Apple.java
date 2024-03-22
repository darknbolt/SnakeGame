package Code;

import java.awt.*;

public class Apple extends GameOBJ{
    public Apple(){
        super();
    }
    @Override
    public void draw(Graphics g) {
        g.fillRect(x, y, 10, 10);
        g.setColor(Color.RED);
    }
}

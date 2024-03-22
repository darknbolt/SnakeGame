package Code;
import javax.swing.*;

public class Screen{
    private JFrame mainFrame;
    private JPanel mainPanel;
    public Screen(){
        mainFrame = new JFrame("Snake Game");
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        Apple myApple = new Apple();
        myApple.paintComponent();
        mainFrame.add(myApple);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

}

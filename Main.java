

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame{

    public static boolean gamestarted = false;
    public static void main(String[] args) {
        Gamepanel gamepanel = new Gamepanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Flappy Birb");
        frame.setResizable(false);
        frame.setLocation(300,200);
        frame.add(gamepanel.button);
        frame.add(gamepanel);
        frame.pack();
        frame.setVisible(true);
    }

}
import javax.swing.JFrame;

public class Main extends JFrame{

    
    public static void main(String[] args) {
        Gamepanel gamepanel = new Gamepanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Flappy Birb");
        frame.setResizable(false);
        frame.setLocation(gamepanel.Screen_Width*gamepanel.scale/3,gamepanel.Screen_Height*gamepanel.scale/5 );
        frame.add(gamepanel);
        frame.pack();
        frame.setVisible(true);
    }
}
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import javax.xml.crypto.dsig.Transform;
public class Gamepanel extends JPanel implements Runnable, ActionListener{
    
    public double player_X = -100;
    public double player_Y = 50;
    public double player_Width = 70;
    public double player_Height = 35;
    public double player_velocity = 0;
    public Thread gameThread;
    public boolean started = false;
    public double radians;;
    public Keys keys;
    public Image img;
    Color playercolor;
    JButton button;
    Gamepanel(){
         
        keys = new Keys();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(900,600));
        this.setFocusable(true);
        this.addKeyListener(keys);
        button = new JButton();
        button.setBounds(430,270,60,60);
        button.setText("start");
        button.setVisible(true);
        button.setOpaque(true);
        button.setBackground(Color.BLUE);
        button.addActionListener(this);
        this.add(button);
    }
    public void Gamethread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public double GetPlayerX(){
        return player_X;
    }
    public double GetPlayerY(){
        return player_Y;
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        img = new ImageIcon("Flappybirb.png").getImage();
        g2d.drawImage(img,(int)player_X,(int)player_Y, null);
        g2d.rotate(Math.toRadians(45), 0, 0);
    }

    public void update(){

        if (keys.uppclick) {
            player_velocity = -8;
        } else {}
        if (player_Y>=600 - player_Height) {
            player_Y = 600-player_Height;
            player_velocity = 0;
            
        } else{
            player_Y += player_velocity;
            player_velocity += 0.500;
        }
        radians += Math.toRadians(-6);

    }

    @Override
    public void run() {
        while (gameThread != null) {
            update();
            repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
        }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == button){
            Gamethread();
            button.setVisible(false);
            player_X = 75;

        }

    }
}

import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
public class Gamepanel extends JPanel implements Runnable{
    
    final int Screen_Width = 320;
    final int Screen_Height = 200;
    final int scale = 3;
    public double player_X;
    public double player_Y;
    public double player_Width = 75;
    public double player_Height = 30;
    public Rectangle2D.Double player = new Rectangle2D.Double(player_X,player_Y,player_Width,player_Height);

    Gamepanel(){
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(Screen_Width*scale, Screen_Height*scale));
        //gamepanel.setFocusable();
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
        g2d.fill(player);
        g2d.draw(player);
    }

    public void update(){

        

    }

    @Override
    public void run() {
        update();
        repaint();
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

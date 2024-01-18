import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.*;
public class Gamepanel extends JPanel implements Runnable, ActionListener{
    
    public double player_X = -100;
    public double player_Y = 50;
    public double player_Width = 70;
    public double player_Height = 35;
    public double player_velocity = 0;
    public double rör_X = 900;
    public double rör_Y;
    public Thread gameThread;
    public boolean started = false;
    public double radians;;
    public Keys keys;
    public Image img;
    Color playercolor;
    JButton button;
    public Image backgroundImage;
    public Image rörImage;
    public java.awt.geom.Rectangle2D.Double hitbox;
    Gamepanel(){
         
        keys = new Keys();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(900,600));
        this.setFocusable(true);
        this.addKeyListener(keys);
        button = new JButton();
        button.setBounds(420,240,60,60);
        button.setVisible(true);
        button.setText("start");
        button.setOpaque(true);
        button.setBackground(Color.WHITE);
        button.addActionListener(this);

    }
    public void Gamethread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        img = new ImageIcon("Flappybirb.png").getImage();
        hitbox = new Rectangle2D.Double(player_X,player_Y,70,35);
        backgroundImage = new ImageIcon("Flappybirdbakgrund.jpg").getImage();
        rörImage = new ImageIcon("rörbild.png").getImage();
        g2d.drawImage(backgroundImage,0,0,null);
        g2d.drawImage(rörImage,(int)rör_X,(int)rör_Y,null);
        g2d.drawImage(img,(int)player_X,(int)player_Y, null);
        
    }

    public void update(){

        if (keys.uppclick && player_velocity > -10) {
            player_velocity = -13;
            keys.uppclick = false;
        } else {}
        if (player_Y>=600 - player_Height) {
            player_Y = 600-player_Height;
            player_velocity = 0;
        } else{
            player_Y += player_velocity;
            player_velocity += 0.500;
        }
        rör_X += 3;
        
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
        } //else if(e.getSource() = null){

        //}

    }
}

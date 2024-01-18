import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener{

    public boolean uppclick = false;


    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyChar();

        if (keycode == KeyEvent.VK_SPACE && uppclick == false){
            uppclick = true;
            
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keycode = e.getKeyChar();

        if (keycode == KeyEvent.VK_SPACE){
            uppclick = false;
        
        }

        
    }
    
}

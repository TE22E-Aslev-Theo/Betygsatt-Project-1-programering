import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener{

    public boolean uppclick;

    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keycode = e.getKeyChar();

        if (keycode == 'w'){
            uppclick = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char keycode = e.getKeyChar();

        if (keycode == 'w'){
            uppclick = false;
        }
    }
    
}

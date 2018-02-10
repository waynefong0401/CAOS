package project;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JNumberTextField extends JTextField 
{
    @Override
    public void processKeyEvent(KeyEvent ev) {
        if (Character.isDigit(ev.getKeyChar())||ev.getKeyChar()==10||ev.getKeyChar()==KeyEvent.VK_BACK_SPACE)
            super.processKeyEvent(ev);
        ev.consume();
        return;
    }
}
package ActionHandler;

import GUI.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CarHandler implements KeyListener {
    GameGUI g;
    CarGUI c;

    public CarHandler(GameGUI g, CarGUI c) {
        this.g = g;
        this.c = c;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        // TODO Auto-generated method stub
        int code = ke.getKeyCode();
   
        // System.out.println(code);

        int x = c.carPanel.getX();
        int y = c.carPanel.getY();

        if (code == 37 && x - c.speed >= 20) { //Left
            c.carPanel.setLocation(x - c.speed, y);
        }

        if (code == 39 && x + c.speed <= g.fr.getWidth() - c.carPanel.getWidth() - 20) { //Right
            c.carPanel.setLocation(x + c.speed, y);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

}

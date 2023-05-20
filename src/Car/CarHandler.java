package Car;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CarHandler implements KeyListener {
    CarGameGUI g;

    public CarHandler(CarGameGUI ref) {
        this.g = ref;
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

        int x = g.carPanel.getX();
        int y = g.carPanel.getY();

        if (code == 37 && x - g.speed >= 0) { //Left
            g.carPanel.setLocation(x - g.speed, y);
        }

        if (code == 39 && x + g.speed <= g.fr.getWidth() - g.carPanel.getWidth() - 2) { //Right
            g.carPanel.setLocation(x + g.speed, y);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

}

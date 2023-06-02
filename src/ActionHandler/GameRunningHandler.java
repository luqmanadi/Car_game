package ActionHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import GUI.BecakGUI;
import GUI.CarGUI;
import GUI.GameGUI;

/**
 * GameOverHandler
 */
public class GameRunningHandler implements KeyListener {
    GameGUI game;
    CarGUI car;
    BecakHandler becakHandler;
    Timer timerGamer;
    boolean gameOver = false;

    public GameRunningHandler(GameGUI game, CarGUI car, BecakHandler becakHandler) {
        this.game = game;
        this.car = car;
        this.becakHandler = becakHandler;
        filterCarHitter();
    }

    public void filterCarHitter() {
        timerGamer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (BecakGUI becak: becakHandler.becaks) {
                    int carLeftSide = car.carPanel.getX() - car.carPanel.getWidth()/2 + 5,
                        carRightSide = car.carPanel.getX() + car.carPanel.getWidth()/2 - 5,
                        carFrontSide = car.carPanel.getY() - car.carPanel.getHeight()/2 + 5,
                        carBackSide = car.carPanel.getY() + car.carPanel.getHeight()/2 - 5,
                        becakLeftSide = becak.becakPanel.getX() - becak.becakPanel.getWidth()/2 + 5,
                        becakRightSide = becak.becakPanel.getX() + becak.becakPanel.getWidth()/2 - 5,
                        becakFrontSide = becak.becakPanel.getY() - becak.becakPanel.getHeight()/2 + 5,
                        becakBackSide = becak.becakPanel.getY() + becak.becakPanel.getHeight()/2 - 5;
                    if (carRightSide >= becakLeftSide && carLeftSide <= becakRightSide && carBackSide >= becakFrontSide && carFrontSide <= becakBackSide) {
                        gameOver();
                    }
                }
            }
        });
        timerGamer.start();
    }

    public void gameStart() {
        gameOver = false;
        game.gameOverLayout.setVisible(false);
        game.background.setVisible(true);
        becakHandler.restartBecakLocation();
        car.carPanel.setLocation(500/2-car.carPanel.getWidth()/2, 400);
    }
    
    public void gameOver() {
        gameOver = true;
        game.background.setVisible(false);
        game.gameOverLayout.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        // pass
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                gameStart();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // pass
    }

    
}
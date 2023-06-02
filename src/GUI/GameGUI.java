/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import ActionHandler.BecakHandler;
import ActionHandler.CarHandler;
import ActionHandler.GameRunningHandler;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author LENOVO
 */
public class GameGUI implements InterfaceGUI{
    public JFrame fr;
    public JLabel background, gameOverLayout;
    public CarHandler carHandler;
    public BecakHandler becakHandler;
    public GameRunningHandler gameOverHandler;
    public CarGUI car;
    public Timer timerBecakLoop;
    
    public GameGUI() {
        initGUI();
    }
    
    @Override
    public void initGUI(){
        fr = new JFrame("Car Game");
        fr.setSize(500,620);
        
        background = new JLabel(null, new ImageIcon("assets/bg.gif"),JLabel.CENTER);
        background.setBounds(0,0,fr.getWidth(),fr.getHeight());
        fr.add(background);

        gameOverLayout = new JLabel(null, new ImageIcon("assets/game_over.png"),JLabel.CENTER);
        gameOverLayout.setBounds(0, 0, fr.getWidth(), fr.getHeight());
        gameOverLayout.setVisible(false);
        fr.add(gameOverLayout);

        initCarHandler();
        initBecakHandler();
        initGameOverHandler();
        
        fr.setVisible(true);
        fr.setLayout(null);
        fr.setFocusable(true);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
        
    private void initCarHandler(){
        car = new CarGUI();
        background.add(car.carPanel);
        carHandler = new CarHandler(this, car);
        fr.addKeyListener(carHandler);
    }

    private void initBecakHandler(){
        becakHandler = new BecakHandler(background);
    }

    private void initGameOverHandler() {
        gameOverHandler = new GameRunningHandler(this, car, becakHandler);
        fr.addKeyListener(gameOverHandler);
    }
    
}

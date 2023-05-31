/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import ActionHandler.CarHandler;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author LENOVO
 */
public class GameGUI implements InterfaceGUI{
    public JFrame fr;
    public JLabel background;
    public CarHandler hnd;
    public CarGUI car;
    
    public GameGUI() {
        car = new CarGUI(fr);
        initGUI();
        initHandler();
    }
    
    @Override
    public final void initGUI(){
        fr = new JFrame("Car Game");
        fr.setLayout(null);
        fr.setSize(500,620);
        background = new JLabel("", new ImageIcon("bg.gif"),JLabel.CENTER);
        background.setBounds(0,0,fr.getWidth(),fr.getHeight());
        fr.add(background);
        background.add(car.carPanel);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        
    private void initHandler(){
        hnd = new CarHandler(this, car);
        fr.addKeyListener(hnd);
    }
    
}

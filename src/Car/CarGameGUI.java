package Car;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kelompok 11
 */
public class CarGameGUI {
    JFrame fr;
    JPanel carPanel;
    CarHandler hnd;
    JLabel background;
    int speed = 30;
    
    public CarGameGUI(){
  
        hnd = new CarHandler(this);
        initGUI();
    }

    private void initGUI(){
        fr = new JFrame("Car Game");
        fr.setLayout(null);
        background = new JLabel("", new ImageIcon("bg.gif"),JLabel.CENTER);
        background.setBounds(0,0,500,707);
        fr.add(background);
        carPanel = new JPanel();
        carPanel.setSize(80,183);
        JLabel car = new JLabel(new ImageIcon("ferrari54.png"));
        carPanel.add(car);
        carPanel.setLocation(220, 480);
        Color carBg = Color.decode("#545454");
        carPanel.setBackground(carBg);
        background.add(carPanel);
        fr.setSize(500,707);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
        fr.addKeyListener(hnd);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

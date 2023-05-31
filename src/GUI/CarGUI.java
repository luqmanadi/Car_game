package GUI;

import ActionHandler.CarHandler;
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
public class CarGUI {
    public JPanel carPanel;
    public int speed = 15;
    
    public CarGUI(JFrame fr){
        initGUI(fr);
    }
   
    private void initGUI(JFrame fr){
        carPanel = new JPanel();
        carPanel.setSize(80,183);
        JLabel carLabel = new JLabel(new ImageIcon("ferrari54.png"));
        carPanel.add(carLabel);
        carPanel.setLocation(500/2-carPanel.getWidth()/2, 400);
//        Color carBg = Color.decode("#545454");
        carPanel.setBackground(new Color(0,0,0,0));
    }
}

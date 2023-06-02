/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class BecakGUI implements InterfaceGUI{

    public JPanel becakPanel;
    public int speed = 30, hLocation, wLocation;
    
    public BecakGUI(){
        initGUI();
    }

    @Override
    public void initGUI() {
        becakPanel = new JPanel();
        becakPanel.setBackground(new Color(0,0,0,0));
        becakPanel.setSize(70,142);
        JLabel carLabel = new JLabel(new ImageIcon("assets/becak.png"));
        becakPanel.add(carLabel);
//        Color carBg = Color.decode("#545454");
    }
    
}

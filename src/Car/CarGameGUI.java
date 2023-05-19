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
    public CarGameGUI(){
        initGUI();
    }
    public void initGUI(){
        fr = new JFrame("Car Game");
        fr.setLayout(null);
        carPanel = new JPanel();
        carPanel.setSize(80,183);
        
        JLabel car = new JLabel(new ImageIcon("ferrari5.png"));
        carPanel.add(car);
        carPanel.setLocation(350, 280);
        //carPanel.setBackground(Color.blue);
        fr.add(carPanel);
        fr.setSize(800,500);
        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

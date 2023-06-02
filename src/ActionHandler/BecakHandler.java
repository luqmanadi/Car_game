package ActionHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.Timer;

import GUI.BecakGUI;

public class BecakHandler {
    public int totalBecak = 5;
    public Timer[] timerShifts = new Timer[totalBecak];
    public BecakGUI[] becaks = new BecakGUI[totalBecak];
    public JLabel gameGUIBackground;
    
    public BecakHandler(JLabel gameGUIBackground) {
        this.gameGUIBackground = gameGUIBackground;
        spawningBecak();
    }

    public void spawningBecak() {
        for (int i = 0; i < totalBecak; i++) {
            shiftLocation(i);
        }
    }

    private void shiftLocation(int i) {
        becaks[i] = new BecakGUI();
        filterLocation(i);
        gameGUIBackground.add(becaks[i].becakPanel);
        timerShifts[i] = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                becaks[i].hLocation += 15;
                if (becaks[i].hLocation <= 620) {
                    becaks[i].becakPanel.setLocation(becaks[i].becakPanel.getX(), becaks[i].hLocation);
                } else {
                    filterLocation(i);
                }
            }
        });
        timerShifts[i].start();
    }

    private void filterLocation(int i) {
        becaks[i].hLocation = i * -200;
        Random randNum = new Random();
        becaks[i].wLocation = randNum.nextInt(500);
        if (becaks[i].wLocation <= becaks[i].becakPanel.getWidth()) {
            becaks[i].wLocation = becaks[i].wLocation + becaks[i].becakPanel.getWidth();
        }
    
        if (becaks[i].wLocation >= gameGUIBackground.getWidth()) {
            becaks[i].wLocation = becaks[i].wLocation - becaks[i].becakPanel.getWidth();
        }
        becaks[i].becakPanel.setLocation(becaks[i].wLocation, becaks[i].hLocation);
    }

    public void restartBecakLocation() {
        int i = 0;
        for (BecakGUI becak : becaks) {
            becak.hLocation =  i * -200;
            Random randNum = new Random();
            becak.wLocation = randNum.nextInt(500);
            if (becak.wLocation <= becak.becakPanel.getWidth()) {
                becak.wLocation = becak.wLocation + becak.becakPanel.getWidth();
            }

            if (becak.wLocation >= gameGUIBackground.getWidth()) {
                becak.wLocation = becak.wLocation - becak.becakPanel.getWidth();
            }
            becak.becakPanel.setLocation(becak.wLocation, becak.hLocation);

            i++;
        }
    }
}

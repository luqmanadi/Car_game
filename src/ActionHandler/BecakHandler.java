package ActionHandler; // Mendefinisikan package ActionHandler

import java.awt.event.ActionEvent; // Mengimpor kelas ActionEvent dari paket java.awt.event
import java.awt.event.ActionListener; // Mengimpor kelas ActionListener dari paket java.awt.event
import java.util.Random; // Mengimpor kelas Random dari paket java.util

import javax.swing.JLabel; // Mengimpor kelas JLabel dari paket javax.swing
import javax.swing.Timer; // Mengimpor kelas Timer dari paket javax.swing

import GUI.BecakGUI; // Mengimpor kelas BecakGUI dari package GUI

public class BecakHandler {
    public int totalBecak = 5; // Deklarasi variabel totalBecak dengan nilai 5
    public Timer[] timerShifts = new Timer[totalBecak]; // Array Timer untuk mengatur pergeseran becak
    public BecakGUI[] becaks = new BecakGUI[totalBecak]; // Array BecakGUI untuk menyimpan objek becak
    public JLabel gameGUIBackground; // JLabel latar belakang permainan

    /**
     * Konstruktor BecakHandler.
     * @param gameGUIBackground JLabel yang merepresentasikan latar belakang permainan
     */
    public BecakHandler(JLabel gameGUIBackground) {
        this.gameGUIBackground = gameGUIBackground; // Menginisialisasi latar belakang permainan
        spawningBecak(); // Memulai penampilan becak
    }

    /**
     * Metode untuk menampilkan becak pada awal permainan.
     */
    public void spawningBecak() {
        for (int i = 0; i < totalBecak; i++) {
            shiftLocation(i); // Memindahkan lokasi becak pada indeks i
        }
    }

    /**
     * Metode untuk memindahkan lokasi becak pada indeks i.
     * @param i Indeks becak
     */
    private void shiftLocation(int i) {
        becaks[i] = new BecakGUI(); // Membuat objek becak pada indeks i
        filterLocation(i); // Memfilter lokasi becak pada indeks i
        gameGUIBackground.add(becaks[i].becakPanel); // Menambahkan panel becak ke latar belakang permainan
        timerShifts[i] = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                becaks[i].hLocation += 15; // Menggeser lokasi becak ke bawah
                if (becaks[i].hLocation <= 620) {
                    becaks[i].becakPanel.setLocation(becaks[i].becakPanel.getX(), becaks[i].hLocation);
                } else {
                    filterLocation(i);
                }
            }
        });
        timerShifts[i].start(); // Memulai timer pergeseran becak
    }

    /**
     * Metode untuk memfilter lokasi becak pada indeks i.
     * @param i Indeks becak
     */
    private void filterLocation(int i) {
        becaks[i].hLocation = i * -200; // Mengatur lokasi vertikal becak berdasarkan indeks i
        Random randNum = new Random(); // Membuat objek Random untuk menghasilkan angka acak
        becaks[i].wLocation = randNum.nextInt(500); // Menghasilkan angka acak untuk lokasi horizontal becak
        if (becaks[i].wLocation <= becaks[i].becakPanel.getWidth()) {
            becaks[i].wLocation = becaks[i].wLocation + becaks[i].becakPanel.getWidth();
        }
    
        if (becaks[i].wLocation >= gameGUIBackground.getWidth()) {
            becaks[i].wLocation = becaks[i].wLocation - becaks[i].becakPanel.getWidth();
        }
        becaks[i].becakPanel.setLocation(becaks[i].wLocation, becaks[i].hLocation);
    }

    /**
     * Metode untuk mengatur ulang lokasi becak pada awal permainan.
     */
    public void restartBecakLocation() {
        int i = 0;
        for (BecakGUI becak : becaks) {
            becak.hLocation =  i * -200; // Mengatur ulang lokasi vertikal becak berdasarkan indeks i
            Random randNum = new Random(); // Membuat objek Random untuk menghasilkan angka acak
            becak.wLocation = randNum.nextInt(500); // Menghasilkan angka acak untuk lokasi horizontal becak
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

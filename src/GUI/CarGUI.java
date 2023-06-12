package GUI; // Mendefinisikan package GUI

import java.awt.Color; // Mengimpor kelas Color dari paket java.awt
import javax.swing.ImageIcon; // Mengimpor kelas ImageIcon dari paket javax.swing
import javax.swing.JLabel; // Mengimpor kelas JLabel dari paket javax.swing
import javax.swing.JPanel; // Mengimpor kelas JPanel dari paket javax.swing

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Kelas CarGUI merepresentasikan antarmuka grafis untuk mobil.
 */
public class CarGUI {
    public JPanel carPanel; // Deklarasi variabel JPanel dengan nama carPanel
    public int speed = 15; // Deklarasi variabel speed dengan nilai awal 15

    /**
     * Konstruktor CarGUI.
     */
    public CarGUI() {
        initGUI(); // Memanggil metode initGUI() saat objek CarGUI dibuat
    }

    private void initGUI() {
        carPanel = new JPanel(); // Membuat objek JPanel dengan nama carPanel
        carPanel.setSize(80, 183); // Mengatur ukuran carPanel menjadi 80x183 piksel

        JLabel carLabel = new JLabel(new ImageIcon("assets/ferrari54.png"));
        // Membuat objek JLabel dengan gambar "assets/ferrari54.png" sebagai ikon
        carPanel.add(carLabel); // Menambahkan JLabel carLabel ke dalam carPanel

        carPanel.setLocation(500 / 2 - carPanel.getWidth() / 2, 400);
        // Mengatur posisi carPanel di tengah-tengah layar (berdasarkan ukuran JFrame yang diasumsikan 500x620 piksel)

        // Color carBg = Color.decode("#545454");
        carPanel.setBackground(new Color(0, 0, 0, 0));
        // Mengatur latar belakang carPanel dengan warna hitam transparan

    }
}

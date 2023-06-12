/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI; // Mendefinisikan package GUI

import java.awt.Color; // Mengimpor kelas Color dari paket java.awt
import javax.swing.ImageIcon; // Mengimpor kelas ImageIcon dari paket javax.swing
import javax.swing.JLabel; // Mengimpor kelas JLabel dari paket javax.swing
import javax.swing.JPanel; // Mengimpor kelas JPanel dari paket javax.swing

/**
 * Kelas BecakGUI merepresentasikan antarmuka grafis untuk becak.
 */
public class BecakGUI implements InterfaceGUI {

    public JPanel becakPanel; // Deklarasi variabel JPanel dengan nama becakPanel
    public int speed = 30, hLocation, wLocation; // Deklarasi variabel speed dengan nilai awal 30, hLocation, dan wLocation

    /**
     * Konstruktor BecakGUI.
     */
    public BecakGUI() {
        initGUI(); // Memanggil metode initGUI() saat objek BecakGUI dibuat
    }

    @Override
    public void initGUI() {
        becakPanel = new JPanel(); // Membuat objek JPanel dengan nama becakPanel
        becakPanel.setBackground(new Color(0, 0, 0, 0));
        // Mengatur latar belakang becakPanel dengan warna hitam transparan

        becakPanel.setSize(70, 142); // Mengatur ukuran becakPanel menjadi 70x142 piksel

        JLabel carLabel = new JLabel(new ImageIcon("assets/becak.png"));
        // Membuat objek JLabel dengan gambar "assets/becak.png" sebagai ikon
        becakPanel.add(carLabel); // Menambahkan JLabel carLabel ke dalam becakPanel

        // Color carBg = Color.decode("#545454");
        // Mendeklarasikan objek Color dengan nama carBg dan warna yang didekode dari kode heksadesimal "#545454"
    }

}

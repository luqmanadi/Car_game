/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI; // Mendefinisikan package GUI

import ActionHandler.BecakHandler; // Mengimpor kelas BecakHandler dari package ActionHandler
import ActionHandler.CarHandler; // Mengimpor kelas CarHandler dari package ActionHandler
import ActionHandler.GameRunningHandler; // Mengimpor kelas GameRunningHandler dari package ActionHandler
import java.awt.Color;

import javax.swing.ImageIcon; // Mengimpor kelas ImageIcon dari paket javax.swing
import javax.swing.JFrame; // Mengimpor kelas JFrame dari paket javax.swing
import javax.swing.JLabel; // Mengimpor kelas JLabel dari paket javax.swing
import javax.swing.JTextField;
import javax.swing.Timer; // Mengimpor kelas Timer dari paket javax.swing

/**
 * Kelas GameGUI merupakan kelas yang mengimplementasikan InterfaceGUI.
 */
public class GameGUI implements InterfaceGUI {
    public JFrame fr; // Deklarasi variabel JFrame dengan nama fr
    public JLabel background, gameOverLayout; // Deklarasi variabel JLabel dengan nama background dan gameOverLayout
    public CarHandler carHandler; // Deklarasi variabel CarHandler dengan nama carHandler
    public BecakHandler becakHandler; // Deklarasi variabel BecakHandler dengan nama becakHandler
    public GameRunningHandler gameOverHandler; // Deklarasi variabel GameRunningHandler dengan nama gameOverHandler
    public CarGUI car; // Deklarasi variabel CarGUI dengan nama car
    public Timer timerBecakLoop; // Deklarasi variabel Timer dengan nama timerBecakLoop
    public JTextField scoreLabel;
    /**
     * Konstruktor GameGUI.
     */
    public GameGUI() {
        initGUI(); // Memanggil metode initGUI() saat objek GameGUI dibuat
    }

    @Override
    public void initGUI() {
        fr = new JFrame("Car Game"); // Membuat objek JFrame dengan judul "Car Game"
        fr.setSize(500, 620); // Mengatur ukuran JFrame menjadi 500x620 piksel

        background = new JLabel(null, new ImageIcon("assets/bg.gif"), JLabel.CENTER);
        // Membuat objek JLabel dengan gambar "assets/bg.gif" sebagai ikon dan posisi tengan (CENTER)
        background.setBounds(0, 0, fr.getWidth(), fr.getHeight()); // Mengatur batas JLabel sesuai dengan ukuran JFrame
        fr.add(background); // Menambahkan JLabel background ke JFrame

        gameOverLayout = new JLabel(null, new ImageIcon("assets/game_over.png"), JLabel.CENTER);
        // Membuat objek JLabel dengan gambar "assets/game_over.png" sebagai ikon dan posisi tengan (CENTER)
        gameOverLayout.setBounds(0, 0, fr.getWidth(), fr.getHeight()); // Mengatur batas JLabel sesuai dengan ukuran JFrame
        gameOverLayout.setVisible(false); // Mengatur JLabel tidak terlihat (invisible) pada awalnya
        fr.add(gameOverLayout); // Menambahkan JLabel gameOverLayout ke JFrame

        initScore();
       initCarHandler(); // Memanggil metode initCarHandler() untuk menginisialisasi handler mobil
        initBecakHandler(); // Memanggil metode initBecakHandler() untuk menginisialisasi handler becak
        initGameOverHandler(); // Memanggil metode initGameOverHandler() untuk menginisialisasi handler permainan selesai

        fr.setVisible(true); // Menampilkan JFrame
        fr.setLayout(null); // Mengatur tata letak JFrame menjadi null
        fr.setFocusable(true); // Mengatur fokus ke JFrame
        fr.setResizable(false); // Mengatur JFrame tidak dapat diubah ukurannya
        fr.setLocationRelativeTo(null); // Mengatur posisi JFrame di tengah layar
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Mengatur operasi default saat tombol close di JFrame ditekan
    }
    
    private void initScore() {
        scoreLabel = new JTextField("Score: ");
        scoreLabel.setSize(100, 100);
        scoreLabel.setLocation(40, 40);
        scoreLabel.setBackground(new Color(0, 0, 0, 0));
        background.add(scoreLabel);
    }
        
    private void initCarHandler() {
        car = new CarGUI(); // Membuat objek CarGUI
        background.add(car.carPanel); // Menambahkan panel mobil ke JLabel background
        carHandler = new CarHandler(this, car); // Membuat objek CarHandler dengan mengirimkan dirinya sendiri (this) dan objek CarGUI sebagai argumen
        fr.addKeyListener(carHandler); // Menambahkan key listener ke JFrame yang terhubung dengan CarHandler
    }

    private void initBecakHandler() {
        becakHandler = new BecakHandler(background, scoreLabel); // Membuat objek BecakHandler dengan mengirimkan JLabel background sebagai argumen
    }

    private void initGameOverHandler() {
        gameOverHandler = new GameRunningHandler(this, car, becakHandler); // Membuat objek GameRunningHandler dengan mengirimkan dirinya sendiri (this), objek CarGUI (car), dan objek BecakHandler (becakHandler) sebagai argumen
        fr.addKeyListener(gameOverHandler); // Menambahkan key listener ke JFrame yang terhubung dengan GameRunningHandler
    }

}

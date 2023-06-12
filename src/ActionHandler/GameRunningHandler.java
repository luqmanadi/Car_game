package ActionHandler; // Mendefinisikan package ActionHandler

import java.awt.event.ActionEvent; // Mengimpor kelas ActionEvent dari package java.awt.event
import java.awt.event.ActionListener; // Mengimpor kelas ActionListener dari package java.awt.event
import java.awt.event.KeyEvent; // Mengimpor kelas KeyEvent dari package java.awt.event
import java.awt.event.KeyListener; // Mengimpor kelas KeyListener dari package java.awt.event

import javax.swing.Timer; // Mengimpor kelas Timer dari package javax.swing

import GUI.BecakGUI; // Mengimpor kelas BecakGUI dari package GUI
import GUI.CarGUI; // Mengimpor kelas CarGUI dari package GUI
import GUI.GameGUI; // Mengimpor kelas GameGUI dari package GUI

/**
 * GameRunningHandler adalah kelas yang mengimplementasikan interface KeyListener dan digunakan untuk mengatur logika permainan.
 */
public class GameRunningHandler implements KeyListener {
    GameGUI game; // Objek GameGUI yang merepresentasikan antarmuka permainan
    CarGUI car; // Objek CarGUI yang merepresentasikan mobil
    BecakHandler becakHandler; // Objek BecakHandler yang mengatur becak
    Timer timerGamer; // Timer untuk mengatur pengecekan tabrakan
    boolean gameOver = false; // Flag untuk menandakan apakah permainan sudah berakhir

    /**
     * Konstruktor GameRunningHandler.
     * @param game Objek GameGUI yang merepresentasikan antarmuka permainan
     * @param car Objek CarGUI yang merepresentasikan mobil
     * @param becakHandler Objek BecakHandler yang mengatur becak
     */
    public GameRunningHandler(GameGUI game, CarGUI car, BecakHandler becakHandler) {
        this.game = game; // Menginisialisasi objek GameGUI
        this.car = car; // Menginisialisasi objek CarGUI
        this.becakHandler = becakHandler; // Menginisialisasi objek BecakHandler
        filterCarHitter(); // Memanggil metode filterCarHitter() untuk mengatur pengecekan tabrakan
    }

    /**
     * Metode untuk melakukan pengecekan tabrakan antara mobil dan becak.
     */
    public void filterCarHitter() {
        timerGamer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (BecakGUI becak: becakHandler.becaks) {
                    // Menghitung posisi sisi-sisi mobil dan becak
                    int carLeftSide = car.carPanel.getX() - car.carPanel.getWidth()/2 + 5,
                        carRightSide = car.carPanel.getX() + car.carPanel.getWidth()/2 - 5,
                        carFrontSide = car.carPanel.getY() - car.carPanel.getHeight()/2 + 5,
                        carBackSide = car.carPanel.getY() + car.carPanel.getHeight()/2 - 5,
                        becakLeftSide = becak.becakPanel.getX() - becak.becakPanel.getWidth()/2 + 5,
                        becakRightSide = becak.becakPanel.getX() + becak.becakPanel.getWidth()/2 - 5,
                        becakFrontSide = becak.becakPanel.getY() - becak.becakPanel.getHeight()/2 + 5,
                        becakBackSide = becak.becakPanel.getY() + becak.becakPanel.getHeight()/2 - 5;
                    
                    // Pengecekan tabrakan antara mobil dan becak
                    if (carRightSide >= becakLeftSide && carLeftSide <= becakRightSide && carBackSide >= becakFrontSide && carFrontSide <= becakBackSide) {
                        gameOver(); // Memanggil metode gameOver() jika terjadi tabrakan
                    }
                }
            }
        });
        timerGamer.start(); // Memulai timer pengecekan tabrakan
    }

    /**
     * Metode untuk memulai permainan.
     */
    public void gameStart() {
        gameOver = false; // Mengatur flag gameOver menjadi false
        game.gameOverLayout.setVisible(false); // Mengatur tampilan game over menjadi tidak terlihat
        game.background.setVisible(true); // Mengatur tampilan latar belakang menjadi terlihat
        becakHandler.restartBecakLocation(); // Memulai ulang posisi becak
        car.carPanel.setLocation(500/2-car.carPanel.getWidth()/2, 400); // Mengatur posisi mobil di tengah layar
    }
    
    /**
     * Metode yang dipanggil ketika permainan berakhir.
     */
    public void gameOver() {
        gameOver = true; // Mengatur flag gameOver menjadi true
        game.background.setVisible(false); // Mengatur tampilan latar belakang menjadi tidak terlihat
        game.gameOverLayout.setVisible(true); // Mengatur tampilan game over menjadi terlihat
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Tidak digunakan
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                gameStart(); // Memulai permainan baru jika tombol Enter ditekan setelah game over
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Tidak digunakan
    }
}

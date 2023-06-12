package ActionHandler; // Mendefinisikan package ActionHandler

import GUI.*; // Mengimpor semua kelas dari package GUI
import java.awt.event.KeyEvent; // Mengimpor kelas KeyEvent dari package java.awt.event
import java.awt.event.KeyListener; // Mengimpor kelas KeyListener dari package java.awt.event

// Mendefinisikan kelas CarHandler yang mengimplementasikan KeyListener.
public class CarHandler implements KeyListener {
    GameGUI g; // Objek GameGUI yang merepresentasikan antarmuka permainan
    CarGUI c; // Objek CarGUI yang merepresentasikan mobil

    /**
     * Konstruktor CarHandler.
     * @param g Objek GameGUI yang merepresentasikan antarmuka permainan
     * @param c Objek CarGUI yang merepresentasikan mobil
     */
    
    /* 
    Konstruktor CarHandler yang menerima objek GameGUI dan CarGUI sebagai parameter, 
    dan menginisialisasi objek-objek tersebut.
    */
    public CarHandler(GameGUI g, CarGUI c) {
        this.g = g; // Menginisialisasi objek GameGUI
        this.c = c; // Menginisialisasi objek CarGUI
    }

    // Implementasi metode keyTyped() dari antarmuka KeyListener. Tidak ada implementasi khusus pada implementasi ini.
    @Override
    public void keyTyped(KeyEvent ke) {
        // Tidak digunakan
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    // Implementasi metode keyPressed() dari antarmuka KeyListener.
    @Override
    public void keyPressed(KeyEvent ke) {
        // TODO Auto-generated method stub
        int code = ke.getKeyCode(); // Mendapatkan kode tombol yang ditekan

        // System.out.println(code);

        int x = c.carPanel.getX(); // Mendapatkan posisi X mobil
        int y = c.carPanel.getY(); // Mendapatkan posisi Y mobil

        if (code == 37 && x - c.speed >= 20) { // Jika tombol kiri (kode 37) ditekan dan posisi X - kecepatan mobil >= 20
            c.carPanel.setLocation(x - c.speed, y); // Menggeser mobil ke kiri sebesar kecepatan mobil
        }

        if (code == 39 && x + c.speed <= g.fr.getWidth() - c.carPanel.getWidth() - 20) { // Jika tombol kanan (kode 39) ditekan dan posisi X + kecepatan mobil <= lebar layar - lebar mobil - 20
            c.carPanel.setLocation(x + c.speed, y); // Menggeser mobil ke kanan sebesar kecepatan mobil
        }
    }
    
    // Implementasi metode keyReleased() dari antarmuka KeyListener. Tidak ada implementasi khusus pada implementasi ini.
    @Override
    public void keyReleased(KeyEvent ke) {
        // Tidak digunakan
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}

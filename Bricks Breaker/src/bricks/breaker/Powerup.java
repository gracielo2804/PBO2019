package bricks.breaker;

import java.awt.Image;


public class Powerup {
    
    String nama;
    int waktu;
    int life;
    Image Gambar;
    int x;
    int y;

    public Powerup(String nama, int waktu, int x, int y) {
        this.nama = nama;
        this.waktu = waktu;
        this.x = x;
        this.y = y;
        this.life=1;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getWaktu() {
        return waktu;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}

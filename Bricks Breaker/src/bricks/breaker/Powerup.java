/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bricks.breaker;

/**
 *
 * @author ASUS
 */
public class Powerup {
    String nama;
    int waktu;
    String efek;
    int x;
    int y;

    public Powerup(String nama, int waktu, String efek, int x, int y) {
        this.nama = nama;
        this.waktu = waktu;
        this.efek = efek;
        this.x = x;
        this.y = y;
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

    public String getEfek() {
        return efek;
    }

    public void setEfek(String efek) {
        this.efek = efek;
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

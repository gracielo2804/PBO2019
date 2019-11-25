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
public class game {
    String level;
    String nama;
    String power_up;
    int score;
    int hit;
    int ball;
    int x;
    int y;

    public game(String level, String nama, String power_up, int score, int hit, int ball, int x, int y) {
        this.level = level;
        this.nama = nama;
        this.power_up = power_up;
        this.score = score;
        this.hit = hit;
        this.ball = ball;
        this.x = x;
        this.y = y;
    }

    
    
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPower_up() {
        return power_up;
    }

    public void setPower_up(String power_up) {
        this.power_up = power_up;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
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

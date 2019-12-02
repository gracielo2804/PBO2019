/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bricks.breaker;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class Ball {
   int x,y,movex,movey;
   Image gambarbola;


    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.movex = 1;
        this.movey = 1  ;
        ImageIcon gmbr=new ImageIcon("Ball.jpg");
        Image img=gmbr.getImage();
        Image newimg=img.getScaledInstance(15,15,java.awt.Image.SCALE_SMOOTH);
        gambarbola=newimg;
    }

    public int getMovex() {
        return movex;
    }

    public void setMovex(int movex) {
        this.movex = movex;
    }

    public int getMovey() {
        return movey;
    }

    public void setMovey(int movey) {
        this.movey = movey;
    }

    public Image getGambarbola() {
        return gambarbola;
    }

    public void setGambarbola(Image gambarbola) {
        this.gambarbola = gambarbola;
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

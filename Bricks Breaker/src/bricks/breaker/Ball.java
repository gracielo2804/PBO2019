package bricks.breaker;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Ball {
   private int x,y,movex,movey;
   Image ball;
   public Ball() 
    {
       ImageIcon ballcon=new ImageIcon("Ball.jpg");
       Image imgn=ballcon.getImage();
       ball=imgn.getScaledInstance(15,15,java.awt.Image.SCALE_SMOOTH);
       x=100;
       movex=2;
       y=100;
       movey=2;
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

    public Image getBall() {
        return ball;
    }

    public void setBall(Image ball) {
        this.ball = ball;
    }

    
   
}

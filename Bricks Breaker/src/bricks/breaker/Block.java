
package bricks.breaker;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Block{
    private Image gambarblock;   
    private int x,y,width,height,life;
    private Ball ball;

    public Block(int x,int y,int life) {
        this.x=x;
        this.y=y;
        this.width=50;
        this.height=25;
        ImageIcon gmbr =new ImageIcon("");
        switch (life) {
            case 0:
                gmbr=new ImageIcon("brick.png");
                break;
            case 1:
                gmbr=new ImageIcon("brick1.png");
                break;
            case 2:
                gmbr=new ImageIcon("brick2.png");
                break;
            case 3:
                gmbr=new ImageIcon("brick3.png");
                break;
            case 4:
                gmbr=new ImageIcon("brick4.png");
                break;
            default:
                break;
        }
        Image img=gmbr.getImage();
        Image newimg=img.getScaledInstance(50,25,java.awt.Image.SCALE_SMOOTH);                
        gambarblock=newimg;                
    }
    
    public Image getGambarblock() {
        return gambarblock;
    }

    public void setGambarblock(Image gambarblock) {
        this.gambarblock = gambarblock;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
    public void hit()
    {
        this.life-=1;
        ImageIcon gmbr =new ImageIcon("");
        switch (life) {
//            case -1:
//                this.x=0;
//                this.y=0;
//                this.height=0;
//                this.width=0;
//                this.gambarblock=null;
//                break;
            case 0:
                gmbr=new ImageIcon("brick.png");
                break;
            case 1:
                gmbr=new ImageIcon("brick1.png");
                break;
            case 2:
                gmbr=new ImageIcon("brick2.png");
                break;
            case 3:
                gmbr=new ImageIcon("brick3.png");
                break;
            default:
                break;
        }             
        Image img=gmbr.getImage();
        Image newimg=img.getScaledInstance(50,25,java.awt.Image.SCALE_SMOOTH);                
        gambarblock=newimg;     
    }
    
}

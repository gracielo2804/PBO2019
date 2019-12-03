
package bricks.breaker;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Block{
    int x,y,width,height,life;
    Image GambarBlock;

    public Block(int x, int y, int life) {
        this.x = x;
        this.y = y;
        this.life = life;
        this.height=25;
        this.width=50;
        ImageIcon img=new ImageIcon();
        switch (life) {
            case 0:
                img=new ImageIcon("Brick.png");
                break;
            case 1:
                img=new ImageIcon("Brick1.png");
                break;
            case 2:
                img=new ImageIcon("Brick2.png");
                break;
            case 3:
                img=new ImageIcon("Brick3.png");
                break;
            case 4:
                img=new ImageIcon("Brick4.png");
                break;
            default:
                break;
        }
        Image imgg=img.getImage();
        GambarBlock=imgg.getScaledInstance(50,25,java.awt.Image.SCALE_SMOOTH);
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

    public Image getGambarblock() {
        return GambarBlock;
    }

    public void setGambarBlock(Image GambarBlock) {
        this.GambarBlock = GambarBlock;
    }
    public void hit()
    {
        life-=1;
        ImageIcon img=new ImageIcon();
       switch (life) {
            case -1 : 
                GambarBlock=null;                
                this.x=0;
                this.y=0;
                this.width=0;
                this.height=0;                
            case 0:
                img=new ImageIcon("Brick.png");
                break;
            case 1:
                img=new ImageIcon("Brick1.png");
                break;
            case 2:
                img=new ImageIcon("Brick2.png");
                break;
            case 3:
                img=new ImageIcon("Brick3.png");
                break;            
            default:
                break;
        }
        if (life>=0) {
            Image imgg=img.getImage();
        GambarBlock=imgg.getScaledInstance(50,25,java.awt.Image.SCALE_SMOOTH);
        }
        
    }
    
}

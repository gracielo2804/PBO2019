
package bricks.breaker;

import javax.swing.ImageIcon;

public class power_mutliple_ball extends Powerup{
    public power_mutliple_ball(String nama, int waktu, int x, int y) {
        super(nama, waktu, x, y);
        ImageIcon img=new ImageIcon("power_multiple_balls.png");
        this.Gambar=img.getImage().getScaledInstance(50, 50,java.awt.Image.SCALE_SMOOTH);
    }
            
}

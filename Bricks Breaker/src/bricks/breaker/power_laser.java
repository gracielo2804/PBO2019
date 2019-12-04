
package bricks.breaker;

import java.awt.Image;
import javax.swing.ImageIcon;

public class power_laser extends Powerup{
        
    public power_laser(String nama, int waktu, int x, int y) {
        super(nama, waktu, x, y);
        ImageIcon img=new ImageIcon("power_laser.png");
        this.Gambar=img.getImage().getScaledInstance(50, 50,java.awt.Image.SCALE_SMOOTH);
        
        
    }
        
    
}

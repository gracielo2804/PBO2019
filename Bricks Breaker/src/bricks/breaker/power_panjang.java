package bricks.breaker;

import javax.swing.ImageIcon;

public class power_panjang extends Powerup{
    
    public power_panjang(String nama, int waktu, int x, int y) {
        super(nama, waktu, x, y);
        ImageIcon img=new ImageIcon("slide_expand.png");
        this.Gambar=img.getImage().getScaledInstance(50, 50,java.awt.Image.SCALE_SMOOTH);
    }
    
    
}

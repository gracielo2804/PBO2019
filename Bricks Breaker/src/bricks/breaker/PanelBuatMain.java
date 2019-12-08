/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package bricks.breaker;

import static bricks.breaker.From.Music;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author cielo
 */
public class PanelBuatMain extends javax.swing.JPanel {
    
    /**
     * Creates new form PanelBuatMain
     */
    ArrayList<Powerup>power=new ArrayList<Powerup>();
    Rectangle TmbLsr;
    public Frame2 f;
    int ctrPower = 0; //Memberi waktu untuk power up panjang
    int xBoard,skor =0;
    int pLaser = 50, ctrLaser = 2, Xlaser, Ylaser;
    ArrayList<Ball> ball =new ArrayList<>();
    boolean laser=false,multiple=false,panjang=false, tembak = false;
    Timer t, b, PowerTime;
    int yboard =this.getHeight()-50,panjangpapan=150;
    int xbola=100,ybola=100,movexbola=2,moveybola=2;
    ArrayList<Block>block=new ArrayList<>();
    public PanelBuatMain() {
        initComponents();
        xBoard = this.getWidth()/2;
        ball.add(new Ball(xBoard + 75, 280));
        
        //I gae lebar e J gae panjang
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                int rnd= (int)(Math.random()*5);
                block.add(new Block((j*90)+30, 50 * (i+1),rnd));
            }
        }
        try {
            ballbridge=ImageIO.read(new File("ball_bridge1.png"));
        } catch (IOException ex) {
            Logger.getLogger(From.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setFocusable(true);
        t =new Timer(5,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < ball.size(); i++) {
                    for (Block bl : block) {
                        Rectangle ktk = new Rectangle(bl.getX(), bl.getY(), bl.getWidth(), bl.getHeight());
                        
                        //arah bola dari jam 10 ke jam 5
                        if (ball.get(i).getMovex()>0 && ball.get(i).getMovey()>0) {
                            if(ktk.intersects(new Rectangle(ball.get(i).getX(), ball.get(i).getY(), 15, 15))) {
                                if(bl.life==0)
                                {
                                    int randomdapet=(int)(Math.random()*2);
                                    System.out.println(randomdapet);
                                    if (randomdapet==1) {
                                        int randompower=(int)(Math.random()*3);
                                        if (randompower==0) {
                                            power.add(new power_laser("laser1", 0, bl.getX()+5, bl.getY()));
                                        }
                                        if (randompower==1) {
                                            power.add(new power_mutliple_ball("ball", 0, bl.getX()+5, bl.getY()));
                                        }
                                        if (randompower==2) {
                                            power.add(new power_panjang("panjang", 0, bl.getX()+5, bl.getY()));
                                        }
                                    }
                                }
                                if((ball.get(i).getY()+15)<=(bl.getY()+bl.getHeight()))
                                {
                                    //bagian atas
                                    ball.get(i).kananatas();
                                    bl.hit();
                                    skor++;
                                    Music("Beep8.wav");
                                }
                                else if (ball.get(i).getY()>=bl.getY()||ball.get(i).getY()<=(bl.getY()+bl.getHeight())&& (ball.get(i).getX()+15)>=bl.getX()){
                                    //kalau natap bagian kiri
                                    ball.get(i).kiribawah();
                                    bl.hit();
                                    Music("Beep8.wav");
                                }
                            }
                            //arah bola daro jam 7 ke jam 2
                        }
                        else if (ball.get(i).getMovex()>0 && ball.get(i).getMovey()<0) {
                            if(ktk.intersects(new Rectangle(ball.get(i).getX(), ball.get(i).getY(), 15, 15))){
                                if((ball.get(i).getY()-15)>=(bl.getY()))
                                {
                                    ball.get(i).kananbawah();
                                    bl.hit();
                                    skor++;
                                    Music("Beep8.wav");
                                }
                                else if ((ball.get(i).getX()+15)>=bl.getX()&&ball.get(i).getY()<=(bl.getY()+bl.getHeight())||ball.get(i).getY()>=ball.get(i).getY()) {
                                    ball.get(i).kiriatas();
                                    bl.hit();Music("Beep8.wav");skor++;
                                }
                            }
                            //arah bola dari jam 5 ke jam 10
                        }
                        else if (ball.get(i).getMovex()<0 && ball.get(i).getMovey()<0) {
                            if(ktk.intersects(new Rectangle(ball.get(i).getX(), ball.get(i).getY(), 15, 15)))
                            {
                                if((ball.get(i).getY()-15)>=(bl.getY())){
                                    ball.get(i).kiribawah();
                                    bl.hit();
                                    Music("Beep8.wav");
                                    skor++;
                                }
                                
                                else if (ball.get(i).getX()<=(bl.getX()+bl.getWidth()) && ball.get(i).getY()<= (bl.getY()+bl.getHeight())||ball.get(i).getY()>=bl.getY()) {
                                    ball.get(i).kananatas();
                                    bl.hit();
                                    Music("Beep8.wav");
                                    skor++;
                                }
                            }
                            //arah bola  daro jam 2 ke jam 7
                        }
                        else if (ball.get(i).getMovex()<0 && ball.get(i).getMovey() >0) {
                            if(ktk.intersects(new Rectangle(ball.get(i).getX(), ball.get(i).getY(), 15, 15)))
                            {
                                if((ball.get(i).getY()+15)<=(bl.getY()+bl.getHeight()))
                                {
                                    ball.get(i).kiriatas();
                                    bl.hit();
                                    Music("Beep8.wav");
                                    skor++;
                                }
                                else if (ball.get(i).getX()<=(bl.getX()+bl.getWidth()) && ball.get(i).getY()<=(bl.getY()+bl.getHeight())||ball.get(i).getY()>=bl.getY()) {
                                    ball.get(i).kananbawah();
                                    bl.hit();
                                    Music("Beep8.wav");
                                    skor++;
                                }
                            }
                        }
                        
                    }
                    ball.get(i).setX(ball.get(i).getX()+ball.get(i).getMovex());
                    ball.get(i).setY(ball.get(i).getY()+ball.get(i).getMovey());
                    if (power.size()>0) {
                        for (int j = 0;j < power.size(); j++) {
                            power.get(j).y+=1;
                            if ((power.get(j).y+40)==(f.getHeight()-65) && power.get(j).x>=xBoard&&power.get(j).x<=xBoard+145) {
                                System.out.println("dapat");
                                if (power.get(i) instanceof power_laser) {
                                    laser =true;
                                }
                                if (power.get(j) instanceof power_mutliple_ball) {
                                    for (int k = 0; k < 5; k++) {
                                        ball.add(new Ball(ball.get(0).getX(), ball.get(0).getY()));
                                    }
                                }
                                if (power.get(j)instanceof power_panjang) {
                                    panjangpapan=300;
                                    PowerTime.start();
                                }
                            }
                            if ((power.get(j).y+40)==(f.getHeight()-65) && power.get(j).x<xBoard&&power.get(j).x>xBoard+145) {
                                System.out.println("tidak dapat");
                            }
                            if ((power.get(j).y+40)>(f.getHeight()-50)) {
                                power.get(j).life=0;
                                power.remove(j);
                            }
                        }
                    }
                    if (tembak) {
                        Ylaser -= ctrLaser;
                        TmbLsr.setLocation(Xlaser, Ylaser);
                        System.out.println("tembak");
                        System.out.println(Ylaser);
                        if (Ylaser <= 0) {
                            tembak = false;
                        }
                    }
                    repaint();
                }
            }
        });
        
        PowerTime = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrPower++;
                if (ctrPower == 5) {
                    panjangpapan = 150;
                    PowerTime.stop();
                    ctrPower = 0;
                }
            }
        });
    }
    BufferedImage ballbridge;
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D)grphcs;
        if (tembak == true) {
            g2.setColor(Color.BLUE);
            g2.fill(TmbLsr);
        }
        //posisi x,y,ukuran,ukuran,
        g2.setColor(Color.BLACK);
        g2.drawString("Skor : "+String.valueOf(skor),300,300);
//        //tester auto pilot tinggal,manual pake yg xboard
        g2.drawImage(ballbridge,xBoard,yboard,panjangpapan,50,null);
        for (int i = 0; i < ball.size(); i++) {
            g2.drawImage(ballbridge,xBoard,this.getHeight()-50,panjangpapan,50,null);
        }
        for (int i = 0; i < block.size(); i++) {
            g2.drawImage(block.get(i).getGambarblock(),block.get(i).getX(),block.get(i).getY(), this);
        }
        g2.setColor(Color.blue);
        
        //Pantulan bola
        for (int i = 0; i < ball.size(); i++)
        {
            if (ball.get(i).getY()>=this.getHeight()-65&& ball.get(i).getX()<=xBoard+panjangpapan && ball.get(i).getX()>=xBoard) {
                ball.get(i).setMovey(ball.get(i).getMovey()*-1);
                Music("Paddle Sound.wav");
            }
            if (ball.get(i).getY()>= this.getHeight() && ball.get(i).getX()+15 >= xBoard-2 && ball.get(i).getX()+15 <= xBoard+3) { //bola nyentuh sebelah kiri board
                ball.get(i).setMovex(ball.get(i).getX()*-1);
                ball.get(i).setMovey(ball.get(i).getY()*-1);
                Music("Paddle Sound.wav");
            }
            if (ball.get(i).getY() >= this.getHeight() && ball.get(i).getX() >= xBoard+panjangpapan-3 && ball.get(i).getX() <= xBoard+panjangpapan+2) {
                ball.get(i).setMovex(ball.get(i).getX()*-1);
                ball.get(i).setMovey(ball.get(i).getY()*-1);
                Music("Paddle Sound.wav");
            }
//            if (ball.get(i).getY()>this.getHeight()-65 ) {
//                ball.get(i).setMovey(-1);
//                Music("Paddle Sound.wav");
//            }
            if (ball.get(i).getX()+10>this.getWidth()) {
                if (ball.get(i).getMovex()>0 && ball.get(i).getMovey()>0 ) {
                    ball.get(i).kiribawah();
                }
                else if(ball.get(i).getMovex()>0&&ball.get(i).getMovey()<0){
                    ball.get(i).kiriatas();
                }
            }
            if (ball.get(i).getX()<=this.getX()) {
                if (ball.get(i).getMovex()<0 && ball.get(i).getMovey()<0) {
                    ball.get(i).kananatas();
                }
                else if(ball.get(i).getMovex()<0 && ball.get(i).getMovey()>0){
                    ball.get(i).kananbawah();
                }
            }
            if (ball.get(i).getY()<20) {
                ball.get(i).setMovey(ball.get(i).getMovey() *-1);
            }
            if (ball.get(0).getY()>this.getHeight()) {
                t.stop();
                JOptionPane.showMessageDialog(this,"Game Over");
                ball.get(0).setX(100);
                ball.get(0).setY(100);
                t.stop();
                f.cekgame=false;
                f.skor=this.skor;
            }
            g2.drawImage(ball.get(i).getGambarbola(), ball.get(i).getX(),ball.get(i).getY(), this);
        }

        if (power.size()>0) {
            for (Powerup pwr : power) {
                g2.drawImage(pwr.Gambar, pwr.x,pwr.y,40,40,null);
            }
        }
        repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        char a = evt.getKeyChar();
        if (a=='a') {
            if (xBoard>0) {
                xBoard-=30;
            }
            
        }
        if (a=='d') {
            
            if ((xBoard+150)<this.getWidth()) {
                xBoard+=30;
            }
            
        }
        if (a==' ') {
            if (t.isRunning()) {
                t.stop();
            }else t.start();
        }
        if (a =='l') {
            if (laser) {
                Ylaser = this.getHeight()-65;
                Xlaser = (xBoard + panjangpapan)-(panjangpapan/2);
                tembak = true;
                TmbLsr = new Rectangle(Xlaser,Ylaser, 10, pLaser);
                laser = false;
            }
        }
        repaint();
    }//GEN-LAST:event_formKeyPressed
    public static void Music(String file){
        InputStream music;
        
        try{
            music = new FileInputStream(new File(file));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        }catch(Exception e){
            
        }
    }
    
    private void mbox()
    {
        JOptionPane.showMessageDialog(this,"cek");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

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
    int xBoard,skor =0;
    Ball ball;
    Timer t, b;
    int xbola=100,ybola=100,movexbola=2,moveybola=2;
    ArrayList<Block>block=new ArrayList<>();
    public PanelBuatMain() {
        initComponents();
        xBoard = this.getWidth()/2;
        ball=new Ball(xBoard + 75, 280);
        
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
        t =new Timer(10,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (Block bl : block) {
                    Rectangle ktk = new Rectangle(bl.getX(), bl.getY(), bl.getWidth(), bl.getHeight());
                    if(ktk.intersects(new Rectangle(ball.getX(), ball.getY(), 15, 15))){
                        //arah bola dari jam 10 ke jam 5
                        if (ball.getMovex()>0 && ball.getMovey()>0) {
                            if(ktk.intersects(new Rectangle(ball.getX(), ball.getY(), 15, 15))) {
                                if ((ball.getY()+15)>=bl.getY()&& (ball.getX()+15)>=bl.getX()){
                                    //kalau natap bagian kiri
                                    ball.kiribawah();
                                    bl.hit();
                                    Music("Beep8.wav");
                                    System.out.println("kiri bawah");
                                }
                                else
                                {
                                    //bagian atas 
                                    ball.kananatas();
                                    bl.hit();
                                    skor++;
                                    Music("Beep8.wav");
                                }
                            }
                        //arah bola daro jam 7 ke jam 2
                        }else if (ball.getMovex()>0 && ball.getMovey()<0) {
                            if(ktk.intersects(new Rectangle(ball.getX(), ball.getY(), 15, 15))){
                                if ((ball.getX()+15)>=bl.getX()&&ball.getY()>=( bl.getY()+bl.getHeight())) {
                                    ball.kiriatas();
                                    bl.hit();Music("Beep8.wav");skor++;
                                    System.out.println("kiri atas");
                                }
                                else  
                                {
                                    ball.kananbawah();
                                    bl.hit();
                                    skor++;
                                    Music("Beep8.wav");
                                }
                            }
                        //arah bola dari jam 5 ke jam 10
                        }else if (ball.getMovex()<0 && ball.getMovey()<0) {
                        if(ktk.intersects(new Rectangle(ball.getX(), ball.getY(), 15, 15)))
                        {
                            if (ball.getX()-5<=(bl.getX()+bl.getWidth()) && ball.getY()>= bl.getY()) {
                                ball.kananatas();
                                bl.hit();
                                System.out.println("kanan atas");
                                Music("Beep8.wav");
                                skor++;
                            }
                            else{
                                ball.kiribawah();
                                bl.hit();
                                Music("Beep8.wav");
                                skor++;   
                            }
                        }
                        //arah bola  daro jam 2 ke jam 7
                        }else if (ball.getMovex()<0 && ball.getMovey() >0) {
                        if(ktk.intersects(new Rectangle(ball.getX(), ball.getY(), 15, 15)))
                        {
                            if (ball.getX()>=(bl.getX()+bl.getWidth()) && ball.getY()>=(bl.getY()+bl.getHeight())) {
                                ball.kananbawah();
                                bl.hit();
                                Music("Beep8.wav");
                                System.out.println("kanan bawah");
                                skor++;   
                            }
                            else
                            {
                                ball.kiriatas();
                                bl.hit();
                                Music("Beep8.wav");
                                skor++;   
                            }
                        }}
                        repaint();
                    }
                }
                ball.setX(ball.getX()+ball.getMovex());
                ball.setY(ball.getY()+ball.getMovey());
                repaint();
            }
        });
    }
    BufferedImage ballbridge;
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); 
        Graphics2D g2 = (Graphics2D)grphcs;
        //posisi x,y,ukuran,ukuran,
        g2.setColor(Color.BLACK);
        g2.drawString("Skor : "+String.valueOf(skor),300,300);
        //tester auto pilot tinggal,manual pake yg xboard 
//        g2.drawImage(ballbridge,xBoard,this.getHeight()-50,150,50,null);
        g2.drawImage(ballbridge,ball.getX()-50,this.getHeight()-50,150,50,null);
        for (int i = 0; i < block.size(); i++) {
            g2.drawImage(block.get(i).getGambarblock(),block.get(i).getX(),block.get(i).getY(), this);
        }        
        g2.setColor(Color.blue);
//        if (ball.getY()>this.getHeight()-65&& ball.getX()<=xBoard+150 && ball.getX()>=xBoard) {
//            ball.setMovey(ball.getMovey()*-1);
//            Music("Paddle Sound.wav");
//        }
        if (ball.getY()>this.getHeight()-65 ) {
            ball.setMovey(-1);
            Music("Paddle Sound.wav");
        }
        if (ball.getX()+10>this.getWidth()) {
            if (ball.getMovex()>0 && ball.getMovey()>0 ) {
                ball.kiribawah();   
            }
            else if(ball.getMovex()>0&&ball.getMovey()<0){
                ball.kiriatas();
            }
        }
        if (ball.getX()<=this.getX()) {
            if (ball.getMovex()<0 && ball.getMovey()<0) {
                ball.kananatas();
            }
            else if(ball.getMovex()<0 && ball.getMovey()>0){
                ball.kananbawah();
            }
        }
        if (ball.getY()<0) {
            ball.setMovey(ball.getMovey()*-1);
        }
        if (ball.getY()>this.getHeight()) {
            t.stop();
            JOptionPane.showMessageDialog(this,"Game Over" + this.getHeight());
            ball.setX(100);
            ball.setY(100);
            t.stop();
        }
        
        g2.drawImage(ball.getGambarbola(), ball.getX(),ball.getY(), this);
        
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
            t.start();
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

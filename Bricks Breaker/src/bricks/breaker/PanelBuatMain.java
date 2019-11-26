/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bricks.breaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author cielo
 */
public class PanelBuatMain extends javax.swing.JPanel {

    /**
     * Creates new form PanelBuatMain
     */
    int x=(this.getWidth()/2);
    ImageIcon ballcon=new ImageIcon("Ball.jpg"); 
    Image ball;
    int xbola=100,ybola=100,movexbola=2,moveybola=2;
    ArrayList<Image> imgbrick=new ArrayList<>();
    public PanelBuatMain() {
        initComponents();        
        Image imgn=ballcon.getImage();
        ball=imgn.getScaledInstance(15,15,java.awt.Image.SCALE_SMOOTH);
        for (int i = 0; i < 10; i++) {
            int rnd= (int)(Math.random()*5);
            if (rnd==0) {
                ImageIcon icon= new ImageIcon("brick.png");
                Image img=icon.getImage();
                Image newimg=img.getScaledInstance(50,25,java.awt.Image.SCALE_SMOOTH);                
                imgbrick.add(newimg);
            }
            if (rnd==1) {
                ImageIcon icon= new ImageIcon("brick1.png");
                Image img=icon.getImage();
                Image newimg=img.getScaledInstance(50,25,java.awt.Image.SCALE_SMOOTH);            
                imgbrick.add(newimg);
            }
            if (rnd==2) {
                ImageIcon icon= new ImageIcon("brick2.png");
                Image img=icon.getImage();
                Image newimg=img.getScaledInstance(50,25,java.awt.Image.SCALE_SMOOTH);
                imgbrick.add(newimg);
            }
            if (rnd==3) {
                ImageIcon icon= new ImageIcon("brick3.png");
                Image img=icon.getImage();
                Image newimg=img.getScaledInstance(50,25,java.awt.Image.SCALE_SMOOTH);
                imgbrick.add(newimg);
            }
            if (rnd==4) {
                ImageIcon icon= new ImageIcon("brick4.png");
                Image img=icon.getImage();
                Image newimg=img.getScaledInstance(50,25,java.awt.Image.SCALE_SMOOTH);
                imgbrick.add(newimg);
            }            
        }
        try {
            ballbridge=ImageIO.read(new File("ball_bridge1.png"));
        } catch (IOException ex) {
            Logger.getLogger(From.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setFocusable(true);
        Timer t =new Timer(10,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xbola+=movexbola;                
                ybola+=moveybola;
                repaint();
            }
        });
        t.start();
    }
    BufferedImage ballbridge;
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); 
                Graphics2D g2 = (Graphics2D)grphcs;
        //posisi x,y,ukuran,ukuran,
        g2.drawImage(ballbridge,x,this.getHeight()-50,150,50,null);
        for (int i = 0; i < imgbrick.size(); i++) {
            g2.drawImage(imgbrick.get(i),(i*60)+50, 10, this);
        }
        g2.setColor(Color.blue);
        if (xbola>this.getWidth()-30) {
            movexbola*=-1;
        }
        if(ybola<0)
        {
            moveybola*=-1;
        }
        if (ybola>this.getHeight()-60&& xbola<=x+150 && xbola>=x) {
            moveybola*=-1;
        }
        if (xbola<0) {
            movexbola*=-1;
        }
                
        g2.drawImage(ball, xbola,ybola, this);
        
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
        System.out.println(evt.getKeyChar());
        if (a=='a') {
            if (x>0) {
                x-=30;
            }
            
        }
        if (a=='d') {
           
            if ((x+150)<this.getWidth()) {
                x+=30;
            }
            
        }
        repaint();
    }//GEN-LAST:event_formKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

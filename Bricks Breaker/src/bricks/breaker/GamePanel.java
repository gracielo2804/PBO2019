/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bricks.breaker;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author ASUS
 */
public class GamePanel extends javax.swing.JPanel {

    /**
     * Creates new form GamePanel
     */
    BufferedImage bg;
    public int xplay,xquit,yplay,yquit,widthplay,heightplay,widthquit,heightquit;
    BufferedImage board;
    BufferedImage play;
    BufferedImage quit;
    Timer t;
    public String status="";
    ArrayList<JLabel> arrlabel = new ArrayList<JLabel>();
    public GamePanel() {
        initComponents();
                initComponents();
         try {
            bg=ImageIO.read(new File("img_home-page.png"));
            board=ImageIO.read(new File("ball_bridge1.png"));
            play=ImageIO.read(new File("btn_play_normal.png"));
            quit=ImageIO.read(new File("btn_quit_normal.png"));
        } catch (IOException ex) {
            Logger.getLogger(From.class.getName()).log(Level.SEVERE, null, ex);
        }
//         t = new Timer(100,)

    }
    public void set_pos(int xplay,int xquit,int yplay,int yquit,int heightplay,int widthplay,int heightquit,int widthquit)
    {
        this.xplay=xplay;
        this.yplay=yplay;
        this.xquit=xquit;
        this.yquit=yquit;
        this.heightplay=heightplay;
        this.heightquit=heightquit;
        this.widthquit=widthquit;
        this.widthplay=widthplay;
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D)grphcs;
        //posisi x,y,ukuran,ukuran,
        g2.drawImage(bg,0,0,this.getWidth(),this.getHeight(),null);
        g2.drawImage(play,xplay,yplay,widthplay,heightplay,null);
        g2.drawImage(quit,xquit,yquit,widthquit,heightplay,null);
        g2.drawImage(board,50,900,550,100,null);
        for (JLabel lbl: arrlabel) {
            add(lbl);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
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

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

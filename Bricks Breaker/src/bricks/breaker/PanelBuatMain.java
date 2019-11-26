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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author cielo
 */
public class PanelBuatMain extends javax.swing.JPanel {

    /**
     * Creates new form PanelBuatMain
     */
    int x=(this.getWidth()/2);
    public PanelBuatMain() {
        initComponents();
        try {
            ballbridge=ImageIO.read(new File("ball_bridge1.png"));
        } catch (IOException ex) {
            Logger.getLogger(From.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setFocusable(true);
    }
    BufferedImage ballbridge;
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); 
                Graphics2D g2 = (Graphics2D)grphcs;
        //posisi x,y,ukuran,ukuran,
        g2.drawImage(ballbridge,x,this.getHeight()-50,150,50,null);
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

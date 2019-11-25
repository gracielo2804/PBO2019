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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D)grphcs;
        //posisi x,y,ukuran,ukuran,
        g2.drawImage(bg,0,0,this.getWidth(),this.getHeight(),null);
        g2.drawImage(play,(this.getHeight()/2),(this.getWidth()/2)-25,100, 40,null);
        g2.drawImage(quit,(this.getHeight()/2),(this.getWidth()/2)-25+50,100, 40,null);
        g2.drawImage(board,50,900,550,100,null);
        for (JLabel lbl: arrlabel) {
            add(lbl);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        System.out.println(evt.getX()+" "+evt.getY());
        if (evt.getX()>=(this.getHeight()/2)&& evt.getX()<(this.getHeight()/2)+100) {
            if (evt.getY()>=(this.getWidth()/2)&& evt.getY()<(this.getWidth()/2-25+50)+40) {
                JOptionPane.showMessageDialog(this,"Exit");
                
                status="c";
            }
        }
        if (evt.getX()>=(this.getHeight()/2)&& evt.getX()<(this.getHeight()/2)+100) {
            if (evt.getY()>=(this.getWidth()/2)&& evt.getY()<((this.getWidth()/2)-25)+40) {
                JOptionPane.showMessageDialog(this,"Play");
            }
        }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

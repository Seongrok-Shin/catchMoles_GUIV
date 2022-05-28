/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchMoles;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.MouseListener;

/**
 *
 * @author ssr7324
 */
public class MolePanel extends JPanel {

    private Image hole, mole1, mole2, mole3, deadMole, missMole;
    private Image imgHammer, imgHammerHit;
    private Cursor cHammer, cHammerHit, cNormal;
    private Toolkit toolkit;
    private molePanelListener molePanelListener;
    private setMoleInTheHole[] setMoleInTheHoles;

    public MolePanel() {

    }

    private void setMolePanel() {
        /*
        To get mole images
         */
        hole = new ImageIcon("./img/hole.png").getImage();
        mole1 = new ImageIcon("./img/mole1.png").getImage();
        mole2 = new ImageIcon("./img/mole2.png").getImage();
        mole3 = new ImageIcon("./img/mole3.png").getImage();
        deadMole = new ImageIcon("./img/deadMole.png").getImage();
        missMole = new ImageIcon("./img/missMole.png").getImage();

        toolkit = Toolkit.getDefaultToolkit();
        imgHammer = toolkit.getImage("./img/hammer");
        imgHammer = imgHammer.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
        imgHammerHit = toolkit.getImage("./img/hammerhit");
        imgHammerHit = imgHammerHit.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
        cHammer = toolkit.createCustomCursor(imgHammer, new Point(this.getX(), this.getY()), "img");
        cHammerHit = toolkit.createCustomCursor(imgHammerHit, new Point(this.getX(), this.getY()), "img");
        cNormal = new Cursor(Cursor.DEFAULT_CURSOR);
    }

    public void showTheMole() {
        this.setOpaque(false);
        this.setLayout(new GridLayout(3, 3));

        molePanelListener = new molePanelListener();
        setMoleInTheHoles = new setMoleInTheHole[Setting.NUMBER_MOLE];
        
        for(int i = 0; i < Setting.NUMBER_MOLE; i++){
            setMoleInTheHoles[i] = new setMoleInTheHole();
            setMoleInTheHoles[i].addMouseListener(molePanelListener);
            this.add(setMoleInTheHoles[i]);
        }
    }

    private class molePanelListener implements MouseListener {

        public molePanelListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class setMoleInTheHole extends JPanel {

        private int state = 1;

        public setMoleInTheHole() {
            this.setPreferredSize(new Dimension(170, 170));
            this.setOpaque(false);
        }

        public void painComponent(Graphics g) {
            super.paintComponent(g);
            switch (state) {
                case 1:
                    g.drawImage(hole, 20, 0, this);
                    state = 1;
                    break;
                case 2:
                    g.drawImage(mole1, 20, 0, this);
                    state = 2;
                    break;
                case 3:
                    g.drawImage(mole2, 20, 0, this);
                    state = 3;
                    break;
                case 4:
                    g.drawImage(mole3, 20, 0, this);
                    state = 4;
                    break;
                case 5:
                    g.drawImage(deadMole, 20, 0, this);
                    state = 5;
                    break;
                default:
                    g.drawImage(hole, 20, 0, this);
                    state = 1;
                    break;
            }
        }

        public void drawMole(int state) {
            this.state = state;
        }
    }
}

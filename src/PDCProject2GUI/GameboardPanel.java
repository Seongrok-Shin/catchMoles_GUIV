/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI;

import PDCProject1CUI.Gameboard;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.event.MouseListener;

/**
 *
 * @author ssr7324
 */
public class GameboardPanel extends JPanel {

    private Image imgHammer, imgHammerHit;
    private Cursor cHammer, cHammerHit, cNormal;
    private Toolkit toolkit;
    private molePanelListener molePanelListener;
    private Gameboard gameboard;

    public GameboardPanel(Gameboard gameboard) {
        setMolePanel();
        
        this.gameboard = gameboard;
        
        this.setOpaque(false);
        this.setLayout(new GridLayout(this.gameboard.getSize().getCol(), this.gameboard.getSize().getRow()));
        
        for (int i = 0; i < this.gameboard.getSize().getCol() * this.gameboard.getSize().getRow(); i++) {
            this.add(new MoleButton(this.gameboard.getMoleAtIndex(i)));
        }
    }
    
    private void setMolePanel() {
        toolkit = Toolkit.getDefaultToolkit();
        imgHammer = toolkit.getImage("./img/hammer");
        imgHammer = imgHammer.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
        imgHammerHit = toolkit.getImage("./img/hammerhit");
        imgHammerHit = imgHammerHit.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
        cHammer = toolkit.createCustomCursor(imgHammer, new Point(this.getX(), this.getY()), "img");
        cHammerHit = toolkit.createCustomCursor(imgHammerHit, new Point(this.getX(), this.getY()), "img");
        cNormal = new Cursor(Cursor.DEFAULT_CURSOR);
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
}

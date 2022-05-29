/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI;

import PDCProject2GUI.view.MoleButton;
import PDCProject2GUI.Setting;
import PDCProject2GUI.view.GameboardPanel;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author ssr7324
 */
public class MoleButtonListener implements MouseInputListener {
    private Image imgCursorNormal, imgCursorPressed;
    private GameboardPanel gameboardPanel;
    private MoleButtonInterface delegate;
    
    public MoleButtonListener(MoleButtonInterface delegate) {
        this.delegate = delegate;
        
        try {
            this.imgCursorNormal = ImageIO.read(new File("./img/ic_cursor_normal.png"))
                    .getScaledInstance(Setting.CURSOR_WIDTH, Setting.CURSOR_HEIGHT, Image.SCALE_SMOOTH);
            this.imgCursorPressed = ImageIO.read(new File("./img/ic_cursor_pressed.png"))
                    .getScaledInstance(Setting.CURSOR_WIDTH, Setting.CURSOR_HEIGHT, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            Logger.getLogger(MoleButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPanel(GameboardPanel gameboardPanel) {
        this.gameboardPanel = gameboardPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        MoleButton moleButton = (MoleButton) e.getSource();
        System.out.println("Index: " + moleButton.getMole().getIndex());
        this.delegate.didHitMoleAtIndex(moleButton.getMole().getIndex());
    }

    @Override
    public void mousePressed(MouseEvent e) {

        this.gameboardPanel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imgCursorPressed,
                new Point(Setting.CURSOR_WIDTH / 2, Setting.CURSOR_HEIGHT / 2), "img"));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.gameboardPanel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imgCursorNormal,
                new Point(Setting.CURSOR_WIDTH / 2, Setting.CURSOR_HEIGHT / 2), "img"));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.gameboardPanel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imgCursorNormal,
                new Point(Setting.CURSOR_WIDTH / 2, Setting.CURSOR_HEIGHT / 2), "img"));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.gameboardPanel.setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}

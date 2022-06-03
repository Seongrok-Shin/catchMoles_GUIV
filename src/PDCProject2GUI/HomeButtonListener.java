/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI;

import PDCProject1CUI.Gameboard;
import PDCProject2GUI.controller.GameSessionController;
import PDCProject2GUI.controller.TopPaneController;
import PDCProject2GUI.data.Database;
import PDCProject2GUI.view.HomePanel;
import PDCProject2GUI.view.TopPanel;
import java.awt.event.MouseEvent;
import java.util.Timer;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author ssr7324
 */
public class HomeButtonListener implements MouseInputListener {

    GameSessionController gms;

    public HomeButtonListener(Gameboard board, Database database) {
        gms = new GameSessionController(board, database);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();

        if (obj == TopPanel.homeButton) {
            JOptionPane.showMessageDialog(null, "Please click OK to back home");
            gms.gameStop();
            gms.timerStop();
            Program.jFrame.getContentPane().removeAll();
            Program.jFrame.getContentPane().add(new HomePanel());
            Program.jFrame.pack();
            Program.jFrame.setVisible(true);
            TopPaneController.numberOfLife = Setting.NUMBER_LIFE;
            TopPaneController.lifeLack = false;
            GameSessionController.nTime = Setting.TIMER;
            GameSessionController.timer = new Timer();
            GameSessionController.time = new Timer();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}

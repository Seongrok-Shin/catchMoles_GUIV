/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI.controller;

import PDCProject1CUI.Gameboard;
import PDCProject2GUI.Program;
import PDCProject2GUI.Setting;
import PDCProject2GUI.view.HomePanel;
import PDCProject2GUI.view.TopPanel;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author ssr7324
 */
public class TopPaneController {

    private final TopPanel topPanel;
    private final Gameboard board;
    private int numberOfLife;
    public static boolean lifeLack;
    private Timer timer;
    private int nTime;

    public TopPaneController(Gameboard board) {
        topPanel = new TopPanel();
        this.board = board;
        lifeLack = false;
        numberOfLife = Setting.NUMBER_LIFE;
        setLife(numberOfLife);
        timerStart();
        HomeButtonListener homeButtonListener = new HomeButtonListener();
    }

    private void setLife(int i) {
        if (i > 0 && i <= Setting.NUMBER_LIFE) {
            for (int j = 0; j < Setting.NUMBER_LIFE; j++) {
                TopPanel.lifeLabel[j].setVisible(false);
            }
            for (int j = 0; j < i; j++) {
                TopPanel.lifeLabel[j].setVisible(true);
            }
        } else if (i <= 0) {
            for (int j = 0; j < Setting.NUMBER_LIFE; j++) {
                TopPanel.lifeLabel[j].setVisible(false);
            }
            lifeLack = true;
            JOptionPane.showMessageDialog(null, "No Heart...");
        }
    }

    private void timerStart() {
        nTime = Setting.TIMER;
        timer = new Timer();
        timer.schedule(new GameTimerTask(), 0, 1000);
    }

    private void timerStop() {
        timer.cancel();
    }

    private class GameTimerTask extends TimerTask {

        @Override
        public void run() {
            nTime--;

            if (nTime <= 0) {
                timerStop();
                System.out.println(nTime);
            }
        }
    }

    private void setHomeButton() {
        timerStop();
        Program.jFrame.getContentPane().removeAll();
        Program.jFrame.getContentPane().add(new HomePanel());
        Program.jFrame.pack();
        Program.jFrame.setVisible(true);
    }

    public TopPanel getPanel() {
        return this.topPanel;
    }

    private class HomeButtonListener implements MouseInputListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            setHomeButton();
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
}

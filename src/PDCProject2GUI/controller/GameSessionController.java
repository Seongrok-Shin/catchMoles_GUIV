/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI.controller;

import PDCProject2GUI.MoleButtonListener;
import PDCProject2GUI.view.GameboardPanel;
import PDCProject1CUI.Gameboard;
import PDCProject1CUI.MoleState;
import PDCProject2GUI.MoleButtonInterface;
import PDCProject2GUI.Program;
import PDCProject2GUI.Setting;
import PDCProject2GUI.data.Database;
import PDCProject2GUI.view.HomePanel;
import PDCProject2GUI.view.TopPanel;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author ssr7324
 */
public class GameSessionController implements MoleButtonInterface {

    private final GameboardPanel panel;
    private final Gameboard board;
    public static Timer time;
    public static Timer timer;
    public static int nTime;
    private final MoleButtonListener moleButtonListener;
    private final Database database;

    public GameSessionController(Gameboard board, Database database) {
        timer = new Timer();
        time = new Timer();
        this.board = board;
        this.moleButtonListener = new MoleButtonListener(this);
        this.panel = new GameboardPanel(this.board, this.moleButtonListener);
        this.moleButtonListener.setPanel(panel);
        this.database = database;
    }

    private void saveScore(int score) {
        database.updateUserScore(Program.user, score);
    }

    public void gameStart() {
        BoardUpdateTask boardUpdateTask = new BoardUpdateTask(this.board, this.panel);
        time.schedule(boardUpdateTask, 0, Setting.REFRESH_RATE_MS);
    }

    public void gameStop() {
        time.cancel();
        time.purge();
    }

    public GameboardPanel getPanel() {
        return this.panel;
    }

    public void checkMissedMole() {
        for (int i = 0; i < board.getSize().getCol() * board.getSize().getRow(); i++) {
            if (board.getMoleAtIndex(i).getState() == MoleState.MISSED) {
                TopPaneController.numberOfLife--;
                TopPaneController.setLife(TopPaneController.numberOfLife);
                if (TopPaneController.numberOfLife == 0) {
                    JOptionPane.showMessageDialog(null, "No Heart...\n Please click OK to back home");
                    this.backToMain();
                }
            }
        }
    }

    public void timerStart() {
        nTime = Setting.TIMER;
        timer.schedule(new GameTimerTask(), 0, 1000);
    }

    public void timerStop() {
        timer.cancel();
        timer.purge();
    }

    public void backToMain() {
        gameStop();
        timerStop();
        Program.jFrame.getContentPane().removeAll();
        Program.jFrame.getContentPane().add(new HomePanel());
        Program.jFrame.pack();
        Program.jFrame.setVisible(true);
        TopPaneController.numberOfLife = Setting.NUMBER_LIFE;
        TopPaneController.lifeLack = false;
        nTime = Setting.TIMER;
        timer = new Timer();
        time = new Timer();
    }

    @Override
    public void didHitMoleAtIndex(int index) {

        if (board.getMoleAtIndex(index).getState() == MoleState.VISIBLE || board.getMoleAtIndex(index).getState() == MoleState.ALMOST_VISIBLE) {
            board.getMoleAtIndex(index).setState(MoleState.DEAD);
            TopPaneController.numberOfLife++;
            TopPaneController.setLife(TopPaneController.numberOfLife);
        } else {
            board.getMoleAtIndex(index).setState(MoleState.MISSED);
            if (board.getMoleAtIndex(index).getState() == MoleState.MISSED) {
                TopPaneController.numberOfLife--;
                TopPaneController.setLife(TopPaneController.numberOfLife);
                if (TopPaneController.numberOfLife == 0) {
                    JOptionPane.showMessageDialog(null, "No Heart...\n Please click OK to back home");
                    this.backToMain();
                }
            }
        }
        this.panel.setBoard(board);
    }

    private class BoardUpdateTask extends TimerTask {

        Gameboard board;
        GameboardPanel panel;

        public BoardUpdateTask(Gameboard board, GameboardPanel panel) {
            this.board = board;
            this.panel = panel;
        }

        @Override
        public void run() {
            this.board.nextMolesState();
            checkMissedMole();
            this.panel.setBoard(board);
        }
    }

    private class GameTimerTask extends TimerTask {

        @Override
        public void run() {
            TopPanel.timer.setForeground(Color.BLACK);
            TopPanel.timer.setText(nTime + "");
            nTime--;

            if (nTime < 5 && nTime >= 0) {
                TopPanel.timer.setForeground(Color.red);
            } else if (nTime < 0) {
                JOptionPane.showMessageDialog(null,
                        "Time Over...\n Please click OK to back home");
                backToMain();
            }
        }
    }
}

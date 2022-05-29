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
import PDCProject1CUI.UpdateBoardTask;
import PDCProject2GUI.MoleButtonInterface;
import PDCProject2GUI.Setting;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author ssr7324
 */
public class GameSessionController implements MoleButtonInterface{

    private final GameboardPanel panel;
    private final Gameboard board;
    private final Timer time = new Timer();
    private final MoleButtonListener moleButtonListener;

    public GameSessionController(Gameboard board) {
        this.board = board;
        this.moleButtonListener = new MoleButtonListener(this);
        this.panel = new GameboardPanel(this.board, this.moleButtonListener);
        this.moleButtonListener.setPanel(panel);
    }

    public void gameStart() {
        BoardUpdateTask boardUpdateTask = new BoardUpdateTask(this.board, this.panel);
        time.schedule(boardUpdateTask, 0, Setting.REFRESH_RATE_MS);
    }

    public GameboardPanel getPanel() {
        return this.panel;
    }

    @Override
    public void didHitMoleAtIndex(int index) {
        if(board.getMoleAtIndex(index).getState() == MoleState.VISIBLE || board.getMoleAtIndex(index).getState() == MoleState.ALMOST_VISIBLE){
            board.getMoleAtIndex(index).setState(MoleState.DEAD);
        } else{
            board.getMoleAtIndex(index).setState(MoleState.MISSED);
        }
        
        this.panel.setBoard(board);
    }

    public class BoardUpdateTask extends TimerTask {
        Gameboard board;
        GameboardPanel panel;
        
        public BoardUpdateTask(Gameboard board, GameboardPanel panel) {
            this.board = board;
            this.panel = panel;
        }

        @Override
        public void run() {
            this.board.nextMolesState();
            this.panel.setBoard(board);
        }
    }
}

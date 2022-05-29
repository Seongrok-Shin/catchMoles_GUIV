/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI.controller;

import PDCProject2GUI.MoleButtonListener;
import PDCProject2GUI.view.GameboardPanel;
import PDCProject1CUI.Gameboard;
import java.util.Timer;
import javax.swing.JFrame;

/**
 *
 * @author ssr7324
 */
public class GameSessionController {

    private final GameboardPanel panel;
    private final Gameboard board;
    private final Timer time = new Timer();
    private final MoleButtonListener moleButtonListener;
    
    public GameSessionController(Gameboard board) {
        this.board = board;
        this.moleButtonListener = new MoleButtonListener();
        this.panel = new GameboardPanel(this.board, this.moleButtonListener);
        this.moleButtonListener.setPanel(panel);
    }

    public void gameStart() {
    }
    
    public GameboardPanel getPanel(){
        return this.panel;
    }
}

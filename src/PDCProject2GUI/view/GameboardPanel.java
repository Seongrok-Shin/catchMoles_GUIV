/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI.view;

import PDCProject1CUI.Gameboard;
import PDCProject2GUI.MoleButtonListener;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author ssr7324
 */
public class GameboardPanel extends JPanel {
    private Gameboard gameboard;

    public GameboardPanel(Gameboard gameboard, MoleButtonListener moleButtonListener) {
        this.gameboard = gameboard;
        this.setPreferredSize(new Dimension(700, 700));
        this.setOpaque(false);
        this.setLayout(new GridLayout(this.gameboard.getSize().getCol(), this.gameboard.getSize().getRow()));

        for (int i = 0; i < this.gameboard.getSize().getCol() * this.gameboard.getSize().getRow(); i++) {
            MoleButton moleButton = new MoleButton(this.gameboard.getMoleAtIndex(i));
            moleButton.addMouseListener(moleButtonListener);
            this.add(moleButton);
        }
    }

    public void setBoard(Gameboard gameboard) {
        this.gameboard = gameboard;
        this.repaint();
    }
}

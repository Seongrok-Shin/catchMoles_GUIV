/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI;

import PDCProject1CUI.Gameboard;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            g.drawImage(ImageIO.read(new File("./img/bg_gamepanel.png")), 0, 0, null);
        } catch (IOException ex) {
            Logger.getLogger(GameboardPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}

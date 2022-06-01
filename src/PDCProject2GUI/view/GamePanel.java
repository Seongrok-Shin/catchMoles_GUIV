/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI.view;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * @author ssr7324
 */
public class GamePanel extends JPanel {

    GameboardPanel molePanel;

    public GamePanel() {
        this.setPreferredSize(new Dimension(700, 700));
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        this.add(molePanel);
    }
}

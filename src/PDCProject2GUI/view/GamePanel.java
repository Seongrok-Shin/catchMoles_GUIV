/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI.view;

import PDCProject1CUI.Gameboard;
import PDCProject1CUI.Size;
import PDCProject2GUI.controller.GameSessionController;
import PDCProject2GUI.controller.TopPaneController;
import PDCProject2GUI.data.Database;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author ssr7324
 */
public class GamePanel extends JPanel {

    private GameSessionController gameSessionController;
    private TopPaneController topPaneController;
    
    public GamePanel() {
        gameSessionController = new GameSessionController(new Gameboard(new Size(3, 3)), new Database());
        topPaneController = new TopPaneController(new Gameboard(new Size(3, 3)), new Database());
        this.setPreferredSize(new Dimension(700, 700));
        this.setOpaque(false);
        this.setLayout(null);

        this.gameSessionController.getPanel().setBounds(0, 100, 700, 600);
        this.add(gameSessionController.getPanel());
        this.topPaneController.getPanel().setBounds(0, 0, 700, 100);
        this.add(topPaneController.getPanel());
        this.gameSessionController.gameStart();
        this.gameSessionController.timerStart();
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

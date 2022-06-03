/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI.controller;

import PDCProject1CUI.Gameboard;
import PDCProject2GUI.Setting;
import PDCProject2GUI.data.Database;
import PDCProject2GUI.view.TopPanel;

/**
 *
 * @author ssr7324
 */
public class TopPaneController {

    private final TopPanel topPanel;
    private final Gameboard board;
    public static int numberOfLife;
    public static boolean lifeLack;
    private Database database;
    
    public TopPaneController(Gameboard board, Database database) {
        this.board = board;
        this.database = database;
        topPanel = new TopPanel(this.board, this.database);
        lifeLack = false;
        numberOfLife = Setting.NUMBER_LIFE;
        setLife(numberOfLife);
    }

    public static void setLife(int i) {
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
        }
    }

    public TopPanel getPanel() {
        return this.topPanel;
    }
}

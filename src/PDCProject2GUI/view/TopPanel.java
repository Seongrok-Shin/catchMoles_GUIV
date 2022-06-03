/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI.view;

import PDCProject1CUI.Gameboard;
import PDCProject2GUI.HomeButtonListener;
import PDCProject2GUI.Setting;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author ssr7324
 */
public class TopPanel extends JPanel {

    public static JLabel[] lifeLabel;
    public static JLabel timerLabel;
    public static JLabel timer;
    public static JButton homeButton;
    public Gameboard board;
    public TopPanel(Gameboard board) {
        this.setPreferredSize(new Dimension(700, 700));
        this.setOpaque(false);
        this.setLayout(null);

        this.board = board;
        setLifePanel();
        setMenuPanel();
        setTimerPanel();
        
        repaint();
    }

    public void setLifePanel() {
        ImageIcon imgLife = new ImageIcon("./img/life.png");

        lifeLabel = new JLabel[Setting.NUMBER_LIFE];

        for (int i = 0; i < Setting.NUMBER_LIFE; i++) {
            lifeLabel[i] = new JLabel("", imgLife, SwingConstants.CENTER);
            lifeLabel[i].setBounds((i * 50), 15, 32, 32);
            lifeLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            lifeLabel[i].setVerticalAlignment(SwingConstants.CENTER);
            this.add(lifeLabel[i]);
        }
    }

    public void setTimerPanel() {
        ImageIcon imgTimer = new ImageIcon("./img/timer.png");

        timerLabel = new JLabel("60", imgTimer, SwingConstants.CENTER);
        timerLabel.setBounds(325, 0, 50, 50);

        timer = new JLabel("60", SwingConstants.CENTER);
        timer.setBounds(325, 40, 50, 50);
        timer.setFont(new Font("Times New Roman", Font.BOLD, 32));
        this.add(timerLabel);
        this.add(timer);
    }

    public void setMenuPanel() {
        HomeButtonListener homeButtonListener = new HomeButtonListener(board);
        ImageIcon imgHome = new ImageIcon("./img/home.png");
        homeButton = new JButton();
        homeButton.setBounds(630, 5, 64, 64);
        homeButton.setIcon(imgHome);
        homeButton.setOpaque(false);
        homeButton.setBackground(new Color(255, 0, 0, 0));
        homeButton.setBorderPainted(false);
        homeButton.setMargin(new Insets(3, 3, 3, 3));
        homeButton.addMouseListener(homeButtonListener);
        this.add(homeButton);
    }
}

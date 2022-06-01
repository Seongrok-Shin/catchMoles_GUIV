/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI.view;

import PDCProject2GUI.Setting;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 *
 * @author ssr7324
 */
public class TopPanel extends JPanel {

    public static JLabel[] lifeLabel;
    public static JLabel timerLabel;
    public static JLabel timer;
    
    public TopPanel() {
        this.setPreferredSize(new Dimension(700, 700));
        this.setOpaque(false);
        this.setLayout(null);

        setLifePanel();
        setTimerPanel();
        setMenuPanel();
        this.repaint();
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

        timerLabel = new JLabel("", imgTimer, SwingConstants.CENTER);
        timerLabel.setBounds(325, 0, 50, 50);
        
        timer = new JLabel("60", SwingConstants.CENTER);
        timer.setBounds(380, 0, 50,50);
        this.setBorder(BorderFactory.createTitledBorder(null, "TIME", TitledBorder.CENTER,TitledBorder.TOP));
        this.add(timerLabel);
    }

    public void setMenuPanel() {
        ImageIcon imgHome = new ImageIcon("./img/home.png");
        timerLabel = new JLabel("", imgHome, SwingConstants.CENTER);
        timerLabel.setBounds(630, 5, 64, 64);
        this.add(timerLabel);
    }
}

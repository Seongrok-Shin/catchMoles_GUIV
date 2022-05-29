/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author OEM
 */
public class ScorePanel extends JPanel {

    private final JLabel titleLabel;

    public ScorePanel() {

        setPreferredSize(new Dimension(700, 700));
        setBackground(Color.white);
        setLayout(null);

        titleLabel = new JLabel("Set Title", SwingConstants.CENTER);
        titleLabel.setBounds(300, 300, 300, 60);
        
        add(titleLabel);

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchMoles;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author ssr7324
 */
public class homePanel extends JPanel {

    private JLabel titleLabel;
    private JLabel[] menuLabels;

    public homePanel() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.white);
        setLayout(null);
        //Set title later.
        titleLabel = new JLabel("Set Title", SwingConstants.CENTER);
        titleLabel.setBounds(300, 30, 300, 60);
        
        /* CREATE SETTING MENU
        menuLabels = new JLabel[THIS IS CHOSEN MENU NUMBER
        MAY 0 TO 5];
         */
        
        
    }
}

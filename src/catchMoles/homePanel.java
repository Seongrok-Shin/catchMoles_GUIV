/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchMoles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author ssr7324
 */
public class HomePanel extends JPanel {

    private JLabel titleLabel;
    private JLabel[] menuLabels;
    private homeListener homeListener1;
    private Image backgroundImg;

    public HomePanel() {

        setPreferredSize(new Dimension(700, 700));
        setBackground(Color.white);
        setLayout(null);

        try {
            backgroundImg = ImageIO.read(new File("./img/backgroud_game.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Cannot load the image");
            System.exit(0);
        }
        backGroundImg();

        //Set title later.
        titleLabel = new JLabel("Set Title", SwingConstants.CENTER);
        titleLabel.setBounds(300, 30, 300, 60);

        menuLabels = new JLabel[Setting.CHOSEN_MENU_NUMBER];
        for (int i = 0; i < Setting.CHOSEN_MENU_NUMBER; i++) {
            menuLabels[i] = new JLabel(Setting.MENU[i]);
            menuLabels[i].setBounds(580, 190 + (i * 60), 180, 50);
            menuLabels[i].addMouseListener(homeListener1);
            add(menuLabels[i]);
        }
    }

    private void backGroundImg() {
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImg));
        add(backgroundLabel);
    }

    private class homeListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
}

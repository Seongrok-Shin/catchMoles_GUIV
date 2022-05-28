/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchMoles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.imageio.ImageIO;
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

        //Set title later.
        titleLabel = new JLabel("Set Title", SwingConstants.CENTER);
        titleLabel.setBounds(300, 30, 300, 60);

        menuLabels = new JLabel[Setting.CHOSEN_MENU_NUMBER];
        for (int i = 0; i < Setting.CHOSEN_MENU_NUMBER; i++) {
            menuLabels[i] = new JLabel(Setting.MENU[i]);
            menuLabels[i].setBounds(320, 350 + (i * 60), 180, 50);
            menuLabels[i].addMouseListener(homeListener1);
            add(menuLabels[i]);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImg, 0, 0, null);
    }

    private class homeListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            Object obj = e.getSource();

            for (int i = 0; i < Setting.CHOSEN_MENU_NUMBER; i++) {

                if (obj == menuLabels[i]) {
                    switch (i) {
                        case Setting.START:
                            Program.jFrame.getContentPane().removeAll();
                            //add game panel Program.jFrame.getContentPane().add(); 
                            Program.jFrame.pack();
                            Program.jFrame.setVisible(true);
                            break;
                        case Setting.SCOREBOARD:
                            Program.jFrame.getContentPane().removeAll();
                            //add score panel Program.jFrame.getContentPane().add();
                            Program.jFrame.pack();
                            Program.jFrame.setVisible(true);
                            break;
                        case Setting.TUTORIAL:
                            Program.jFrame.getContentPane().removeAll();
                            //add Tutorial panel Program.jFrame.getContentPane().add();
                            Program.jFrame.pack();
                            Program.jFrame.setVisible(true);
                            break;
                        case Setting.EXIT:
                            //To show options
                            // if(option == option panel with yes/ System.exit(0);
                            break;
                        default:
                            break;
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            Object obj = e.getSource();

            for (int i = 0; i < Setting.CHOSEN_MENU_NUMBER; i++) {
                if (obj == menuLabels[i]) {
                    switch (i) {
                        case Setting.START:
                            menuLabels[i].setForeground(Setting.ENTER_HEAD);
                            break;
                        case Setting.SCOREBOARD:
                            menuLabels[i].setForeground(Setting.ENTER_HEAD);
                            break;
                        case Setting.TUTORIAL:
                            menuLabels[i].setForeground(Setting.ENTER_HEAD);
                            break;
                        case Setting.EXIT:
                            menuLabels[i].setForeground(Setting.ENTER_HEAD);
                            break;
                        default:
                            break;
                    }

                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            Object obj = e.getSource();

            for (int i = 0; i < Setting.CHOSEN_MENU_NUMBER; i++) {
                if (obj == menuLabels[i]) {
                    switch (i) {
                        case Setting.START:
                            menuLabels[i].setForeground(Setting.EXIT_HEAD);
                            break;
                        case Setting.SCOREBOARD:
                            menuLabels[i].setForeground(Setting.EXIT_HEAD);
                            break;
                        case Setting.TUTORIAL:
                            menuLabels[i].setForeground(Setting.EXIT_HEAD);
                            break;
                        case Setting.EXIT:
                            menuLabels[i].setForeground(Setting.EXIT_HEAD);
                            break;
                        default:
                            break;
                    }
                }

            }
        }
    }
}

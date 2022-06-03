package PDCProject2GUI.view;

import PDCProject2GUI.Program;
import PDCProject2GUI.Setting;
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


public class HomePanel extends JPanel {

    private JLabel titleLabel;
    private JLabel[] menuLabels;
    private HomeListener homeListener;
    private Image backgroundImg;

    public HomePanel() {
        setPreferredSize(new Dimension(700, 700));
        setBackground(Color.white);
        setLayout(null);

        homeListener = new HomeListener();

        try {
            backgroundImg = ImageIO.read(new File("./img/backgroud_home.png"));
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
            menuLabels[i].addMouseListener(homeListener);
            add(menuLabels[i]);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImg, 0, 0, null);
    }

    private class HomeListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            Object obj = e.getSource();
            System.out.println("Clicked");
            for (int i = 0; i < Setting.CHOSEN_MENU_NUMBER; i++) {
                System.out.println(menuLabels[i]);
                if (obj == menuLabels[i]) {
                    switch (i) {
                        case Setting.START:
                            GamePanel gamePanel = new GamePanel();
                            Program.jFrame.getContentPane().removeAll();
                            //add game panel Program.jFrame.getContentPane().add(); 
                            Program.jFrame.getContentPane().add(gamePanel);
                            Program.jFrame.pack();
                            Program.jFrame.setVisible(true);
                            break;
                        case Setting.SCOREBOARD:
                            Program.jFrame.getContentPane().removeAll();
                            Program.jFrame.getContentPane().add(Program.scorePanel);
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
                            System.exit(0);
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

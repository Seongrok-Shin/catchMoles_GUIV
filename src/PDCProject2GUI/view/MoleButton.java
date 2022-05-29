/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI.view;

import PDCProject1CUI.Mole;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author ssr7324
 */
public class MoleButton extends JButton {

    private Mole mole;

    public MoleButton(Mole mole) {
        super();
        this.setOpaque(false);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.mole = mole;
    }

    public Mole getMole() {
        return this.mole;
    }

    public void setMole(Mole mole) {
        this.mole = mole;
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch (mole.getState()) {
            case INVISIBLE:
                g.drawImage(new ImageIcon("./img/invisible.png").getImage(), 20, 0, this);
                break;
            case SLIGHTLY_VISIBLE:
                g.drawImage(new ImageIcon("./img/slightly_visible.png").getImage(), 20, 0, this);
                break;
            case ALMOST_VISIBLE:
                g.drawImage(new ImageIcon("./img/almost_visible.png").getImage(), 20, 0, this);
                break;
            case VISIBLE:
                g.drawImage(new ImageIcon("./img/visible.png").getImage(), 20, 0, this);
                break;
            case DEAD:
                g.drawImage(new ImageIcon("./img/dead.png").getImage(), 20, 0, this);
                break;
            case MISSED:
                g.drawImage(new ImageIcon("./img/missed.png").getImage(), 20, 0, this);
                break;
        }
    }
}

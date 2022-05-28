/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchMoles;

import javax.swing.JFrame;

/**
 *
 * @author ssr7324
 */
public class Program {
    public static JFrame jFrame;
    
    public static void main(String[] args) {
        jFrame = new JFrame("Catch Moles Game");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jFrame.getContentPane().add(new HomePanel());
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setResizable(false);
    }
}

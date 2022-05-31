/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI.view;

import PDCProject1CUI.Score;
import PDCProject2GUI.controller.ScoreController;
import PDCProject2GUI.data.UserScoreManager;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author OEM
 */
public class ScorePanel extends JPanel {

    private final JLabel titleLabel;
    private final ScoreController scoreController;

    public ScorePanel(ScoreController scoreController) {
        
        setPreferredSize(new Dimension(700, 700));
        setBackground(Color.white);
        setLayout(null);
        
        this.scoreController = scoreController;
        
        List<Score> scores = scoreController.getScores();
       
        String scoreText = "";
        
        for(int i = 0; scores.size() >= i; i++){
           scoreText += scores.get(i) + "\n";
            
        }
       

        titleLabel = new JLabel(scoreText, SwingConstants.CENTER);
        titleLabel.setBounds(300, 30, 150, 60);
        
        add(titleLabel);

    }
}

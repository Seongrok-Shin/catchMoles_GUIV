package PDCProject2GUI.view;

import PDCProject1CUI.Score;
import PDCProject2GUI.controller.ScoreController;
import PDCProject2GUI.data.ScoreModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScorePanel extends JPanel implements Observer {

    private final JLabel titleLabel;
    private final ScoreController scoreController;

    public ScorePanel(ScoreController scoreController) {

        setPreferredSize(new Dimension(700, 700));
        setBackground(Color.white);
        setLayout(null);

        this.scoreController = scoreController;
        List<Score> scores = scoreController.getScores();
        String scoreText = "";
        for (int i = 0; i < scores.size(); i++) {
            scoreText += scores.get(i) + "\n";
        }
        titleLabel = new JLabel(scoreText, SwingConstants.CENTER);
        titleLabel.setBounds(300, 30, 150, 60);
        add(titleLabel);
    }

    @Override
    public void update(Observable o, Object arg) {
        ScoreModel scoreModel = (ScoreModel) arg;
        //UI stuff
    }

    void setupData() {

        scoreController.setupData();

    }
}

package PDCProject2GUI.view;

import PDCProject1CUI.Score;
import PDCProject1CUI.User;
import PDCProject2GUI.Program;
import PDCProject2GUI.controller.ScoreController;
import PDCProject2GUI.data.ScoreModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class ScorePanel extends JPanel implements Observer {

    private final ScoreController scoreController;
    private final JTextPane  scoreTextArea;

    public ScorePanel(ScoreController scoreController) {

        setPreferredSize(new Dimension(700, 700));
        setBackground(Color.white);
        setLayout(null);

        this.scoreController = scoreController;

        this.scoreTextArea = new JTextPane ();
        scoreTextArea.setForeground(Color.blue);
        scoreTextArea.setBounds(300, 200, 300, 700);
        add(scoreTextArea);
    }

    @Override
    public void update(Observable o, Object arg) {
        ScoreModel scoreModel = (ScoreModel) arg;
    }

    void setupData() {

        Map<User, Score> scores = scoreController.getScores();
        scoreTextArea.setText("Username\tScore\n");
        scores.forEach((user, score) -> {
            String line = user.getUserName() + "\t" + score.getScore() + "\n";
            scoreTextArea.setText(scoreTextArea.getText() + line);
        });
    }
}

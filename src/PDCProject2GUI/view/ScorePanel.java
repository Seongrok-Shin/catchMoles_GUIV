package PDCProject2GUI.view;

import PDCProject1CUI.Score;
import PDCProject1CUI.User;
import PDCProject2GUI.controller.ScoreController;
import PDCProject2GUI.data.ScoreModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ScorePanel extends JPanel implements Observer {

    private final ScoreController scoreController;
    private final JTextPane scoreTextArea;
    private Image imgScoreboard;

    public ScorePanel(ScoreController scoreController) {

        setPreferredSize(new Dimension(700, 700));
        setLayout(null);

        try {
            imgScoreboard = ImageIO.read(new File("./img/bg_scoreboard1.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Cannot load the image");
            System.exit(0);
        }
        this.scoreController = scoreController;

        this.scoreTextArea = new JTextPane();
        scoreTextArea.setForeground(Color.WHITE);
        scoreTextArea.setFont(new Font("Segoe UI", Font.BOLD, 16));
        scoreTextArea.setBounds(300, 200, 300, 700);
        scoreTextArea.setOpaque(false);
        scoreTextArea.setBackground(new Color(0, 0, 0, 0));
        add(scoreTextArea);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imgScoreboard, 0, 0, null);
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

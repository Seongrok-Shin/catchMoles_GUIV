package PDCProject2GUI.view;

import PDCProject1CUI.Gameboard;
import PDCProject1CUI.Score;
import PDCProject1CUI.Size;
import PDCProject1CUI.User;
import PDCProject2GUI.Program;
import PDCProject2GUI.Setting;
import PDCProject2GUI.controller.ScoreController;
import PDCProject2GUI.controller.TopPaneController;
import PDCProject2GUI.data.ScoreModel;
import com.sun.scenario.Settings;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ScorePanel extends JPanel implements Observer {

    private final ScoreController scoreController;
    private Image imgScoreboard;
    private static final Comparator<Map.Entry<User, Score>> ascendingScoreOrderComparator
            = (s1, s2) -> Integer.compare(s1.getValue().getScore(), s2.getValue().getScore());
    private static final Comparator<Map.Entry<User, Score>> descendingScoreOrderComparator
            = Collections.reverseOrder(ascendingScoreOrderComparator);
    private final JPanel scoreTable;
    private final TopPaneController topPaneController;
    
    
    

    public ScorePanel(ScoreController scoreController) {
        
        setPreferredSize(new Dimension(700, 700));
        setLayout(null);

        topPaneController = new TopPaneController(new Gameboard(new Size(3, 3)), Program.database);
        this.topPaneController.getPanel().setBounds(0, 0, 700, 100);
        
        topPaneController.setGameVariableHidden(true);
        this.add(topPaneController.getPanel());

        try {
            imgScoreboard = ImageIO.read(new File("./img/bg_scoreboard1.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Cannot load the image");
            System.exit(0);
        }
        this.scoreController = scoreController;

        scoreTable = new JPanel();
        scoreTable.setBackground(new Color(0, 0, 0, 0));
        scoreTable.setLayout(new GridLayout(0, 2));
        int width = 200;
        int height = 200;
        int left = (int) (Setting.WIDTH / 2 - (width / 2));
        int top = (int) (Setting.HEIGHT / 2 - (height / 2));

        scoreTable.setSize(width, height);
        scoreTable.setBounds(left, top, width, height);
        add(scoreTable, BorderLayout.CENTER);
    }

    private static JTextPane createLabel(String text) {
        JTextPane textPane = new JTextPane();
        textPane.setForeground(Color.WHITE);
        textPane.setFont(new Font("Segoe UI", Font.BOLD, 16));
        textPane.setBounds(300, 200, 300, 700);
        textPane.setOpaque(false);
        textPane.setBackground(new Color(0, 0, 0, 0));
        textPane.setText(text);
        return textPane;
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

        Map<User, Score> userScores = scoreController.getScores();
        List<Map.Entry<User, Score>> sortedScores = new ArrayList<>(userScores.entrySet());
        sortedScores.sort(descendingScoreOrderComparator);

        for (Map.Entry<User, Score> userScore : sortedScores) {
            User user = userScore.getKey();
            Score score = userScore.getValue();
            JTextPane usernameLabel = createLabel(user.getUserName());
            JTextPane scoreLabel = createLabel(String.valueOf(score.getScore()));
            scoreTable.add(usernameLabel);
            scoreTable.add(scoreLabel);
        }

        scoreTable.repaint();
    }
}

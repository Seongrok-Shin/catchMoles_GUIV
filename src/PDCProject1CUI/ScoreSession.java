/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject1CUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ssr7324
 */
public class ScoreSession {

    private static final Comparator<Map.Entry<User, Score>> ascendingScoreOrderComparator
            = (s1, s2) -> Integer.compare(s1.getValue().getScore(), s2.getValue().getScore());
    private static final Comparator<Map.Entry<User, Score>> descendingScoreOrderComparator 
            = Collections.reverseOrder(ascendingScoreOrderComparator);

    public ScoreSession() {
    }

    public static void main(String[] args) {
        // For testing
        ScoreSession scoreSession = new ScoreSession();
        Map<User, Score> userScores = new HashMap<>();
        userScores.put(new User("RockSong"), new Score(40000));
        userScores.put(new User("dojiyoung"), new Score(800000));
        userScores.put(new User("cheezesticks"), new Score(100));
        userScores.put(new User("KimJongUn"), new Score(10));
        userScores.put(new User("HanulRheem"), new Score(400));
        userScores.put(new User("daoonnee"), new Score(100));

        scoreSession.showScoreboard(userScores);
    }

    public void showScoreboard(Map<User, Score> userScores) {
        List<Map.Entry<User, Score>> sortedScores = new ArrayList<>(userScores.entrySet());
        sortedScores.sort(descendingScoreOrderComparator);

        String cellTextFormat = "| %-15s | %-15d |%n";

        System.out.format("+-----------------+-----------------+%n");
        System.out.format("| User            | High score      |%n");
        System.out.format("+-----------------+-----------------+%n");

        for (Map.Entry<User, Score> userScore : sortedScores) {
            User user = userScore.getKey();
            Score score = userScore.getValue();
            System.out.format(cellTextFormat, user.getUserName(), score.getScore());
        }

        System.out.format("+-----------------+-----------------+%n");
    }
}

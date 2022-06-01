package PDCProject2GUI.data;

import PDCProject1CUI.Score;
import PDCProject1CUI.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Optional;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ScoreModel extends Observable {

    private Map<User, Score> userScores;
    private final File file;
    private String filePath;
    public static Connection conn;
    public static String url = "jdbc:derby://localhost:1527/mole";
    public static String username = "shh9902";
    public static String password = "9902";
    private final Database db;

    public ScoreModel(Database db) {
        this.db = db;
        //establishMySQLConnection();
        this.filePath = "./resources/Scoreboard.txt";
        this.userScores = new HashMap();
        this.file = new File(filePath);

//        try {
//            boolean isCreated = file.createNewFile();
//            if (isCreated) {
//                System.out.println("The new file is created.");
//            } else {
//                readScoresFromFile();
//            }
//        } catch (IOException e) {
//            System.err.println("Failed to create a Score Board at " + this.filePath + e.toString());
//            System.exit(1);
//        }
    }

    public void updateUserScore(User user, Score score) {
        this.userScores.put(user, score);
        writeScoresToFile();
    }

    public Score getScoreForUser(User user) {
        return this.userScores.get(user);
    }

    public Map<User, Score> getUserScores() {
        return this.userScores;
    }

    private void writeScoresToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.file);

            try (PrintWriter pw = new PrintWriter(fileOutputStream)) {
                userScores.entrySet().forEach(entry -> {
                    pw.println(entry.getValue().getScore() + " " + entry.getKey().getUserName());
                });
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void readScoresFromFile() {

        try (FileInputStream fileInputStream = new FileInputStream(this.file)) {

            Scanner fileScan = new Scanner(fileInputStream);

            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                StringTokenizer st = new StringTokenizer(line);
                Score score = new Score(Integer.parseInt(st.nextToken()));
                User user = new User(st.nextToken());
                this.userScores.put(user, score);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void establishMySQLConnection() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(url + " connected...");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    public void setupData() {

        this.userScores = db.getUserScores();
        this.setChanged(); // Essential. To mark this observable instance has been modified.
        this.notifyObservers(this);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject1CUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ssr7324
 */
public class UserScoreManager {

    private final Map<User, Score> userScores;
    private final File file;
    private String filePath;
    
    public UserScoreManager() {
        this.filePath = "./resources/Scoreboard.txt";
        this.userScores = new HashMap();
        this.file = new File(filePath);

        try {
            boolean isCreated = file.createNewFile();
            if (isCreated) {
                System.out.println("The new file is created.");
            } else{
                readScoresFromFile();
            }
        } catch (IOException e) {
            System.err.println("Failed to create a Score Board at " + this.filePath);
            System.exit(1);
        }
    }

    public void updateUserScore(User user, Score score) {
        this.userScores.put(user, score);
        writeScoresToFile();
    }
    
    public Score getScoreForUser(User user){
        return this.userScores.get(user);
    }
    
    public Map<User, Score> getUserScores(){
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

        try (FileInputStream fileInputStream = new FileInputStream(this.file)){
            
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
}

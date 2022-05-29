/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject2GUI;

import PDCProject1CUI.*;
import java.util.Scanner;
import java.util.Timer;

/**
 *
 * @author ssr7324
 */
public class GameSession {

    private final Gameboard gameboard;
    private final Scanner scanner;
    private final Score score = new Score();
    private final Timer time = new Timer();
    private final UserScoreManager userScoreManager = new UserScoreManager();

    public GameSession(Gameboard gameboard, Scanner scanner) {
        this.gameboard = gameboard;
        this.scanner = scanner;
    }

    public void gameStart() {

        PrintGameTask printGameTask = new PrintGameTask(gameboard);
        UpdateBoardTask updateBoardTask = new UpdateBoardTask(gameboard);

        time.schedule(printGameTask, 100, 2000);
        time.schedule(updateBoardTask, 0, 2001);
        while (true) {
            boolean isValidIndex = false;
            String inputFromUser = null;
            int indexFromUser = -1;
            do {
                inputFromUser = scanner.nextLine();
                if ("q".equalsIgnoreCase(inputFromUser)) {
                    time.cancel();
                    System.out.println("Please enter your name: ");
                    String inputUserName = scanner.nextLine();
                    User userName = new User(inputUserName);

                    if (userScoreManager.getScoreForUser(userName) != null) {
                        int previousScore = userScoreManager.getScoreForUser(userName).getScore();

                        if (previousScore < score.getScore()) {
                            userScoreManager.updateUserScore(userName, score);
                            System.out.println("You reached High Score!");
                        } else {
                            System.out.println("Could not beat high score :P");
                            System.out.println((previousScore - score.getScore()) + " More to go");
                        }
                    } else {
                        userScoreManager.updateUserScore(userName, score);
                    }

                    System.out.println("Score: " + score.getScore());
                    System.exit(0);
                } else {
                    try {
                        indexFromUser = Integer.parseInt(inputFromUser);

                        if (indexFromUser < 1 || 9 < indexFromUser) {
                            System.out.println(" Invalid Input ! ! ! ");
                        } else {
                            isValidIndex = true;

                        }
                    } catch (NumberFormatException e) {

                        System.out.println("Please enter 'q' for quit anytime or "
                                + "a number between 1 and 9!");
                    }
                }
            } while (!isValidIndex);

            if (gameboard.isMoleVisibleAtIndex(indexFromUser - 1) == true) {
                score.setScore(score.getScore() + 10);
                System.out.println("Hit!" + ", Score: " + score.getScore());
            }
        }
    }
}

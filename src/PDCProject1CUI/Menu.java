/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject1CUI;

import java.util.Scanner;

/**
 *
 * @author ssr7324
 */
public class Menu {

    private final Scanner scanner;
    private final GameSession gameSession;
    private String inputFromUser;
    private boolean isValid;
    private final ScoreSession scoreSession;

    public Menu(GameSession gameSession, ScoreSession scoreSession, Scanner scanner) {
        this.gameSession = gameSession;
        this.scanner = scanner;
        this.scoreSession = scoreSession;
    }

    public void showMenuOption() {
        System.out.println("1. Play Game (Press 'P')");
        System.out.println("2. Score Board (Press 'S')");
        System.out.println("3. Quit the program anytime (Press 'Q')");
    }

    public void showMenu() {
        isValid = true;
        UserScoreManager userScoreManager = new UserScoreManager();
        userScoreManager.getUserScores();
       
        showMenuOption();

        do {
            inputFromUser = scanner.nextLine();

            if ("P".equalsIgnoreCase(inputFromUser)) {
                gameSession.gameStart();
            } else if ("S".equalsIgnoreCase(inputFromUser)) {
                scoreSession.showScoreboard(userScoreManager.getUserScores());
                System.out.println("Press 'B' for back to Menu.");
            } else if ("Q".equalsIgnoreCase(inputFromUser)) {
                System.out.println("Quits the program." + "\n Good Bye!" );
                isValid = false;
            } else if ("B".equalsIgnoreCase(inputFromUser)) {
                this.showMenuOption();
            }
        } while (isValid);
        {
            System.exit(0);
        }
    }
}

package PDCProject2GUI;

import PDCProject1CUI.User;
import PDCProject2GUI.controller.LoginController;
import PDCProject2GUI.controller.ScoreController;
import PDCProject2GUI.data.LoginModel;
import PDCProject2GUI.data.Database;
import PDCProject2GUI.data.ScoreModel;
import PDCProject2GUI.view.HomePanel;
import PDCProject2GUI.view.LoginPanel;
import PDCProject2GUI.view.ScorePanel;
import java.sql.SQLException;
import javax.swing.JFrame;

public class Program {

    public static JFrame jFrame;
    public static LoginPanel loginPanel;
    public static HomePanel homePanel;
    public static ScorePanel scorePanel;
    public static User user;
    public static Database database;

    public static void main(String[] args) throws SQLException {
        jFrame = new JFrame("Catch Moles Game");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null); // Make the frame located at the absolute center of the screen.

        //database 
        database = new Database();

        //login
        loginPanel = new LoginPanel();
        LoginModel loginModel = new LoginModel(database);
        LoginController loginController = new LoginController(loginPanel, loginModel);
        loginModel.addObserver(loginPanel);

        //scorepanel, scorecontroller, scoremodel
        ScoreModel scoreModel = new ScoreModel(database);
        ScoreController scoreController = new ScoreController(scorePanel, scoreModel);
        scorePanel = new ScorePanel(scoreController);
        scoreModel.addObserver(scorePanel);

        homePanel = new HomePanel(); // loginview first or homepanel first

        jFrame.getContentPane().add(loginPanel);
        
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setResizable(false);
    }
}

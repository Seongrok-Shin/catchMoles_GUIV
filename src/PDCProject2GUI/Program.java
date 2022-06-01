
package PDCProject2GUI;

import PDCProject2GUI.controller.LoginController;
import PDCProject2GUI.controller.ScoreController;
import PDCProject2GUI.data.Data;
import PDCProject2GUI.data.LoginModel;
import PDCProject2GUI.data.Database;
import PDCProject2GUI.data.ScoreModel;
//import PDCProject2GUI.data.UserScoreManager;
import PDCProject2GUI.view.HomePanel;
import PDCProject2GUI.view.LoginPanel;
import PDCProject2GUI.view.ScorePanel;
import java.awt.PopupMenu;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Program {
    
    static boolean showloginfirst = true;// loginview first or homepanel first

    public static JFrame jFrame;
    public static LoginPanel loginPanel;
    public static HomePanel homePanel;
    public static ScorePanel scorePanel;

    public static void main(String[] args) throws SQLException {
        jFrame = new JFrame("Catch Moles Game");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null); // Make the frame located at the absolute center of the screen.
        
        //database 
        Database db = new Database();
        db.dbsetup();
        
        
        //login
        loginPanel = new LoginPanel(); 
        LoginModel loginModel = new LoginModel(db);
        LoginController loginController = new LoginController(loginPanel, loginModel);
        loginModel.addObserver(loginPanel);
        
        //scorepanel, scorecontroller, scoremodel
        scorePanel = new ScorePanel(); 
        ScoreModel scoreModel = new ScoreModel(db);
        ScoreController scoreController = new ScoreController(scorePanel, scoreModel);
        scoreModel.addObserver(scorePanel);
        

        homePanel = new HomePanel(); // loginview first or homepanel first
        if(showloginfirst){
            jFrame.getContentPane().add(loginPanel);
        }else {
            jFrame.getContentPane().add(homePanel); 
        }
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        
        

        //new UserScoreManager();
    }
}

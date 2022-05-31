
package PDCProject2GUI;

import PDCProject2GUI.controller.LoginController;
import PDCProject2GUI.controller.LoginModel;
import PDCProject2GUI.data.UserScoreManager;
import PDCProject2GUI.view.HomePanel;
import PDCProject2GUI.view.LoginPanel;
import java.awt.PopupMenu;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Program {
    
    static boolean showloginfirst = true;// loginview first or homepanel first

    public static JFrame jFrame;
    public static LoginPanel loginPanel;
    public static HomePanel homePanel;

    public static void main(String[] args) {
        jFrame = new JFrame("Catch Moles Game");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null); // Make the frame located at the absolute center of the screen.


        loginPanel = new LoginPanel(); 
        LoginModel loginModel = new LoginModel();
        LoginController loginController = new LoginController(loginPanel, loginModel);
        loginModel.addObserver(loginPanel);

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

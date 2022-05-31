
package PDCProject2GUI.controller;

import PDCProject2GUI.view.LoginPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class LoginController implements ActionListener {
    
    public LoginPanel loginpanel;
    public LoginModel loginmodel;
    
    public LoginController(LoginPanel loginpanel, LoginModel loginmodel) {
        this.loginpanel = loginpanel;
        this.loginmodel = loginmodel;
        this.loginpanel.addActionListener(this); 

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); 
        // Obtain the text displayed on the component.
        switch (command) {
            case "Log in": // Login button
                String username = this.loginpanel.unInput.getText(); // Obtain username.
            
                String password = this.loginpanel.pwInput.getText(); // Obtain password.
                System.out.printf("checking username %s and password %s against model",username ,password);
                //this.loginmodel.checkName(username, password); // Pass above variables to model. 
                break;
            case "Quit":
                // Quit button
                this.loginmodel.quitGame(); // Record user's current score.
                break;
            default:
                break;

        }
}
}



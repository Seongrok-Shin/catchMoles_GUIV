
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
        this.loginpanel.addActionListener(this); //This able to connect loginPanel and controller

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Log in": // Login button
                String username = this.loginpanel.unInput.getText(); // Obtain username
                String password = this.loginpanel.pwInput.getText(); // Obtain password
                System.out.printf("checking username %s and password %s against model",username ,password);
                this.loginmodel.checkName(username, password); // Pass input to model
                break;
        }
}
}



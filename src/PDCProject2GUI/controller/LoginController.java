package PDCProject2GUI.controller;

import PDCProject1CUI.User;
import PDCProject2GUI.Program;
import PDCProject2GUI.data.LoginModel;
import PDCProject2GUI.view.LoginPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                String errorMessage = validateUsernameAndPassword(username, password);
                if (errorMessage != null) {
                    loginmodel.setErrorMessage(errorMessage);
                    loginmodel.setLoginFlag(false);
                } else {
                    System.out.printf("checking username %s and password %s against model", username, password);
                    boolean isValid = this.loginmodel.checkName(username, password); // Pass input to model
                    if (isValid) {
                        loginmodel.setLoginFlag(true);
                        Program.user = new User(username);
                    } else {
                        loginmodel.setLoginFlag(false);
                        loginmodel.setErrorMessage("Please enter valid username or password");
                    }
                }
                loginmodel.notifyObservers();
                break;
        }
    }

    public String validateUsernameAndPassword(String username, String password) {

        if (username.isEmpty()) {
            return "Username must not be empty";
        }

        if (password.isEmpty()) {
            return "Password must not be empty";
        }
        
        if (username.length() < 3) {
            return "Username must be at least 3 characters";
        }
        
         if (password.length() < 3) {
            return "Password must be at least 3 characters";
        }

        return null;
    }
}
    

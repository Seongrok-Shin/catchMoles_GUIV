
package PDCProject2GUI.data;

import PDCProject1CUI.User;
import PDCProject2GUI.data.Database;
import java.util.Observable;


public class LoginModel extends Observable {
    
    public Database db;
    public String username; //to store username later
    
    boolean loginFlag = false;
    User user = null;
    int currentScore = 0;
    private String errorMessage;
    
    public LoginModel(Database db) {
       this.db = db;
    }
    
    
    public boolean checkName(String username, String password) {
        return db.checkName(username, password);
    }
    
    public void notifyObservers() {
        this.setChanged(); // Essential. To mark this observable instance has been modified.
        this.notifyObservers(this); 
    }
    
     public boolean isLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(boolean loginFlag) {
        this.loginFlag = loginFlag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
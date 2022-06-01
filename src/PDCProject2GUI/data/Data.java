
package PDCProject2GUI.data;
import PDCProject1CUI.User;

public class Data {

    boolean loginFlag = false;
    User user = null;
    int currentScore = 0;

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
    
    
}


package PDCProject2GUI.controller;

import PDCProject2GUI.data.Data;
import PDCProject2GUI.data.Database;
import java.sql.SQLException;
import java.util.Observable;


public class LoginModel extends Observable {
    
    public Database db;
    public Data data;
    public String username; //to store username later
    
    public LoginModel() throws SQLException {
        this.db = new Database();
        this.db.dbsetup();
    }
    
    
    public void checkName(String username, String password) {
        this.username = username; 
        this.data = this.db.checkName(username, password); 
        
        //if (data.loginFlag) {
            //Go to homepanel
        //}
        
        this.setChanged(); // Essential. To mark this observable instance has been modified.
        this.notifyObservers(this.data); 
    }
    
    public void quitGame() {
       
//        this.db.quitGame(this.data.currentScore, this.username); 
//        this.data.quitFlag = true; 
//        this.notifyObservers(this.data);
    }
    
    
    
    
    
  
    
}



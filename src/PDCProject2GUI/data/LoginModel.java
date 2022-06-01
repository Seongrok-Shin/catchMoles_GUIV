
package PDCProject2GUI.data;

import PDCProject2GUI.data.Data;
import PDCProject2GUI.data.Database;
import java.sql.SQLException;
import java.util.Observable;


public class LoginModel extends Observable {
    
    public Database db;
    public Data data;
    public String username; //to store username later
    
    
    public LoginModel(Database db) {
       this.db = db;
    }
    
    
    public void checkName(String username, String password) {
        this.username = username; 
        this.data = this.db.checkName(username, password); 
        
        
        this.setChanged(); // Essential. To mark this observable instance has been modified.
        this.notifyObservers(this.data); 
    }
    
}
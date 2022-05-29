/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDCProject1CUI;

import java.util.Objects;

/**
 *
 * @author ssr7324
 */
public class User {
    private final String userName;
    
    public User(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
    
    @Override
    public String toString(){
        return "[Name: " + this.userName ;
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.userName, other.userName);
    }
}

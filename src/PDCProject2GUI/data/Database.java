package PDCProject2GUI.data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
   
    

    Connection conn = null;
    String url = "jdbc:derby://localhost:1527/Database";
    //jdbc:derby://localhost:1527/Database 
    String dbusername = "shh";
    String dbpassword = "shh";

    public void dbsetup() throws SQLException {
        //try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";

            if (!checkTableExisting(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(16), password VARCHAR(16), score INT)");
            }
            statement.close();

//        } catch (SQLException e) {
//            System.out.println("error");
//            throw new RuntimeException("fail to connect database", e);
        //}
    }

    public Data checkName(String username, String password) {
        Data data = new Data(); 
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, password FROM UserInfo "
                    + "WHERE userid = '" + username + "'");
            if (rs.next()) {
                String pass = rs.getString("password");
                System.out.println("***" + pass);
                System.out.println("found user");
               
                //If user exists + password is correct, = loginflat = true ,else loginFlag = false. 
                if (password.compareTo(pass) == 0) {
                    data.loginFlag = true;
                } else {
                    data.loginFlag = false;
                }
            } else {
                //If user does not exist,create a new account
                System.out.println("Welcome to catch moles Game ");
                statement.executeUpdate("INSERT INTO UserInfo "
                        + "VALUES('" + username + "', '" + password + "', 0)");
                data.currentScore = 0;
                data.loginFlag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {

            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
            //Statement dropStatement=null;
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
        }
        return flag;
    }
}

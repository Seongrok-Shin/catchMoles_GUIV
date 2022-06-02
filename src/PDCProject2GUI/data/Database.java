package PDCProject2GUI.data;

import PDCProject1CUI.Score;
import PDCProject1CUI.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    Connection conn = null;
    String url = "jdbc:derby://localhost:1527/Database";
    //jdbc:derby://localhost:1527/Database 
    String dbusername = "shh";
    String dbpassword = "shh";

    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";

            if (!checkTableExisting(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(16), password VARCHAR(16), score INT)");
            }
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException("fail to connect database", e);
        }
    }

    public boolean checkName(String username, String password) {
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, password FROM UserInfo "
                    + "WHERE userid = '" + username + "'");
            if (rs.next()) {
                String pass = rs.getString("password");
                System.out.println("Found user with password " + pass);

                //If user exists + password is correct, = loginflat become true ,else loginFlag become false. 
                if (password.compareTo(pass) == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                //If user does not exist,create a new account
                System.out.println("Welcome to catch moles Game ");
                statement.executeUpdate("INSERT INTO UserInfo "
                        + "VALUES('" + username + "', '" + password + "', 0)");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
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

    public Map<User, Score> getUserScores() {
        Map<User, Score> userScores = new HashMap();

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, score FROM UserInfo ");
            while (rs.next()) {
                String username = rs.getString("userid");
                int score = Integer.parseInt(rs.getString("score"));
                userScores.put(new User(username), new Score(score));
            }
        } catch (SQLException ex) {
        }
        return userScores;
        
    }

    public void updateUserScore(User user, int score) {
        try {
            System.out.println("Updating user" + user.getUserName() + " with score " + score);

            Statement statement = conn.createStatement();

            int updatedRowCount = statement.executeUpdate("UPDATE UserInfo SET score = " + score
                    + "WHERE userid = '" + user.getUserName() + "'");
            if (updatedRowCount != 1) {
                throw new RuntimeException("Could not set score for user" + user.getUserName() + "score is " + score);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Score getScoreForUser(User user) {
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT score FROM UserInfo "
                    + "WHERE userid = '" + user.getUserName() + "'");

            if (rs.next()) {
                int score = Integer.parseInt(rs.getString("score"));
                System.out.println("Found user" + user.getUserName() + " with score " + score);
                return new Score(score);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

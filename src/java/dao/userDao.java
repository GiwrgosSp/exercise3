package dao;

import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class userDao extends Database {

    String server = "localhost:3306";
    String database = "excersise";
    String username = "root";
    String password = "1234";

    private static final String selectUsers = "SELECT username,password FROM `excersise`.`users`";
    

    public List<User> getUsers() {

        User ur;
        List<User> users = new ArrayList<>();

        setOptions("?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
        ResultSet rs = Database(server, database, username, password, selectUsers);
        if (rs == null) {
            System.out.println("Error to the database");
        }
        
        try {
            while (rs.next()) {
                ur = new User(rs.getString("username"), rs.getString("password"));
                users.add(ur);
            }
            return users;

        } catch (SQLException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public  boolean updateUser(User u,String ip){
        LocalDateTime now = LocalDateTime.now();
        String updateUser="UPDATE users SET lastlogindatetime ='"+now+"', loginip = '"+ip+"'where users.username = '"+u.getUsername()+"'";
        
        setOptions("?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
        int i = Database(server, database, username, password, updateUser,(byte) 1);
        if(i>=1){
            
        return true;
        }else{
            return false;
        }
    }


}


package entities;

import java.time.LocalDateTime;


public class User {
    int uid;
    String username;
    String password;
    String datetime;
    String loginip;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    public User(int uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }
    

    public User(int uid, String username, String password, String datetime, String loginip) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.datetime = datetime;
        this.loginip = loginip;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    @Override
    public String toString() {
        return "User{" + "uid=" + uid + ", username=" + username + ", password=" + password + ", datetime=" + datetime + ", loginip=" + loginip + '}';
    }

    
    
    
}

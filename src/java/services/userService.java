/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.userDao;
import entities.User;
import java.util.List;

public class userService {

    public boolean checkUser(User u, String ip) {
        userDao ud = new userDao();
        List<User> users = ud.getUsers();
        for (User ur : users) {
            if (ur.getUsername().equals(u.getUsername()) && ur.getPassword().equals(u.getPassword())){
                
                    if (ud.updateUser(u, ip)) {
                        return true;
                    }
                
            }
        }
        return false;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Car;
import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class carDao extends Database{
    
    String server = "localhost:3306";
    String database = "excersise";
    String username = "root";
    String password = "1234";

    private static final String selectCars = "SELECT * FROM `excersise`.`cars`";
    
    
    
    
    public List<Car> getCars() {

        Car cr;
        List<Car> cars = new ArrayList<>();

        setOptions("?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
        ResultSet rs = Database(server, database, username, password, selectCars);
        if (rs == null) {
            System.out.println("Error to the database");
        }
        
        try {
            while (rs.next()) {
                cr = new Car(rs.getString("brand"), rs.getString("model"),rs.getInt("horsepower"));
                cars.add(cr);
            }
            return cars;

        } catch (SQLException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    
    
}

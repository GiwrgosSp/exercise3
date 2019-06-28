package services;

import dao.carDao;
import dao.userDao;
import entities.Car;
import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class carService {

    public String getCars() {
        StringBuilder str = new StringBuilder();
        carDao crDao = new carDao();
        List<Car> cars = crDao.getCars();

       str.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Servlet StudentServlet</title>")
                .append("</head>")
                .append("<body>");

        for (Car s : cars) {
            str.append("<p>").append(s).append("</p>");
        }
        //str.append("<a href="+"index.html"+">Logout</a>");
         str.append("<div>Click <a href=\"index.htm\">Logout</a></div>");
        str.append("</body>")
                .append("</html>");

        return str.toString();

    }
}

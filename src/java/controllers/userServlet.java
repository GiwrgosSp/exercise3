package controllers;

import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.carService;
import services.userService;

public class userServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            User u = new User(request.getParameter("username"), request.getParameter("password"));
            userService us = new userService();
            if (us.checkUser(u,request.getRemoteAddr())) {
                
                out.println("Welcome "+u.getUsername());
                carService cs= new carService();
                out.println(cs.getCars());
                
            }else{
               out.println("User not found");
               
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

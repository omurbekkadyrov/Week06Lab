/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.UserService;
import domain.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 759388
 */
public class LoginServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie usernameCookie = getCookie(request.getCookies(), "username");
        
        String action = (String) request.getParameter("action");
        
        if (action != null && action.equals("logout")) {
            request.getSession().invalidate();
        }
        
        if (usernameCookie != null)
            request.setAttribute("username", usernameCookie.getValue());
        
        // If an exception is thrown and that's why we're here, this takes the 
        // exceptions message and sets to 'message', causing it to be displayed
        // as the error message.
        if (request.getAttribute("javax.servlet.error.message") != null)
            request.setAttribute("message", request.getAttribute("javax.servlet.error.message"));
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username == null || password == null) {
            request.setAttribute("message", "Missing username and/or password.");
        } else {
            User user = userService.login(request.getParameter("username"), request.getParameter("password"));
            
            if (user != null) {
                request.getSession().setAttribute("user", User.cloneNoPassword(user));

                if (request.getParameter("rememberMe") != null) {
                    Cookie cookie = new Cookie("username", request.getParameter("username"));

                    cookie.setMaxAge(60 * 60 * 24 * 365);                

                    response.addCookie(cookie);
                }

                response.sendRedirect("/home");
                return;
            } else {
                request.setAttribute("message", "Invalid username and/or password");
            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
    
    private static Cookie getCookie(Cookie[] cookies, String cookieName) {
        Cookie cookie = null;
        
        if (cookies == null) 
            return cookie;
        
        for (Cookie c : cookies) {
            if (c.getName().equals(cookieName))
                cookie = c;
        }
        
        return cookie;
    }

}

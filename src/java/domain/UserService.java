/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author 759388
 */
public class UserService 
{
    public User login(String username, String password)
    {
       User user = null;
       if (username == null || password == null)
            return user;
        
        
        if ((username.equals("adam") && password.equals("password")) || (username.equals("betty") && password.equals("password"))) {
            user = new User(username, password);
        }
        
        return user;
    }
}

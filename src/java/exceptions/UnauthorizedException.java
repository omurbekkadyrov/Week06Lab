/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
/**
 *
 * @author 759388
 */
public class UnauthorizedException extends ServletException {
    public UnauthorizedException() {
        super("You are not authorized to access that page.");
    }
    
}

/*
 * UpdateServlet.java
 *
 * Created on 25 de noviembre de 2006, 14:00
 */

package controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import model.Friend;
import persistence.FriendPersistFactory;
import persistence.FriendDAO;

/**
 *
 * @author Iñigo
 * @version
 */
public class UpdateServlet  extends MyCoolServlet {
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         Friend friend = new Friend();
        FriendDAO persistenceManager = FriendPersistFactory.getFriendDAO(persistenceMechanism);

        String name = request.getParameter("name");
        String formerName = request.getParameter("formerName");        
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String comments = request.getParameter("comments");
        int age = Integer.parseInt(request.getParameter("age"));
        int friendshipLevel = Integer.parseInt(request.getParameter("friendshipLevel"));
//here you validate the parameters
        friend.setName(name);
        friend.setPhone(phone);
        friend.setAddress(address);
        friend.setComments(comments);
        friend.setAge(age);
        friend.setFriendshipLevel(friendshipLevel);
        if (persistenceManager.updateFriend(formerName,friend)) {
            gotoJSPPage(successForm,request,response);
        } else {
        gotoJSPPage(errorForm,request,response);    
        }
        
        
       
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}

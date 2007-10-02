/*
 * readServlet.java
 *
 * Created on 25 de noviembre de 2006, 14:40
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
public class ReadServlet extends MyCoolServlet {
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        FriendDAO persistenceManager = FriendPersistFactory.getFriendDAO(persistenceMechanism);

        String name = request.getParameter("name");
        Friend friend = persistenceManager.readFriend(name);
        if (friend!=null) {
            request.getSession().setAttribute("friend",friend);
            gotoJSPPage(displayForm,request,response);
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

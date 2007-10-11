/*
 * DeleteServlet.java
 *
 * Created on 25 de noviembre de 2006, 13:38
 */

package controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import persistence.FriendPersistFactory;
import persistence.FriendDAO;

/**
 *
 * @author I�igo
 * @version
 */
public class DeleteServlet extends MyCoolServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        FriendDAO persistenceManager = FriendPersistFactory.getFriendDAO(persistenceMechanism);

        String name = request.getParameter("name");
        if (persistenceManager.deleteFriend(name)) {
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
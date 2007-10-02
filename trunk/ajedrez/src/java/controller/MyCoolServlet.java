/*
 * NewClass.java
 *
 * Created on 24 de noviembre de 2006, 18:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Iñigo
 */
public class MyCoolServlet extends HttpServlet {
    
    /** Creates a new instance of NewClass */
    public MyCoolServlet() {
    }
    
    
    protected String createForm = null;
    
    protected String deleteForm = null;
    
    protected String displayForm = null;
    
    protected String errorForm = null;
    
    protected String listForm = null;
    
    protected String mainForm = null;
    
    protected String successForm = null;
    
    protected String updateForm = null;
    protected String createServlet = null;
    protected String deleteServlet = null;
    protected String updateServlet = null;
    protected String readServlet = null;
    protected String persistenceMechanism = null;
    
    protected void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getNamedDispatcher(address);
        dispatcher.forward(request, response);
        
    }
    
    protected void gotoJSPPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        dispatcher.forward(request, response);
        
    }
    
    
    
    public void init(){
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();
        createForm = context.getInitParameter("createForm");
        deleteForm = context.getInitParameter("deleteForm");
        updateForm = context.getInitParameter("updateForm");
        listForm =  context.getInitParameter("listForm");
        errorForm = context.getInitParameter("errorForm");
        successForm = context.getInitParameter("successForm");
        mainForm = context.getInitParameter("mainForm");
        createServlet  = context.getInitParameter("createServlet");
        deleteServlet  = context.getInitParameter("deleteServlet");
        readServlet  = context.getInitParameter("readServlet");
        updateServlet  = context.getInitParameter("updateServlet");
        displayForm = context.getInitParameter("displayForm");
        persistenceMechanism = context.getInitParameter("persistenceMechanism");
        
    }
    
}

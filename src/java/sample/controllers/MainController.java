/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "MainController",
        urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String LOGOUT = "Logout"; // "value" in form of html page (login page), this must be same name
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String LOGIN_PAGE = "login.jsp";
    private static final String LOGIN = "Login"; // "value" in form of html page (login page), this must be same name    
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String SEARCH = "Search"; // "value" in form of html page (login page), this must be same name
    private static final String SEARCH_CONTROLLER = "SearchController";
    private static final String UPDATE = "Update"; // "value" in form of html page (login page), this must be same name
    private static final String UPDATE_CONTROLLER = "UpdateController";
    private static final String DELETE = "Delete"; // "value" in form of html page (login page), this must be same name
    private static final String DELETE_CONTROLLER = "DeleteController";
    private static final String CREATE = "Create"; // "value" in form of html page (login page), this must be same name
    private static final String CREATE_CONTROLLER = "CreateController";
    private static final String ADD="Add";
    private static final String Add_Controller="AddController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            String action = request.getParameter("action");
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (SEARCH.equals(action)) {
                url = SEARCH_CONTROLLER;            
            } else if (UPDATE.equals(action)) {
                url = UPDATE_CONTROLLER;
            } else if (DELETE.equals(action)){
                url = DELETE_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;            
            } else if (CREATE.equals(action)) {
                url = CREATE_CONTROLLER;
            } else if(ADD.equals(action)){
                url=Add_Controller;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldisgoldrits.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oldisgoldrits.controller.RequestHandler;
import oldisgoldrits.model.RequestTable;

/**
 * This servlet class passes request related operations to the appropriate handler and returns the result
 * in an HttpServletResponse object
 * @author madan parameswaran
 */
@WebServlet(name = "QueryRequestServlet", urlPatterns = {"/QueryRequest"})
public class QueryRequestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
        String status = request.getParameter("status");
        String title = request.getParameter("title");
        Boolean update = Boolean.valueOf(request.getParameter("update"));
        Boolean add = Boolean.valueOf(request.getParameter("add"));
        Logger log = Logger.getLogger(getClass().getSimpleName());
        log.info("Update: " + update + "param update: " + request.getParameter("update"));
        Boolean delete = Boolean.valueOf(request.getParameter("deleteRecord"));
        if (update) {
            runUpdate(request, response);
        } else if(delete)
        {
            deleteRequest(request, response);
        }
        else if (add) {
            addRequest(request, response);
        } else {
            RequestHandler requestHandler = new RequestHandler();
            if ((status == null || status.equals("")) && (title == null || title.equals(""))) {
                try {
                    ArrayList<RequestTable> requestList = requestHandler.getRequest();
                    log.info(requestList.get(0).getRequest().getDescription());
                    request.setAttribute("requestList", requestList);
                } catch (SQLException ex) {
                    Logger.getLogger(QueryRequestServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if ((status == null || status.equals("")) && (!title.trim().equals(""))) {
                try {
                    String condition = "REQUEST.description like \"%" + title + "%\";";
                    log.info(condition);
                    ArrayList<RequestTable> requestList = requestHandler.getRequest(condition);

                    request.setAttribute("requestList", requestList);
                } catch (SQLException ex) {
                    Logger.getLogger(QueryRequestServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    String condition = "REQUEST.status=" + status + " and REQUEST.description like \"%" + title + "%\";";
                    log.info(condition);
                    ArrayList<RequestTable> requestList = requestHandler.getRequest(condition);

                    request.setAttribute("requestList", requestList);
                } catch (SQLException ex) {
                    Logger.getLogger(QueryRequestServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/requestTable.jsp");

            requestDispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

    /**
     * This method passes a message to the handler to update an existing request
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void runUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer requestID = Integer.parseInt(request.getParameter("requestID"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity").trim());

        String description = request.getParameter("description").trim();
        Boolean status = Boolean.valueOf(request.getParameter("status"));

        RequestHandler requestHandler = new RequestHandler();
        Logger log = Logger.getLogger(getClass().getSimpleName());
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/requestTable.jsp");
        log.log(Level.INFO, "Request {0} status = {1}", new Object[]{requestID, status});
        try {
            requestHandler.editRequest(requestID, description, quantity, status);
        } catch (SQLException ex) {
            Logger.getLogger(QueryRequestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        requestDispatcher.forward(request, response);
    }

    /**
     * This private method calls the request handler to add a new request
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException
     * @throws IOException 
     */
    private void addRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerID = Integer.parseInt(request.getParameter("customerID"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity").trim());
        Integer employeeID = Integer.parseInt(request.getParameter("employeeID"));

        String description = request.getParameter("description").trim();
        String date = request.getParameter("date");
        Boolean status = Boolean.valueOf(request.getParameter("status"));

        RequestHandler requestHandler = new RequestHandler();
        Logger log = Logger.getLogger(getClass().getSimpleName());
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/requestTable.jsp");
        log.log(Level.INFO, "Request {0} status = {1} employee = {2}, date = {3}, description = {4}", new Object[]{customerID, status, employeeID, date, description});
        try {

            requestHandler.addNewRequest(customerID, employeeID, description, date, quantity, status);

        } catch (SQLException ex) {
            Logger.getLogger(QueryRequestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        requestDispatcher.forward(request, response);
    }

    /**
     * This servlet method sends a message to the handler to delete an existing request
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void deleteRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Integer requestID = Integer.parseInt(request.getParameter("requestID"));
        
        RequestHandler requestHandler = new RequestHandler();
        Logger log = Logger.getLogger(getClass().getSimpleName());
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/requestTable.jsp");
        try {
            requestHandler.deleteRequest(requestID);
        } catch (SQLException ex) {
            Logger.getLogger(QueryRequestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        requestDispatcher.forward(request, response);



    }

}

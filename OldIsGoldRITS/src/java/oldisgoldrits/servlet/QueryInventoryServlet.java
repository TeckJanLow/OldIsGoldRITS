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
import oldisgoldrits.controller.InventoryHandler;
import oldisgoldrits.model.InventoryTable;

/**
 *
 * @author madan parameswaran
 */
@WebServlet(name = "QueryInventoryServlet", urlPatterns = {"/QueryInventory"})
public class QueryInventoryServlet extends HttpServlet {

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

        String sku = request.getParameter("sku");
        String title = request.getParameter("title");
        Boolean update = Boolean.valueOf(request.getParameter("update"));
        Boolean add = Boolean.valueOf(request.getParameter("add"));

        Logger log = Logger.getLogger(getClass().getSimpleName());
        log.log(Level.INFO, "SKU = {0}", sku);

        if (update) {
            runUpdate(request, response);
        } else if (add) {
            addInventory(request, response);
        } else {
            InventoryHandler inventoryHandler = new InventoryHandler();
            if ((sku == null || sku.equals("")) && (title == null || title.equals(""))) {
                try {
                    ArrayList<InventoryTable> inventoryList = inventoryHandler.getInventory();
                    log.info(inventoryList.get(0).getAlbum().getTitle());
                    request.setAttribute("inventoryList", inventoryList);
                } catch (SQLException ex) {
                    Logger.getLogger(QueryInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if ((sku == null || sku.equals("")) && (!title.trim().equals(""))) {
                try {
                    String condition = "ALBUM.title like \"%" + title + "%\";";
                    log.info(condition);
                    ArrayList<InventoryTable> inventoryList = inventoryHandler.getInventory(condition);

                    request.setAttribute("inventoryList", inventoryList);
                } catch (SQLException ex) {
                    Logger.getLogger(QueryInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ((sku != null || !sku.equals("")) && (title == null || title.equals(""))) {
                try {
                    String condition = "INVENTORY.sku = " + sku;
                    log.info(condition);
                    ArrayList<InventoryTable> inventoryList = inventoryHandler.getInventory(condition);

                    request.setAttribute("inventoryList", inventoryList);
                } catch (SQLException ex) {
                    Logger.getLogger(QueryInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    String condition = "INVENTORY.sku = " + sku + " and ALBUM.title like \"%" + title + "%\";";
                    log.info(condition);
                    ArrayList<InventoryTable> inventoryList = inventoryHandler.getInventory(condition);

                    request.setAttribute("inventoryList", inventoryList);
                } catch (SQLException ex) {
                    Logger.getLogger(QueryInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/inventoryTable.jsp");

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

    private void runUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer sku = Integer.parseInt(request.getParameter("sku"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity").trim());
        Double price = Double.parseDouble(request.getParameter("price").trim());

        String comments = request.getParameter("comments").trim();

        InventoryHandler inventoryHandler = new InventoryHandler();
        Logger log = Logger.getLogger(getClass().getSimpleName());
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/inventoryTable.jsp");
        log.log(Level.INFO, "sku {0} quantity = {1} price = {2} comment = {3}", 
                new Object[]{sku, quantity, price, comments});
        try {
            inventoryHandler.editInventory(sku, quantity, price, comments);
        } catch (SQLException ex) {
            Logger.getLogger(QueryInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        requestDispatcher.forward(request, response);

    }

    private void addInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String quality = request.getParameter("quality").trim();
        Integer quantity = Integer.parseInt(request.getParameter("quantity").trim());
        Double price = Double.parseDouble(request.getParameter("price").trim());
        Double purchasePrice = Double.parseDouble(request.getParameter("purchasePrice").trim());
        Integer albumID = Integer.parseInt(request.getParameter("albumID").trim());

        InventoryHandler inventoryHandler = new InventoryHandler();
        Logger log = Logger.getLogger(getClass().getSimpleName());
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/inventoryTable.jsp");
        log.log(Level.INFO, "quality = {0} quantity = {1} price = {2} purchase = {3} "
                + "albumID = {4}", new Object[]{quality, quantity, price, purchasePrice, albumID});
        try {
            inventoryHandler.addNewInventory(quality, quantity, price, purchasePrice, albumID);

        } catch (SQLException ex) {
            Logger.getLogger(QueryInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        requestDispatcher.forward(request, response);

    }

}

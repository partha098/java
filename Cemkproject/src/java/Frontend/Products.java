/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Frontend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author parth
 */
public class Products extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            Connection con = Dbcon.getcon(); 
  
            Statement stmt=con.createStatement();  
            
            String cname=request.getParameter("cname");


            
          ResultSet rs=  stmt.executeQuery("SELECT * FROM categories "); 
          
          ArrayList<HashMap> ar=new ArrayList();
                  
          
          while(rs.next()){
              HashMap<String,String> hm=new HashMap<>();
              
              hm.put("cat_name",rs.getString("cat_name"));
               hm.put("cat_id",rs.getString("cat_id"));
              
             ar.add(hm);
          }  
              
             request.setAttribute("categories", ar);
             
             ResultSet rsp=  stmt.executeQuery("SELECT * FROM products"); 
          
          ArrayList<HashMap> arp=new ArrayList();
                  
          
          while(rsp.next()){
              HashMap<String,String> hmp=new HashMap<>();
              
              hmp.put("product_id",rsp.getString("product_id"));
               hmp.put("product_name",rsp.getString("product_name"));
                hmp.put("product_price",rsp.getString("product_price"));
               hmp.put("product_image",rsp.getString("product_image"));
             
              
             arp.add(hmp);
          }  
              
             request.setAttribute("products", arp);
            
            
            
          request.getRequestDispatcher("products.jsp").forward(request, response);
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
        try {
            try {
                processRequest(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            try {
                processRequest(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author khsci5mca17062
 */
public class paymentconfirmation extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
        out.println("<html>");
            out.println("<head>");
              out.println(" <meta charset=\"utf-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>");            
            out.println("</head>");
            out.println("<body>");
            try
            {
                  out.println("<nav class=\"navbar navbar-expand-sm bg-light navbar-light\">\n" +
"  <div class=\"container-fluid\">\n" +
"   \n" +
"     <ul class=\"nav nav-tabs nav-justified\">\n" +
"      \n" +
"      <li><a href=\"addvenue.html\"><b>Add Venue</b></a></li>\n" +
"      <li><a href=\"adminstatus\"><b>View Booking</b></a></li>\n" +
"      <li><a href=\"adminvenue\"><b>View Venue</b></a></li>\n" +
"      <li><a href=\"adminfeedback\"><b>View Feedback</b></a></li>\n" +
"      <li><a href=\"logout\"><b>Logout</b></a></li>\n" +
"    </ul>\n" +
"  </div>\n" +
"</nav>\n" +
"       <center> <font size=\"7\" color='#77AED4' face=\"cooper\" >Payment Confirmation </font>\n" +
"           <br> <br> <br>\n" +
"        <div class=\"container\">\n");
                  
                  
                 //bid from bookevent
                 HttpSession session = request.getSession(false);
                 int bid=(int)session.getAttribute("bid");
                 String status="Paid";
                  int flag=1;   
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","");
                PreparedStatement ps=con.prepareStatement("update paid_customer set  payment_status=?,flag=? where bookingid=?");
                ps.setString(1,status);
                ps.setInt(2,flag);
                ps.setInt(3, bid);
                ps.executeUpdate();
               
                
                out.println("<h2>The customer has paid the total amount. </h2>");
                
              
               ps.close();
               con.close();
            }
            catch(Exception e)
            {
                out.println(e);
            }
            out.println("</body>");
            out.println("</html>");
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

}

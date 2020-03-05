/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author khsci5mca17062
 */
public class repaymentconfo extends HttpServlet {

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
           
               //booid from repayment
               HttpSession session = request.getSession(false);
               int bid=(int)session.getAttribute("booid");
               
               Class.forName("com.mysql.jdbc.Driver");
              
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event","root","");
               
                //PreparedStatement ps2=con.prepareStatement("select bookingid from bookanevent where userid=?");
               //ps2.setInt(1,userid);
               //ResultSet rs=ps2.executeQuery();
               //rs.next();
              // int bid=rs.getInt(1); background='image/done.jpeg'
              
              PreparedStatement ps=con.prepareStatement("delete from payment where bookingid=?");
              ps.setInt(1, bid);
              ps.executeUpdate();
              
              PreparedStatement ps1=con.prepareStatement("delete from paid_customer where bookingid=?");
               ps1.setInt(1, bid);
                ps1.executeUpdate();
               
                String status="Canceled";
                  PreparedStatement ps2=con.prepareStatement("update bookanevent set status=? where bookingid=?");
               ps2.setString(1, status);
               ps2.setInt(2, bid);
                ps2.executeUpdate();
               
                
                PreparedStatement ps3=con.prepareStatement("delete from event_cancel where bookingid=?");
                ps3.setInt(1, bid);
                ps3.executeUpdate();
                
                
               ps.close();
               ps1.close();
               ps2.close();
               ps3.close();
               con.close();
               
               out.println("<script>alert('Repayment done right!!!')</script>");
               request.getRequestDispatcher("adminstatus").include(request,response);
               
               
               
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

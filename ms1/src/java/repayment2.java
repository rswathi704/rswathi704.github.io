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

/**
 *
 * @author khsci5mca17062
 */
public class repayment2 extends HttpServlet {

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
            out.println("<body background='image/repay.jpeg'>");
           try
           {
               Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event","root","");
              PreparedStatement ps=con.prepareStatement("select password from admin_card");
              ResultSet rs=ps.executeQuery();
              rs.next();
              
               PreparedStatement ps1=con.prepareStatement("select otp from payment");
              ResultSet rs1=ps1.executeQuery();
              rs1.next();
               out.println("<script>alert('"+rs1.getInt(1)+"')</script>");
              
              
               out.println(" <center>\n" +
"        <font size=\"10\" color=\"lightgrey\" face=\"Cooper\">RE-PAYMENT</font> <br> <br> <br> <br>"
                       + "<font color=\"lightgrey\"> "
                       + "<div class=\"container\">\n" +
"    \n" +
"   \n" +
"  <form class=\"form-horizontal\" method=\"post\">\n" +
"    <div class=\"form-group\">\n" +
"      <label class=\"control-label col-md-4\" for=\"pass\">Transaction Password:</label>\n" +
"      <div class=\"col-md-5\">\n" +
"          <input type=\"password\" class=\"form-control\" id=\"pass\" placeholder=\"Enter Password\" name=\"pass\" value='"+rs.getString(1)+"'>\n" +
"      </div>\n" +
"    </div>\n" +
"    \n" +
"    <div class=\"form-group\">\n" +
"      <label class=\"control-label col-md-4\" for=\"otp\">OTP Password:</label>\n" +
"      <div class=\"col-md-5\">          \n" +
"        <input type=\"password\" class=\"form-control\" id=\"otp\" placeholder=\"Enter OTP Password\" name=\"otp\" required=\"required\">\n" +
"      </div>\n" +
"    </div>\n" +
"       <div class=\"form-group\">        \n" +
"      <div class=\"col-md-offset-1 col-md-10\">\n" +
"          \n" +
"             <input type=\"button\" value=\"Cancel\"  class=\"btn btn-default\" onclick=\"history.back()\">\n" +
"        <button type=\"submit\" class=\"btn btn-default\" formaction='repaymentconfo'>Submit</button>\n" +
"   \n" +
"        <button type=\"reset\" class=\"btn btn-default\">Reset</button>\n" +
"      </div>\n" +
"    </div>\n" +
"  </form>\n" +
"</div>"
        + "</font>"
                       + "</center>");
                 
            
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

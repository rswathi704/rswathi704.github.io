/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author khsci5mca17062
 */
public class adminstatus extends HttpServlet {

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
           
           out.println("<nav class=\"navbar navbar-expand-sm bg-light navbar-light\">\n" +
"  <div class=\"container-fluid\">\n" +
"   \n" +
"     <ul class=\"nav nav-tabs nav-justified\">\n" +
"      \n" +
"      <li><a href=\"addvenue.html\"><b>Add Venue</b></a></li>\n" +
"      <li class=\"active\"><a href=\"#\"><b>View Booking</b></a></li>\n" +
"      <li><a href=\"adminvenue\"><b>View Venue</b></a></li>\n" +
"      <li><a href=\"adminfeedback\"><b>View Feedback</b></a></li>\n" +
"      <li><a href=\"logout\"><b>Logout</b></a></li>\n" +
"    </ul>\n" +
"  </div>\n" +
"</nav>\n" );
         
out.println( "<b><a href='eventcancel'> Canceled Event </a></b>"
        + "    <center> <font size=\"7\" color='#77AED4' face=\"cooper\" >VIEW BOOKING </font>\n" +
"           <br> <br> <br>\n" +
"        <div class=\"container\">\n");
           
           
           
              out.println("<div class='container'> "+
                     "<form class='form-horizontal' action='adminstatus1'>\n" +
"    <div class='form-group'>\n" +
"      <label class='control-label col-md-4' for='bid'>Booking ID:</label>\n" +
"      <div class='col-md-5'>\n" +
"          <input type='text' class='form-control' id='bid' autocomplete='off' placeholder='Enter Booking ID' name='bid' required='required'>\n" +
"      </div>\n" +
"    </div>\n" +
        
" <div class=\"form-group\">\n" +
"      <label class=\"control-label col-md-4\" for=\"status\">Status:</label>\n" +
"      <div class=\"col-md-5\">\n" +
"      <select class=\"form-control\" id=\"status\" name=\"status\">\n" +
"        <option value=\"Pending\">Pending</option>\n" +
"        <option value=\"Approved\">Approved</option>\n" +
"        <option value=\"Canceled\">Canceled</option>\n" +
"      </select>\n" +
"          </div>\n" +
"      </div>"+
"    <div class='form-group'>"+
"      <div class='col-md-offset-1 col-md-10'>"+
       " <button type='submit' class='btn btn-default' formaction='adminstatus1'>Update </button>"+
       " <button type='submit' class='btn btn-default' formaction='paycheck'>Payment Check </button>"+
                    
 // " <button type='submit' class='btn btn-default' formaction='eventcancel'> Canceled Event </button>"+
     " </div>"+
   " </div>"+ "</form>"
                      + "</div>"); 
           
             try 
             {
                 
        
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/event", "root",""); 
                
                PreparedStatement ps = con.prepareStatement("select * from bookanevent");
                ResultSet rs=ps.executeQuery();
                
          
            out.println("<div class=\"container\">\n" +
"  <table class=\"table\">\n" +
"    <thead>\n" +
"    </thead>\n" +
"    <tbody>\n" +
"      <tr>\n" +
                    "<th> BID </th> "+
                    "<th> CID </th>"+
                    "<th>Guest </th>"+
                    "<th> Event </th>"+
                    "<th> Event Place </th>"+
                    "<th> Date </th>"+
                    "<th> Equipment </th>"+
                    "<th> Food Type </th>"+
                    "<th> Breakfast </th>"+
                    "<th> Lunch </th>"+
                    "<th> Snacks </th>"+
                    "<th> Dinner </th>"+
                    "<th> Flower </th>"+
                    "<th> Seating </th>"+
                    "<th> Lighting </th>"+
                    "<th> Amount </th>"+
                    "<th> Status </th>"
                    + "</tr>");
            
                while(rs.next())
                {
                    
                   out.println( "<tr>"+
                    "<td>"+rs.getInt(1)+"</td>\n" +
                    "<td>"+rs.getInt(2)+"</td>\n" +
                    "<td>"+rs.getInt(3)+"</td>\n" +
                    "<td>"+rs.getString(4)+"</td>\n" +
                    "<td>"+rs.getString(5)+"</td>\n" +
                    "<td>"+rs.getString(6)+"</td>\n" +
                    "<td>"+rs.getString(7)+"</td>\n" +
                    "<td>"+rs.getString(8)+"</td>\n" +
                    "<td>"+rs.getString(9)+"</td>\n" +
                    "<td>"+rs.getString(10)+"</td>\n" +
                    "<td>"+rs.getString(11)+"</td>\n" +
                    "<td>"+rs.getString(12)+"</td>\n" +
                    "<td>"+rs.getString(13)+"</td>\n" +
                    "<td>"+rs.getString(14)+"</td>\n" +
                    "<td>"+rs.getString(15)+"</td>\n" +
                    "<td>"+rs.getInt(16)+"</td>\n" +
                    "<td>"+rs.getString(17)+"</td>\n" +        
"      </tr>\n" );
    
                           }
                     out.println("</tbody>" +
"</table>" +
 "</div>");
                             
                
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

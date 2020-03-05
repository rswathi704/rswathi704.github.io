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
public class eventbooking extends HttpServlet {

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
            
            
              out.println(" <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"                <link rel=\"stylesheet\" href=\"http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css\" />\n" +
"<script src=\"http://code.jquery.com/jquery-1.8.2.js\"></script>\n" +
"<script src=\"http://code.jquery.com/ui/1.9.1/jquery-ui.js\"></script>"); 
              
              
            out.println("</head>");
            out.println("<body background='image/book2.jpg' style='background-repeat: no-repeat;background-size: cover;'>");
            
            out.println(" <nav class=\"navbar navbar-expand-sm bg-light navbar-light\">\n" +
"  <div class=\"container-fluid\">\n" +
"   \n" +
"     <ul class=\"nav nav-tabs nav-justified\">\n" +
"      \n" +
"      <li><a href=\"home\"><b><font color='lightgrey'>Home</font></b></a></li>\n" +
"      <li  class=\"active\"><a href=\"#\"><b><font color='lightgrey'>Book an Event</font></b></a></li>\n" +
"      <li><a href=\"customerstatus\"><b><font color='lightgrey'>Booking Status</font></b></a></li>\n" +
"      <li><a href=\"feedback.html\"><b><font color='lightgrey'>Feedback</font></b></a></li>\n" +
"      <li><a href=\"viewvenue.html\"><b><font color='lightgrey'>View Venue</font></b></a></li>\n" +
"      <li><a href=\"logout\"><b><font color='lightgrey'>Logout</font></b></a></li>\n" +
"    </ul>\n" +
"  </div>\n" +
"</nav>");
            try
            {
            
            out.println("<center> <font size=\"7\" face=\"cooper\" color='white' >&nbsp &nbsp&nbsp &nbsp"
                    + "BOOK EVENTS </font></center>\n" +
"      <br> <br> <br>\n" +
"        <div class=\"container\">\n" +
"    \n" +
"   \n"
                    + "<font color='white' >" +
"  <form class=\"form-horizontal\" action=\"bookanevent\" method=\"POST\">\n" +
"   \n" +
"    <div class=\"form-group\">\n" +
"      \n" +
"      <label class=\"control-label col-md-4\" for=\"event_type\">Event Type:</label>\n" +
"      <div class=\"col-md-5\">\n" +
"      <select class=\"form-control\" id=\"event_type\" name=\"event_type\" required=\"required\">\n" +
"          <option value=\"----\">---select---</option>\n" +
"        <option value=\"Marriage\">Marriage</option>\n" +
"        <option value=\"Family Function\">Family Function</option>\n" +
"        <option value=\"Birthday\">Birthday</option>\n" +
"        <option value=\"Anniversary\">Anniversary</option>\n" +
"        <option value=\"Farewell\">Farewell</option>\n" +
"      </select>\n" +
"          </div>\n" +
"      </div>\n" +
"    \n" );
            
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event","root","");
            PreparedStatement ps=con.prepareStatement("select venuename from addvenue");
            ResultSet rs=ps.executeQuery();
            
out.println("     <div class=\"form-group\">\n" +
"      \n" +
"      <label class=\"control-label col-md-4\" for=\"place\">Event Place:</label>\n" +
        "      <div class=\"col-md-5\">\n" +
"      <select class=\"form-control\" id=\"place\" name=\"place\"  required=\"required\">\n"
        + "            <option value='-----'>---select---</option>" );
            int i=0;
            while(rs.next())
            {
out.println(" <option id="+(i++)+" value="+rs.getString(1)+">"+rs.getString(1)+" </option>\n" );
            }
out.println("      </select>\n" +
"          </div>\n" +
"      </div>\n" +
"    \n" );
            
   
   
   
out.println("      <div class=\"form-group\">\n" +
"      <label class=\"control-label col-md-4\" for=\"nog\">No: of Guest:</label>\n" +
"      <div class=\"col-md-5\">\n" +
"        <input type=\"text\" class=\"form-control\" id=\"nog\" autocomplete='off' placeholder=\"Enter No: of Guest\" name=\"nog\"  required=\"required\">\n" +
"      </div>\n" +
"    </div>\n" +
"      <div class=\"form-group\">\n" +
"      <label class=\"control-label col-md-4\" for=\"datepicker\">Date:</label>\n" +
"      <div class=\"col-md-5\">\n" +
"        <input type=\"text\" class=\"form-control\" id=\"datepicker\" autocomplete='off' placeholder=\"Enter Date\" name=\"datepicker\"  required=\"required\">\n" +
"      </div>\n" +
"    </div>\n" +
"    \n" +
"      \n"
        + "<br>" +
"    <div class=\"form-group\">        \n" +
"      <div class=\"col-md-offset-6 col-md-10\">\n" +
"        <input  type=\"submit\" class=\"btn btn-default\" value=\"Next\">\n" +
"      </div>\n" +
"    </div>\n" +
"      \n" +
"      \n"
        + "</font>" +
"  </form>\n" +
"        \n" +
"       \n" +
"</div>   " +
"<script type='text/javascript'>" +
"$(function() {"+
"var date = new Date();"+
"var currentMonth = date.getMonth();"+
"var currentDate = date.getDate();"+
"var currentYear = date.getFullYear();"+
"$('#datepicker').datepicker({"+
"minDate: new Date(currentYear, currentMonth, currentDate)"+
"});"+
"});"+
"</script>");

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

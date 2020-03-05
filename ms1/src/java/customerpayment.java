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
public class customerpayment extends HttpServlet {

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
            out.println(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>");            
            out.println("</head>");
            out.println("<body>");
            
            /*out.println("<nav class=\"navbar navbar-expand-sm bg-light navbar-light\">\n" +
"  <div class=\"container-fluid\">\n" +
"   \n" +
"       <ul class=\"nav nav-tabs nav-justified\">\n" +
"      \n" +
"      <li><a href=\"mydetails\">My Details</a></li>\n" +
"      <li><a href=\"eventbooking\">Book an Event</a></li>\n" +
"      <li><a href=\"customerstatus\">Booking Status</a></li>\n" +
"      <li><a href=\"feedback.html\">Feedback</a></li>\n" +
"      <li><a href=\"viewvenue\">View Venue</a></li>\n" +
"      <li><a href=\"logout\">Logout</a></li>\n" +
"    </ul>\n" +
"  </div>\n" +
"</nav>\n" );*/
            try
            {
                //userid from customer
                
                out.println("<b><a href='customerstatus'>Back</a></b>");
                 HttpSession session = request.getSession(false);
            int userid=(int)session.getAttribute("userid");
                  Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event","root","");
               
                  PreparedStatement ps1=con.prepareStatement("select bookingid from bookanevent where userid=?");
               ps1.setInt(1,userid);
               ResultSet rs1=ps1.executeQuery();
               rs1.next();
               int bid=rs1.getInt(1);
               
               PreparedStatement ps=con.prepareStatement("select amount from bookanevent where bookingid=?");
               ps.setInt(1, bid);
               ResultSet rs=ps.executeQuery();
               rs.next(); 
               
               
               
            out.println();
            
            
out.println("   <center> <font size=\"7\" color=\"grey\" face=\"cooper\" >PAYMENT </font>\n" +
"        <br><br><br>\n" +
"<div class=\"container\">\n" +
"    \n" +
"   \n" +
"  <form class=\"form-horizontal\" action=\"cvv\">\n" +
"    <div class=\"form-group\">\n" +
"      <label class=\"control-label col-md-4\" for=\"cardno\">Card No:</label>\n" +
"      <div class=\"col-md-5\">\n" +
"        <input type=\"text\" class=\"form-control\" autocomplete='off' pattern='^\\d{16}$' id=\"cardno\" placeholder=\"Enter Card No\" name=\"cardno\">\n" +
"      </div>\n" +
"    </div>\n" +
"    <div class=\"form-group\">\n" +
"      <label class=\"control-label col-md-4\" for=\"cvvv\">CVV Number:</label>\n" +
"      <div class=\"col-md-5\">          \n" +
"        <input type=\"text\" class=\"form-control\" id=\"cvvv\" autocomplete='off' pattern='^\\d{3}$' placeholder=\"Enter CVV Number\" name=\"cvvv\">\n" +
"      </div>\n" +
"    </div>\n" +
"      <div class=\"form-group\">\n" +
"      <label class=\"control-label col-md-4\" for=\"name\">Card holder Name:</label>\n" +
"      <div class=\"col-md-5\">\n" +
"        <input type=\"text\" class=\"form-control\" id=\"name\" autocomplete='off' placeholder=\"Enter Name\" name=\"name\">\n" +
"      </div>\n" +
"    </div>\n" +
"      <div class=\"form-group\">\n" +
"      <label class=\"control-label col-md-4\" for=\"datepicker\">Date:</label>\n" +
"      <div class=\"col-md-5\">\n" +
"        <input type=\"text\" class=\"form-control\" id=\"datepicker\" autocomplete='off' placeholder=\"Enter Date\" name=\"datepicker\"  required=\"required\">\n" +
"      </div>\n" +
"    </div>\n" +
"      <div class=\"form-group\">\n" +
"      <label class=\"control-label col-md-4\" for=\"amnt\">Amount:</label>\n" +
"      <div class=\"col-md-5\">\n" +
"        <input type=\"text\" class=\"form-control\" id=\"amnt\" value='"+rs.getInt(1)+"' name=\"amnt\">\n" +
"      </div>\n" +
"    </div>\n" +
"    <div class=\"form-group\">        \n" +
"      <div class=\"col-md-offset-1 col-md-10\">\n" +
"           <input type=\"button\" value=\"Previous\"  class=\"btn btn-default\" onclick=\"history.back()\">\n" +

"        <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n" +
        "             <button type=\"reset\" class=\"btn btn-default\">Reset</button>\n" +
"  \n" +
"      </div>\n" +
"    </div>\n" +
"  </form>\n" +
"        \n" +
"       \n" +
"</div>     \n" +
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
"</script>"+
"       </center>");
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

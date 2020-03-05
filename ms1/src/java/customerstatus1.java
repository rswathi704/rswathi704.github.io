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
public class customerstatus1 extends HttpServlet {

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
                 out.println("<link rel=\'stylesheet\' href=\'https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\'" );
            out.println("<script src=\'https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\'></script>");
            out.println("<script src=\'https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\'></script>");            
            out.println("</head>");
            out.println("<body background='image/stat.jpeg'>");
            
            try
            {
                //bid from 
                int bid=Integer.parseInt(request.getParameter("bid"));
                 HttpSession session=request.getSession();  
                session.setAttribute("bkid",bid); 
                
                Class.forName("com.mysql.jdbc.Driver");
                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","");
                PreparedStatement ps=con.prepareStatement("select bookingid,status from bookanevent where bookingid=?");
                ps.setInt(1, bid);
               
               ResultSet rs=ps.executeQuery();
               rs.next();
               
              
               
            out.println("<nav class=\"navbar navbar-expand-sm bg-light navbar-light\">");
            out.println("<div class='container-fluid'>"
      +" <ul class='nav nav-tabs nav-justified'>"
      
     +" <li><a href='home'><b><font color='lightgrey'>Home</font></b></a></li>"
     +" <li><a href='eventbooking'><b><font color='lightgrey'>Book an Event</font></b></a></li>"
     +" <li class='active'><a href='#'><b><font color='lightgrey'>Booking Status</font></b></a></li>"
      +"<li><a href='feedback.html'><b><font color='lightgrey'>Feedback</font></b></a></li>"
      +"<li><a href='viewvenue'><b><font color='lightgrey'>View Venue</font></b></a></li>"
      +"<li><a href='logout'><b><font color='lightgrey'>Logout</font></b></a></li>"
    +"</ul>"
  +"</div>");
                out.println("</nav>");
                
            out.println("<center> <font size='7' face='cooper' color='lightgrey'> BOOKING STATUS </font></center><br> <br>");
            out.println("<font color='lightgrey'><div class='container'>"); 
            out.println("<form class='form-horizontal'>\n" +
"    <div class='form-group'>\n" +
"      <label class='control-label col-md-4' for='bid'>Booking ID:</label>\n" +
"      <div class='col-md-5'>\n" +
"          <input type='text' class='form-control' id='bid' name='bid' value='"+rs.getString(1)+"' readonly='readonly'>\n" +
"      </div>\n" +
"    </div>\n" +
"    <div class='form-group'>\n" +
"      <label class='control-label col-md-4' for='name'> Status:</label>\n" +
"      <div class='col-md-5'> \n" +
"        <input type='text' class='form-control' id='status' readonly='readonly' name='status' value='"+rs.getString(2)+"'>\n" +
"      </div>\n" +
"    </div>\n"+
        "    <div class='form-group'>\n" +
"      <div class='col-md-offset-5 col-md-10'>\n"
        + " <input type=\"button\" value=\"Previous\"  class=\"btn btn-default\" onclick=\"history.back()\">" +
"        <button type='submit' class='btn btn-default' formaction='payment1'> Payment </button>\n"
        + "<button type='submit' class='btn btn-default' formaction='cancel1'>Cancel Event  </button>\n"  +
"      </div>\n" +
"    </div>\n"+
"       </form>\n" +
        "</div>"
        + "</font>");
            
            }
            catch(Exception e)
            {
               
                //request.getRequestDispatcher("customerstatus").forward(request,response);
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

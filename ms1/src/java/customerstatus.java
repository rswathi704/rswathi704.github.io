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
public class customerstatus extends HttpServlet {

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
        
            
             out.println("<nav class=\"navbar navbar-expand-sm bg-light navbar-light\">\n" +
"  <div class=\"container-fluid\">\n" +
"   \n" +
"     <ul class=\"nav nav-tabs nav-justified\">\n" +
"      \n" +
"      <li><a href=\"home\"><b><font color='lightgrey'>Home</font></b></a></li>\n" +
"      <li><a href=\"eventbooking\"><b><font color='lightgrey'>Book an Event</font></b></a></li>\n" +
"      <li  class=\"active\"><a href=\"#\"><b><font color='lightgrey'>Booking Status</font></b></a></li>\n" +
"      <li><a href=\"feedback.html\"><b><font color='lightgrey'>Feedback</font></b></a></li>\n" +
"      <li><a href=\"viewvenue.html\"><b><font color='lightgrey'>View Venue</font></b></a></li>\n" +
"      <li><a href=\"logout\"><b><font color='lightgrey'>Logout</font></b></a></li>\n" +
"    </ul>\n" +
"  </div>\n" +
"</nav>\n" );
            
         try
         {
             //userid from customer
            HttpSession session = request.getSession(false);
            int userid=(int)session.getAttribute("userid");
              Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","");
               PreparedStatement ps=con.prepareStatement("select * from customerreg where userid=?");
                   
               
               PreparedStatement ps1=con.prepareStatement("select bookingid from bookanevent where userid=?");
               ps1.setInt(1,userid);
               ResultSet rs1=ps1.executeQuery();
               while(rs1.next())
               {
               out.println("<font color='white' size='2'>Your Booking id: "+rs1.getInt(1)+"<br> " +"</font>");
               }
               
         }
               
               catch(Exception e)
               {
                   out.println(e);
               }
               
          out.println("<center> <font size='7' face='cooper' color='lightgrey'> BOOKING STATUS </font></center><br>");
            out.println("<font color='lightgrey'> <div class='container'>"); 
            out.println("<form class='form-horizontal' action='customerstatus1'>\n" +
"    <div class='form-group'>\n" +
"      <label class='control-label col-md-4' for='bid'>Booking ID:</label>\n" +
"      <div class='col-md-5'>\n" +
"          <input type='text' class='form-control' id='bid' autocomplete='off' placeholder='Enter User ID' name='bid' required='required'>\n" +
"      </div>\n" +
"    </div>\n" +
              "    <div class='form-group'> " +
"      <div class='col-md-offset-6 col-md-10'>" +
"        <input type='submit' class='btn btn-default' value='OK'>\n" +
"      </div>\n" +
"    </div>"+
                   "</form>"+
            "</div>"
                    + "</font>");
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

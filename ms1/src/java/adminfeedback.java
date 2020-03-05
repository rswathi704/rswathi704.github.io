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

/**
 *
 * @author khsci5mca17062
 */
public class adminfeedback extends HttpServlet {

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
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>");
         
            out.println("</head>");
            out.println("<body background='image/feed1.jpeg' style='background-repeat: no-repeat;background-size: cover;'>");
            
           out.println(" <nav class=\"navbar navbar-expand-sm bg-light navbar-light\">\n" +
"  <div class=\"container-fluid\">\n" +
"     <ul class=\"nav nav-tabs nav-justified\">\n" +
"      <li><a href=\"addvenue.html\"><b><font color='lightgrey'>Add Venue</font></b></a></li>\n" +
"      <li><a href=\"adminstatus\"><b><font color='lightgrey'>View Booking</font></b></a></li>\n" +
"      <li><a href=\"adminvenue\"><b><font color='lightgrey'>View Venue</font></b></a></li>\n" +
"      <li class=\"active\"><a href=\"#\"><b><font color='lightgrey'>View Feedback</font></b></a></li>\n" +
"      <li><a href=\"logout\"><b><font color='lightgrey'>Logout</font></b></a></li>\n" +
"    </ul>\n" +
"  </div>\n" +
"</nav>");
           out.println("<center>");
           out.println("<font size='7' color='lightgrey' face='cooper'> FEEDBACK </font><br> <br> <br> <br>");
           out.println("<font size='3' color='lightgrey' face='cooper'>");
             try 
             {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/event", "root",""); 
                
                PreparedStatement ps = con.prepareStatement("select * from feedback");
                ResultSet rs=ps.executeQuery();
                
                out.println("<div class=\"container\">\n" +
"  <table class=\"table\">\n" +

"    <tbody>\n" +
"      <tr>\n"
                        + "<th color='lightgrey'> BookingID </th>"
                        + "<th color='lightgrey'> Eventtype </th>"
                        + "<th color='lightgrey'> VenueName </th>"
                        + "<th color='lightgrey'> FeedBack </th> </tr>" );
               
                
                while(rs.next())
                {
                out.println("<tr> "
                        + "<td>"+rs.getInt(1)+"</td>"
                                + "<td>"+rs.getString(2)+"</td>"
                                        + "<td>"+rs.getString(3) +"</td>"
                                                + "<td>"+rs.getString(4)+"</td>"
+"      </tr>\n" );
                }
                out.println("    </tbody>\n" +
"  </table>\n" +
"</div>"); 
               
                out.println("</font>"); 
                
                 out.println("</center>");
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

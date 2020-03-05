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

/**
 *
 * @author khsci5mca17062
 */
public class adminvenue extends HttpServlet {

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
            out.println("<body style='background-repeat: no-repeat;background-size: cover;>");
            out.println("<nav class=\"navbar navbar-expand-sm bg-light navbar-light\">\n" +
"  <div class='container-fluid'>\n" +

"     <ul class='nav nav-tabs nav-justified'>\n" +

"    <li><a href=\"addvenue.html\"><b><font color='grey'>Add Venue</font></b></a></li>\n" +
"      <li><a href=\"adminstatus\"><b><font color='grey'>View Booking</font></b></a></li>\n" +
"      <li class=\"active\"><a href=\"#\"><b><font color='grey'>View Venue</font></b></a></li>\n" +
"      <li><a href=\"adminfeedback\"><b><font color='grey'>View Feedback</font></b></a></li>\n" +
"      <li><a href=\"logout\"><b><font color='grey'>Logout</font></b></a></li>\n" +
"    </ul>\n" +
"  </div>\n" +
"</nav>\n" );
             
               out.println("<center> <br> <br><font size=\"7\" color=\"grey\" face=\"cooper\" >VIEW VENUE </font>\n" +
" <br> <br> <br>\n" );
             try{
               
               Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event","root","");
               PreparedStatement ps=con.prepareStatement("select venuename,address,mobile,capacity,cost from addvenue");
               ResultSet rs=ps.executeQuery();
               
                  out.println("<br><br> <br>"+
                           "<b><font color=\"grey\" size='3' face=\"Lucida Calligraphy\" ><div class=\"container\">\n" +
"  <table class=\"table\">" + 
"    <thead>\n" +
"    </thead>\n" +
"    <tbody>\n" +
"      <tr>\n" +
                    "<th> Name </th> "+
                    "<th> Address </th>"+
                    "<th> Phone No. </th>"+
                    "<th> Capacity </th>"+
                    "<th> Cost </th>"+
                    "</tr>");
                  while(rs.next())
                {
                    
                   out.println("<tr>"+
                    "<td>"+rs.getString(1)+"</td>\n" +
                    "<td>"+rs.getString(2)+"</td>\n" +
                    "<td>"+rs.getString(3)+"</td>\n" +
                    "<td>"+rs.getInt(4)+"</td>\n" + 
                    "<td>"+rs.getInt(5)+"</td> </tr> ");
                }
                           out.println("</tbody>\n" +
                           "</table>"
                                   + "</div>"
                                   + "</b></font>" );
                   
                
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

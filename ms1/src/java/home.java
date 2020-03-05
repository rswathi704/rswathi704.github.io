/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author khsci5mca17062
 */
public class home extends HttpServlet {

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
            out.println("<body background='image/bg.jpeg' style='background-repeat: no-repeat;background-size: cover;'>");
            
            
            try
            {
                out.println("<nav class=\"navbar navbar-expand-sm bg-light navbar-light\">");
            out.println("<div class='container-fluid'>"
      +" <ul class='nav nav-tabs nav-justified'>"
      
     +" <li class='active'><a href='#'><b><font color='grey'>Home</font></b></a></li>"
     +" <li><a href='eventbooking'><b><font color='grey'>Book an Event</font></b></a></li>"
     +" <li><a href='customerstatus'><b><font color='grey'>Booking Status</font></b></a></li>"
      +"<li><a href='feedback.html'><b><font color='grey'>Feedback</font></b></a></li>"
      +"<li><a href='viewvenue.html'><b><font color='grey'>View Venue</font></b></a></li>"
      +"<li><a href='logout'><b><font color='grey'>Logout</font></b></a></li>"
    +"</ul>"
  +"</div>");
              
            out.println("</nav>"); 
            
                HttpSession session=request.getSession(false);
                int userid=(int)session.getAttribute("userid");
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event","root","");
                PreparedStatement ps=con.prepareStatement("select name from customerreg where userid=?");
                ps.setInt(1,userid);
                ResultSet rs=ps.executeQuery();
                rs.next();
                
               
      
                out.println("<br><br><h2><center><font face='Times New Roman' color='#303030' size='8'>Welcome "+rs.getString(1)+
                        " to Ivy and Fairy Lights Events. Your customer id is:<b> "+userid+"</b></font></center></h2>");
                out.println("<br><br><br><br><br><br><br><br>");
            
       
                 out.println("<br><br><br><br><br>"
                         + "<b><font face='Monotype Corsiva' size='5'><a href='mydetails'>Change Details </a></font></b><br>");
                out.println("<b><font face='Monotype Corsiva' size='5'> <a href='changepassword.html'>Change Password </a> </font></b>");
                
            }
            catch(Exception e)
            {
                
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

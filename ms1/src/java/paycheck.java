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
import javax.servlet.http.HttpSession;

/**
 *
 * @author khsci5mca17062
 */
public class paycheck extends HttpServlet {

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
            
          /* out.println("<nav class=\"navbar navbar-inverse\">\n" +
"  <div class=\"container-fluid\">\n" +
"   \n" +
"     <ul class=\"nav nav-tabs nav-justified\">\n" +
"      \n" +
"      <li><a href=\"addvenue.html\">Add Venue</a></li>\n" +
"      <li><a href=\"adminstatus\">View Booking</a></li>\n" +
"      <li><a href=\"adminvenue\">View Venue</a></li>\n" +
"      <li><a href=\"adminfeedback\">View Feedback</a></li>\n" +
"      <li><a href=\"logout\">Logout</a></li>\n" +
"    </ul>\n" +
"  </div>\n" +
"</nav>\n" );  */
             
            try
            {
                  
                 int bid=Integer.parseInt(request.getParameter("bid"));
                     
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","");
                
                PreparedStatement ps1=con.prepareStatement("select flag from bookanevent where bookingid=?");
                ps1.setInt(1,bid);
                ResultSet rs1=ps1.executeQuery();
                rs1.next();
                int flag=rs1.getInt(1);
                
                if(flag==0)
                {
                      
                      
                      out.println("<script> alert('Payment not done yet!') </script>");
                      request.getRequestDispatcher("adminstatus").include(request, response);
                }
                
                else
                {
                PreparedStatement ps=con.prepareStatement("select payment_status from paid_customer where bookingid=?");
                ps.setInt(1, bid);
                ResultSet rs=ps.executeQuery();
                rs.next();
                String status=rs.getString(1);
                  
               
                /*out.println("<a href='adminstatus'> <b>Home </b></a>");
                  out.println(
"       <center> <font size=\"7\" color='#77AED4' face=\"cooper\" >Payment Confirmation </font>\n" +
"           <br> <br> <br>\n" +
"        <div class=\"container\">\n");*/
                  
                     
                if(status.equals("Paid"))
                {
                     out.println("<h2>The customer has paid his total amount.</h2>");
                    
                }
                if(status.equals("Advance Payment"))
                {
                    out.println(" <center> <font size='7' color='#77AED4' face='cooper' >Payment Confirmation </font>" 
                            + "<h2>The customer has paid only partial amount. </h2>");
                  
                      out.println("<br> <br> <br> <br><div class=\"container\">\n" +
"    <form class='form-horizontal' action='paymentconfirmation'>\n" +
        "    <div class='form-group'>\n" +
"      <div class='col-md-offset-1 col-md-10'>\n" +
"        <input type='submit' class='btn btn-default' value='Paid'>\n" +
"      </div>\n" +
"    </div>\n"+
"       </form>\n" +
        "</div>");
                }
                if(status.equals("Cash"))
                {
                    out.println("<center> <font size='7' color='#77AED4' face='cooper' >Payment Confirmation </font>" 
                            +"<script>alert('The customer has opted cash payment and not paid yet.')</script");
                    
                    out.println(" <br> <br> <br> <br><div class=\"container\">\n" +
"    <form class='form-horizontal' action='paymentconfirmation'>\n" +
        "    <div class='form-group'>\n" +
"      <div class='col-md-offset-1 col-md-10'>\n" +
"        <input type='submit' class='btn btn-default' value='Paid'>\n" +
"      </div>\n" +
"    </div>\n"+
"       </form>\n" +
        "</div>");
                }
                if(status.equals("Card"))
                {
                    out.println("<script>alert('The customer has paid his total amount through card.')</script>");
                            request.getRequestDispatcher("adminstatus").include(request,response);
                }
                ps.close();
                }
                
           
                
             ps1.close();
             con.close();
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

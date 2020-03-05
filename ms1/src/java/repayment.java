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
public class repayment extends HttpServlet {

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
            out.println("<body background='image/repayment.jpeg'>");
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
"</nav>\n" );*/
            try
            {
                int bid=Integer.parseInt(request.getParameter("bid"));
               
                HttpSession session=request.getSession();
                session.setAttribute("booid",bid);
                
                
                 Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event","root","");
              
               
                   PreparedStatement ps2 = con.prepareStatement("select flag from paid_customer where bookingid=?");
                ps2.setInt(1,bid);
                ResultSet rs2=ps2.executeQuery();
                rs2.next();
                int flag=rs2.getInt(1);
                
                out.println(flag);
                if(flag==1)
                {
                     PreparedStatement ps=con.prepareStatement("select card_no from admin_card");
               ResultSet rs=ps.executeQuery();
               rs.next();
               
                 PreparedStatement ps1=con.prepareStatement("select card_no,card_holder_name,amount from payment where bookingid=?");
                 ps1.setInt(1,bid);
               ResultSet rs1=ps1.executeQuery();
               rs1.next();
               
                     out.println("<a href='adminstatus'> <b>Home </b></a>");
                out.println("<center> <font size=\"7\" color=\"grey\" face=\"cooper\" >RE-PAYMENT </font>\n"
                        + "<font size=\"2\" color=\"grey\"  >"+
"        <br><br><br>\n" +
"<div class=\"container\">\n" +
"    \n" +
"   \n" +
"  <form class=\"form-horizontal\">\n" +
"    <div class=\"form-group\">\n" +
"      <label class=\"control-label col-md-4\" for=\"acardno\">Account to be debited:</label>\n" +
"      <div class=\"col-md-5\">\n" +
"        <input type=\"text\" class=\"form-control\" id=\"acardno\" value='"+rs.getString(1)+"' name=\"acardno\">\n" +
"      </div>\n" +
"    </div>\n" +
"   \n" +
"      <div class=\"form-group\">\n" +
"      <label class=\"control-label col-md-4\" for=\"name\">Beneficiary Name:</label>\n" +
"      <div class=\"col-md-5\">\n" +
"        <input type=\"text\" class=\"form-control\" id=\"name\" placeholder=\"Enter Name\" name=\"name\" value='"+rs1.getString(2)+"'>\n" +
"      </div>\n" +
"    </div>\n" +
"       <div class=\"form-group\">\n" +
"      <label class=\"control-label col-md-4\" for=\"credit\">Account to be credited:</label>\n" +
"      <div class=\"col-md-5\">          \n" +
"        <input type=\"text\" class=\"form-control\" id=\"credit\" placeholder=\"Account to be credited\" name=\"credit\" value='"+rs1.getString(1)+"'>\n" +
"      </div>\n" +
"    </div>\n" +
"      <div class=\"form-group\">\n" +
"      <label class=\"control-label col-md-4\" for=\"amnt\">Amount:</label>\n" +
"      <div class=\"col-md-5\">\n" +
"        <input type=\"text\" class=\"form-control\" id=\"amnt\" placeholder=\"Enter Amount\" name=\"amnt\" value='"+rs1.getInt(3)+"'>\n" +
"      </div>\n" +
"    </div>\n" +
"      \n" +
"    <div class=\"form-group\">        \n" +
"      <div class=\"col-md-offset-1 col-md-10\">\n" +
"        <button type=\"submit\" class=\"btn btn-default\" formaction='repayment1'>Continue</button>\n" +
"   \n" +
"      </div>\n" +
"    </div>\n" +
"  </form>\n" +
"        \n" +
"       \n" +
"</div>     \n"
        + " </font>"+
"       </center>");
            }
              else
                {
                    out.println("<script>alert('Repayment already done')</script>");
                    request.getRequestDispatcher("eventcancel").include(request,response);
                }
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
